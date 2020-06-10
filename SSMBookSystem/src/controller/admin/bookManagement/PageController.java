package controller.admin.bookManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import po.CustomPO.TbLibraryQuery;
import po.CustomPO.TblibraryExt;
import po.PageCount;
import po.TbLibrary;
import service.LibraryCategoryService;
import service.LibraryService;


/**
 * @description: 列表页面显示
 */

@Controller
@RequestMapping("/admin/ch")
public class PageController {
    // 注入
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private LibraryCategoryService libraryCategoryService;

    /**
     * 查询图书列表
     *
     * @param model
     * @param tbLibraryQuery
     * @param pageCount
     * @return
     */
    @RequestMapping(value = "/loan_bookList", method = RequestMethod.GET)
    public String showBookListPage(Model model, TbLibraryQuery tbLibraryQuery, PageCount pageCount) {
        // 判断数据有效性
        if (tbLibraryQuery != null) {
            tbLibraryQuery.setCateId(0);
        }

        PageCount<TblibraryExt> libraryPageCount = libraryService.findLibraryByAll(tbLibraryQuery, pageCount);
        model.addAttribute("libraryPageCount", libraryPageCount);

        return "/admin/loan_bookList";
    }

    /**
     * 图书编辑页面跳转
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/toEditPage", method = RequestMethod.GET)
    public String toBookEditPage(Model model, int id) {
        // 查询的 图书
        TbLibrary library = libraryService.findLibraryByBid(id);

        // 向域中 添加 属性library
        model.addAttribute("library", library);

        return "/admin/loan_editBook";
    }

    @RequestMapping(value = "/loan_BookClassify", method = RequestMethod.GET)
    public String showBookCateListPage(Model model, PageCount pageCount) {

        // 获取 商品信息,附带 父类目名称
        pageCount = libraryCategoryService.getCategoryAllWithParentName(pageCount);

        // 设置信息到 域 中
        model.addAttribute("pageCount", pageCount);

        return "admin/loan_BookClassify";
    }
}
