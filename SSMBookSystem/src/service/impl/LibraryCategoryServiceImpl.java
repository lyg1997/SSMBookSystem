package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import po.*;
import po.CustomPO.TbCategoryExt;
import service.LibraryCategoryService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description: 图书类目 服务接口实现类
 *
 */

@Service
public class LibraryCategoryServiceImpl implements LibraryCategoryService {
    //注入 服务接口
    @Autowired
    private TbCategoryMapper categoryMapper;
    @Autowired
    private TbLibraryMapper libraryMapper;
    @Autowired
    private TbCommentMapper commentMapper;
    @Autowired
    private TbOrderMapper orderMapper;
    @Autowired
    private TbRecordMapper recordMapper;
    @Autowired
    private TbReplyMapper replyMapper;

    // 注入值
    @Value("${NOT_PAREN_CATEGORY_INFO}")
    private String NOT_PAREN_CATEGORY_INFO; // 没有父类目的提示 信息

    @Value("${CURRENT_PAGE}")
    private String CURRENT_PAGE;            // 默认当前页

    @Value("${PAGE_ROWS}")
    private String PAGE_ROWS;               // 默认每页条数


    @Override
    public List<TbCategory> getCategoryAll() {
        // 设置查询条件
        TbCategoryExample categoryExample = new TbCategoryExample();
        // 执行查询
        return categoryMapper.selectByExample(categoryExample);
    }

    @Override
    public PageCount<TbCategoryExt> getCategoryAllWithParentName(PageCount pageCount) {
        // 设置查询条件
        TbCategoryExample categoryExample = new TbCategoryExample();
        // 判断页面参数 是否有效
        if (pageCount.getCurrentPage() == null) {
            pageCount.setCurrentPage(Integer.parseInt(CURRENT_PAGE));
        }
        if (pageCount.getPageRows() == null) {
            pageCount.setPageRows(Integer.parseInt(PAGE_ROWS));
        }

        // 分页插件
        PageHelper.startPage(pageCount.getCurrentPage(), pageCount.getPageRows());

        // 获取列表集合
        List<TbCategory> categoryList = categoryMapper.selectByExample(categoryExample);

        // 获取 分页详细信息
        PageInfo<TbCategory> pageInfo = new PageInfo<>(categoryList);
        // 数据总数
        pageCount.setTotalRows(pageInfo.getTotal());
        // 总页数
        pageCount.setTotalPages(pageInfo.getPages());


        // 扩展 pojo 封装
        List<TbCategoryExt> categoryExts = new ArrayList<>();

        // 遍历结合,进行扩展类的 封装填充
        for (TbCategory tbCategory : categoryList) {
            // 创建 扩展pojo 实例
            TbCategoryExt categoryExt = new TbCategoryExt();
            // 封装数据
            categoryExt.setTbCategory(tbCategory);
            //if (tbCategory.getParentId() != null) {
            if (tbCategory.getParentId() != 0) {
                // 获取类目 父id 的 类目信息
                TbCategory parentCategory = categoryMapper.selectByPrimaryKey(tbCategory.getParentId());
                // 将信息 设置到 扩展 pojo
                categoryExt.setParentName(parentCategory.getCatname());
                //}
            } else {
                categoryExt.setParentName(NOT_PAREN_CATEGORY_INFO);
            }

            // 添加到集合中
            categoryExts.add(categoryExt);
        }

        // 将 集合 设置到 pageCount
        pageCount.setContentList(categoryExts);

        return pageCount;
    }

    @Override
    public void addBookCategory(TbCategory category, HttpSession session) {
/*
        // 设置添加人
        TbUser admin = (TbUser) session.getAttribute("loginAdmin");

        // 设置添加人id
        category.setManagerId(admin.getId());*/
        category.setManagerId(1); // 测试

        // 设置添加时间
        category.setCreatedate(System.currentTimeMillis() / 1000);
        // 设置 是否为 父
        category.setIsParent(false);

        // 获取 添加 类目的 父类目
        int parentId = category.getParentId();
        if (parentId != 0) {
            // 创建 父类目 对象
            TbCategory parentCategory = new TbCategory();
            parentCategory.setId(parentId);
            parentCategory.setIsParent(true);
            // 修改父类目的 isParent 值
            categoryMapper.updateByPrimaryKeySelective(parentCategory);
        }

        //添加当前类目
        categoryMapper.insert(category);
    }

