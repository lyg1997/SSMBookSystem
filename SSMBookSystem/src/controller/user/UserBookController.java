package controller.user;

import mapper.TbOrderMapper;
import mapper.TbRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.*;
import po.CustomPO.BookExt;
import po.CustomPO.CommentExt;
import po.CustomPO.TbLibraryQuery;
import po.CustomPO.TblibraryExt;
import service.CommentService;
import service.LibraryCategoryService;
import service.LibraryService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description: 前台页面列表显示处理
 */

@Controller
@RequestMapping("/user/ch")
public class UserBookController {
    // 注入
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private LibraryCategoryService libraryCategoryService;
    @Autowired
    private CommentService commentService;

    @Autowired
    private TbOrderMapper orderMapper;
    @Autowired
    private TbRecordMapper recordMapper;

    @Value("${LOGIN_USER}")
    private String LOGIN_USER;  // 当前登录用户的 session 存储 属性名

    @RequestMapping("/user_bookList")
    public String toLibraryListByCid(TbLibraryQuery libraryQuery, PageCount pageCount, Model model, HttpSession session) {
        if (libraryQuery == null || libraryQuery.getCateId() == null) {
            libraryQuery = new TbLibraryQuery();
            libraryQuery.setCateId((Integer) session.getAttribute("currentCategory"));
        }
        // 根据 类目 id
        // 若 当前 类目 为 父类目 则获取 其 下面 的 所有子类目
        // 若 当前 类目 为 子类目 则获取 其 同级 类目
        List<TbCategory> categoryList = libraryCategoryService.getCategoryByCid(libraryQuery.getCateId());

        // 获取当前类目信息
        TbCategory currentCategory = libraryCategoryService.getCategoryById(libraryQuery.getCateId());

        // 按照条件进行查询
        PageCount<TblibraryExt> libraryPageCount = libraryService.findLibraryByAll(libraryQuery, pageCount);
        // model 将数据设置到域中
        model.addAttribute("subCategoryList", categoryList);
        model.addAttribute("libraryPageCount", libraryPageCount);
        // 默认
        if (currentCategory == null) {
            currentCategory = new TbCategory();
            currentCategory.setId(0);
        }
        session.setAttribute("currentCategory", currentCategory.getId());

        return "/user/user_bookList";
    }

    /**
     * 通过 图书 id 查询 图书详细信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/bookId")
    public String toBookInfo(int id, Model model) {
        BookExt bookInfo = libraryService.getBookInfoById(id);
        // 将 时间戳 进行转换
        Long dateSS = bookInfo.getLibrary().getCreatedate();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formatDate = simpleDateFormat.format(new Date(dateSS * 1000));

        bookInfo.setFormatDate(formatDate);

        // 通过 图书id 获取 回复信息
        List<CommentExt> commentExts = commentService.findCommentByBookId(id);

        // 将 查询的 图书信息 设置到 域 中
        model.addAttribute("bookInfo", bookInfo);
        // 将 回复信息 设置到 域 汇总
        model.addAttribute("commentExts", commentExts);

        return "/user/bookDetail";
    }

    /**
     * 用于 借阅 图书  操作
     *
     * @param session 用于 取 用户信息
     * @param order   用户借阅关联信息
     * @return
     */
    @RequestMapping("/jieyue_book")
    public String jieyueBook(HttpSession session, Model model, String oid, String kkid, TbOrder order) {

        if (null != kkid) {
            TbRecord tbRecord = recordMapper.selectByPrimaryKey(Integer.valueOf(kkid));
            tbRecord.setReturnbook(2); //2代表挂失
            recordMapper.updateByPrimaryKey(tbRecord);
            model.addAttribute("successMsg", "图书挂失成功");
            return "errorMsg";
        }


        if (null != oid) {
            TbRecord tbOrder = recordMapper.selectByPrimaryKey(Integer.valueOf(oid));
            // 插入数据
            tbOrder.setBackdate(tbOrder.getBackdate() + 3 * 30 * 24 * 60 * 60);
            recordMapper.updateByPrimaryKey(tbOrder);
            model.addAttribute("successMsg", "续借三个月成功");
            return "errorMsg";
        }
        // 获取 session 中的用户信息
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        TbUser tbUser = new TbUser();
        tbUser.setId(activeUser.getUserid());
        order.setUserId(tbUser.getId());

        // 插入数据
        libraryService.jieyueBookById(order);

        return "redirect:/user/ch/bookId.action?id=" + order.getBookId();
    }


    @RequestMapping("/commitInfo")
    @ResponseBody
    public String commitComment(HttpSession session, TbComment comment) {
        // 获取 session 中的用户信息
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        TbUser tbUser = new TbUser();
        tbUser.setId(activeUser.getUserid());

        comment.setUserId(tbUser.getId());
        libraryService.addCommentInfo(comment);

        return "ok";
    }
}
