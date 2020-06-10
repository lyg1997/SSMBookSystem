package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import po.CustomPO.TbLibraryQuery;
import po.CustomPO.TblibraryExt;
import po.PageCount;
import po.TbCategory;
import service.LibraryCategoryService;
import service.LibraryService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IframeController {

    @Autowired
    private LibraryCategoryService libraryCategoryService;
    @Autowired
    private LibraryService libraryService;

    @RequestMapping("/admin/{adminPage}")
    public String admin(@PathVariable String adminPage, HttpSession session) throws Exception {
        if (session.getAttribute("categoryAll") == null) {
            // 图书类目 ,设置到 session 中
            List<TbCategory> categoryAll = libraryCategoryService.getCategoryAll();
            session.setAttribute("categoryAll", categoryAll);
        }

        return "admin/" + adminPage;

    }

    @RequestMapping("/user/{userPage}")
    public String user(@PathVariable String userPage, HttpSession session, Model model) throws Exception {
        // 获取图书类目信息
        List<TbCategory> categoryAll = libraryCategoryService.getCategoryAll();
        session.setAttribute("userCategoryAll", categoryAll);

        //
        TbLibraryQuery libraryQuery = new TbLibraryQuery();
        libraryQuery.setCateId(0);
        libraryQuery.setBookname("");
        // 將图书 設置到 域中
        PageCount<TblibraryExt> libraryPageCount = libraryService.findLibraryByAll(libraryQuery, null);

        // 查询所有 类目 父 id 为 0 的
        List<TbCategory> subCategoryList = libraryCategoryService.getCategoryByParentId(0);

        model.addAttribute("libraryPageCount", libraryPageCount);
        model.addAttribute("subCategoryList", subCategoryList);
        session.setAttribute("currentCategory", 0);

        return "user/" + userPage;
    }

    @RequestMapping("/{loginPage}")
    public String index(@PathVariable String loginPage) throws Exception {
        return loginPage;
    }
}


