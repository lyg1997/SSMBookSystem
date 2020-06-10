package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.*;
import mapper.CustomMapper.TbLibraryAndManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import po.*;
import po.CustomPO.BookExt;
import po.CustomPO.TbLibraryQuery;
import po.CustomPO.TblibraryExt;
import service.LibraryService;
import utils.UploadFileUtilsByBook;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// 图书服务实现类


@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private TbLibraryAndManagerMapper libraryAndManagerMapper;
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

    @Value("${CURRENT_PAGE}")
    private String CURRENT_PAGE;
    @Value("${PAGE_ROWS}")
    private String PAGE_ROWS;
    @Value("${FILE_SAVE_PATH}")
    private String FILE_SAVE_PATH;


    @Override
    public PageCount<TblibraryExt> findLibraryByAll(TbLibraryQuery tbLibraryQuery, PageCount pageCount) {
        //  判断分页数据有效
        if (tbLibraryQuery == null) {
            tbLibraryQuery = new TbLibraryQuery();
            tbLibraryQuery.setBookname("");
        }

        if (pageCount == null) {
            pageCount = new PageCount();
            pageCount.setCurrentPage(Integer.parseInt(CURRENT_PAGE));
            pageCount.setPageRows(Integer.parseInt(PAGE_ROWS));
        }
        if (pageCount.getCurrentPage() == null) {
            pageCount.setCurrentPage(Integer.parseInt(CURRENT_PAGE));
        }
        if (pageCount.getPageRows() == null) {
            pageCount.setPageRows(Integer.parseInt(PAGE_ROWS));
        }

        PageHelper.startPage(pageCount.getCurrentPage(), pageCount.getPageRows());

        List<TblibraryExt> tblibraryExts = new ArrayList<>();
        // 判断是否为 0
        if (tbLibraryQuery.getCateId() == 0) {
            // 获取图书列表
            tblibraryExts = libraryAndManagerMapper.findAll(tbLibraryQuery);
        } else {
            // 获取图书列表
            tblibraryExts = libraryAndManagerMapper.findLibraryByCriteria(tbLibraryQuery);
        }

        // 获取页数,查询记录数 的详细信息
        PageInfo<TblibraryExt> pageInfo = new PageInfo<>(tblibraryExts);
        pageCount.setTotalPages(pageInfo.getPages());
        pageCount.setTotalRows(pageInfo.getTotal());
        pageCount.setContentList(tblibraryExts);
        return pageCount;
    }

    @Override
    public TbLibrary findLibraryByBid(int id) {
        // 通过 主键id 查询图书信息
        return libraryMapper.selectByPrimaryKey(id);
    }

    @Override
    public String updateOrSaveLibrary(MultipartFile uploadFile, TbLibrary library, HttpServletRequest request) throws IOException {
        // 上传文件保存路径
        String FILE_SAVE_PATH=request.getSession().getServletContext().getRealPath("/upload/book");;
        String fileSavePath = UploadFileUtilsByBook.updateLibrary(uploadFile, FILE_SAVE_PATH);
        // 修改图书信息
        library.setImg(fileSavePath);
        // 对图书操作进行判断.若有id 则进行修改操作,否则添加操作
        if (library.getId() != null) {
            // 修改图书信息,修改不为空的
            libraryMapper.updateByPrimaryKeySelective(library);
        } else {
            library.setCreatedate(System.currentTimeMillis() / 1000);
            library.setPublishdate(System.currentTimeMillis() / 1000);
            libraryMapper.insert(library);
        }
        return fileSavePath;
    }

    @Override
    public void delBookById(int id) {
        // 删除订单表
        TbOrderExample orderExample = new TbOrderExample();
        orderExample.createCriteria().andBookIdEqualTo(id);
        orderMapper.deleteByExample(orderExample);

        // 删除预约表
        TbRecordExample recordExample = new TbRecordExample();
        recordExample.createCriteria().andBookIdEqualTo(id);
        recordMapper.deleteByExample(recordExample);

        // 查询评论表,图书表关联评论表
        TbCommentExample commentExample = new TbCommentExample();
        commentExample.createCriteria().andBookIdEqualTo(id);
        // 获取评论集合
        List<TbComment> commentList = commentMapper.selectByExample(commentExample);
        // 遍历
        for (TbComment tbComment : commentList) {
            TbReplyExample replyExample = new TbReplyExample();
            replyExample.createCriteria().andCommentIdEqualTo(tbComment.getId());
            // 删除评论数据关联的reply表数据
            replyMapper.deleteByExample(replyExample);
        }
        // 删除评论数据
        commentMapper.deleteByExample(commentExample);
        // 删除图书
        libraryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public BookExt getBookInfoById(int id) {
        TbLibrary library = libraryMapper.selectByPrimaryKey(id);

        // 将查询数据填充到扩展类中
        BookExt bookExt = new BookExt();
        bookExt.setLibrary(library);

        return bookExt;
    }

    @Override
    public void addCommentInfo(TbComment comment) {
        // 设置插入时间
        comment.setCommentdate(System.currentTimeMillis() / 1000);

        commentMapper.insert(comment);
    }


    @Override
    public void jieyueBookById(TbOrder order) {
        Long currentTimeS = System.currentTimeMillis() / 1000;
        order.setOrderdate(currentTimeS); //预约借阅时间
        order.setDeadline(currentTimeS + 3 * 30 * 24 * 60 * 60);
        orderMapper.insert(order);
    }


}
