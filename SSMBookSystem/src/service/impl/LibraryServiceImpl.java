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

/**
 * @description: 图书服务实现类
 *
 */

@Service
public class LibraryServiceImpl implements LibraryService {
    // 注入
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
    private String CURRENT_PAGE;    // 默认 当前页数
    @Value("${PAGE_ROWS}")
    private String PAGE_ROWS;       // 默认 每页显示记录数
    @Value("${FILE_SAVE_PATH}")     // 默认 上传文件保存路径
    private String FILE_SAVE_PATH;


    @Override
    public PageCount<TblibraryExt> findLibraryByAll(TbLibraryQuery tbLibraryQuery, PageCount pageCount) {
        // 判断 分页数据的 有效性
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

        // 获取 页数,查询记录数 的详细信息
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
        // 上传文件保存 路径
        String FILE_SAVE_PATH=request.getSession().getServletContext().getRealPath("/upload/book");;
        String fileSavePath = UploadFileUtilsByBook.updateLibrary(uploadFile, FILE_SAVE_PATH);
        // 修改 图书信息
        library.setImg(fileSavePath);

        // 对图书操作进行判断.若 有id 则 进行 修改操作,否则 添加 操作
        if (library.getId() != null) {
            // 修改图书信息,修改 不为空的
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
        // 删除 订单表
        TbOrderExample orderExample = new TbOrderExample();
        orderExample.createCriteria().andBookIdEqualTo(id);
        orderMapper.deleteByExample(orderExample);

        // 删除 预约表
        TbRecordExample recordExample = new TbRecordExample();
        recordExample.createCriteria().andBookIdEqualTo(id);
        recordMapper.deleteByExample(recordExample);

        // 查询 评论表,图书表关联评论表
        TbCommentExample commentExample = new TbCommentExample();
        commentExample.createCriteria().andBookIdEqualTo(id);
        // 获取 评论集合
        List<TbComment> commentList = commentMapper.selectByExample(commentExample);
        // 遍历
        for (TbComment tbComment : commentList) {
            TbReplyExample replyExample = new TbReplyExample();
            replyExample.createCriteria().andCommentIdEqualTo(tbComment.getId());
            // 删除 评论数据关联 的 reply 表数据
            replyMapper.deleteByExample(replyExample);
        }
        // 删除 评论数据
        commentMapper.deleteByExample(commentExample);

        // 删除图书
        libraryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public BookExt getBookInfoById(int id) {
        TbLibrary library = libraryMapper.selectByPrimaryKey(id);

        // 判断图书的有效性

/*      同一异常处理再说
        if (library == null) {
        }
*/
        // 将查询数据填充 到 扩展类中
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
        order.setOrderdate(currentTimeS); //预约 借阅时间
        order.setDeadline(currentTimeS + 3 * 30 * 24 * 60 * 60); //预约 3个月天 时间
        orderMapper.insert(order);
    }


}
