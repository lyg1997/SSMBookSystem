package controller.admin.bookManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import po.TbCategory;
import service.LibraryCategoryService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description: 图书类别处理
 */
@Controller
@RequestMapping("/admin/ch/category")
public class CategoryController {
    //注入
    @Autowired
    private LibraryCategoryService libraryCategoryService;

    /**
     * 添加 图书类目
     *
     * @param category 图书类目信息
     * @return url
     */
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(TbCategory category, HttpSession session, Model model) {
        List<TbCategory> categoryList = libraryCategoryService.getCategoryAll();
        boolean is = false;
        for (TbCategory tbCategory : categoryList) {
            if (category.getCatname().equals(tbCategory.getCatname())) {
                is = true;
                break;
            }
        }
        if (!is) {
            // 添加 数据到 数据库,并 修改 父类目
            libraryCategoryService.addBookCategory(category, session);
        } else {
            model.addAttribute("errorMsg", "类目已经存在");
            return "errorMsg";
        }
        return "redirect:/admin/ch/loan_BookClassify.action";
    }

    /**
     * 删除类目信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delCategory", method = RequestMethod.GET)
    public String delCategory(int id) {

        // 通过 类目id 删除数据
        libraryCategoryService.delBookCategoryById(id);

        return "redirect:/admin/ch/loan_BookClassify.action";
    }

    /**
     * 修改 类目关系
     *
     * @param category
     * @return
     */
    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    public String updateCategory(TbCategory category) {

        return "redirect:/admin/ch/loan_BookClassify.action";
    }

    @RequestMapping("/toUpdatePage")
    @ResponseBody
    public TbCategory toUpdatePage(int id) {
        return libraryCategoryService.getCategoryById(id);
    }
}