    @Override
    public void delBookCategoryById(int id) {
        // 通过 id 查询该 类目的 信息
        TbCategory category = categoryMapper.selectByPrimaryKey(id);

        // 判断 该类目是否是 父类目
        if (category.getIsParent()) {
            // 查询 当前类目的 子id
            // 创建查询条件
            TbCategoryExample categoryExample = new TbCategoryExample();
            categoryExample.createCriteria().andParentIdEqualTo(category.getId());
            // 进行 查询
            List<TbCategory> categoryList = categoryMapper.selectByExample(categoryExample); // 子类目
            // 遍历 删除子类目
            for (TbCategory tbCategory : categoryList) {
                delBookCategoryById(tbCategory.getId());
            }
        }

        // 获取 该 类目 下的 所有图书
        TbLibraryExample libraryExample = new TbLibraryExample();
        // 添加 条件
        libraryExample.createCriteria().andCateIdEqualTo(id);

        // 该类目下 所有的 图书
        List<TbLibrary> libraryList = libraryMapper.selectByExample(libraryExample);

        // 遍历图书列表 ,删除 关联信息
        for (TbLibrary library : libraryList) {
            // 获取 图书 id
            int libId = library.getId();

            // 删除 order 表中图书关联数据
            TbOrderExample orderExample = new TbOrderExample();
            orderExample.createCriteria().andBookIdEqualTo(libId);
            orderMapper.deleteByExample(orderExample);

            // 删除 record 表中图书关联数据
            TbRecordExample recordExample = new TbRecordExample();
            recordExample.createCriteria().andBookIdEqualTo(libId);
            recordMapper.deleteByExample(recordExample);

            // 通过 图书 id 查询 comment 中的 数据
            TbCommentExample commentExample = new TbCommentExample();
            commentExample.createCriteria().andBookIdEqualTo(libId);
            // 获取 图书 回复表信息
            List<TbComment> comments = commentMapper.selectByExample(commentExample);

            // 遍历图书 回复表信息
            for (TbComment comment : comments) {
                // 删除 reply 表中 comment 关联数据
                TbReplyExample replyExample = new TbReplyExample();
                replyExample.createCriteria().andCommentIdEqualTo(comment.getId());
                replyMapper.deleteByExample(replyExample);
            }
            // 删除 comment 表中 library 关联数据
            commentMapper.deleteByExample(commentExample);

            // 删除 library 表中的 数据
            libraryMapper.deleteByPrimaryKey(libId);
        }

        // 当前 类目为 子类目
        categoryMapper.deleteByPrimaryKey(id);

        // 获取当前类目的 父类目
        int parentId = category.getParentId();
        // 查询 父类目下的 子类目 个数
        TbCategoryExample categoryExample = new TbCategoryExample();
        categoryExample.createCriteria().andParentIdEqualTo(parentId); // 查询条件
        // 执行查询
        List<TbCategory> categoryList = categoryMapper.selectByExample(categoryExample);
        if (categoryList == null || categoryList.size() < 0) {
            // 创建 TbCategory
            TbCategory parentCategory = new TbCategory();
            //设置 属性
            parentCategory.setId(parentId);
            parentCategory.setIsParent(false);
            // 更新数据
            categoryMapper.updateByPrimaryKeySelective(parentCategory);
        }
    }

    @Override
    public void updateBookCategoryById(TbCategory category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public TbCategory getCategoryById(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbCategory> getCategoryByParentId(int parentId) {
        // 创建 查询对象
        TbCategoryExample categoryExample = new TbCategoryExample();
        // 添加查询条件
        categoryExample.createCriteria().andParentIdEqualTo(parentId);

        List<TbCategory> subCategoryList = categoryMapper.selectByExample(categoryExample);
        if (subCategoryList == null || subCategoryList.size() < 1) {
            return null;
        }

        return subCategoryList;
    }

    @Override
    public List<TbCategory> getCategoryByCid(int cid) {
        // 若 当前 类目id 为 0
        if (cid == 0) {
            TbCategoryExample categoryExample = new TbCategoryExample();
            return categoryMapper.selectByExample(categoryExample);
        }
        // 根据 类目id 获取 类目信息
        TbCategory category = categoryMapper.selectByPrimaryKey(cid);
        // 判断该 图书是否是 父类目
        if (category.getIsParent()) {
            // 获取 父类目 为当前 类目 的 所有 类目
            TbCategoryExample categoryExample = new TbCategoryExample();
            categoryExample.createCriteria().andParentIdEqualTo(cid);

            return categoryMapper.selectByExample(categoryExample);
        }
        int parentId = 0;
        // 获取当前类目的 父类目
        if (category.getParentId() != null) {
            parentId = category.getParentId();
        }
        // 获取 父类目下所有的 子类目信息
        TbCategoryExample categoryExample = new TbCategoryExample();
        categoryExample.createCriteria().andParentIdEqualTo(parentId);

        return categoryMapper.selectByExample(categoryExample);
    }
}
