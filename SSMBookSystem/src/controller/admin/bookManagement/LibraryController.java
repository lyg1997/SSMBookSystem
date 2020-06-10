package controller.admin.bookManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import po.*;
import service.LibraryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @description: 图书操作
 */
@Controller
@RequestMapping("/admin/ch")
public class LibraryController {
    //注入
    @Autowired
    private LibraryService libraryService;



    /**
     * 修改图书信息
     *
     * @param uploadFile 上传图片
     * @param library    图书信息
     * @return
     */
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBook(MultipartFile uploadFile, TbLibrary library, HttpServletRequest request) {
        try {
            libraryService.updateOrSaveLibrary(uploadFile, library,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/ch/loan_bookList.action";
    }

    /**
     * 添加图书
     *
     * @param uploadFile 上传图片
     * @param library    图书信息
     * @return
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(MultipartFile uploadFile, TbLibrary library, HttpSession session,HttpServletRequest request) {
        ActiveAdmin activeAdmin = (ActiveAdmin) session.getAttribute("activeAdmin");
        library.setManagerId(activeAdmin.getUserid());
        try {
            libraryService.updateOrSaveLibrary(uploadFile, library,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/ch/loan_bookList.action";
    }

    /**
     * 根据 图书id  删除 图书
     *
     * @param id 图书id
     * @return
     */
    @RequestMapping("/delBookById")
    public String delBook(int id) {
        libraryService.delBookById(id);
        return "redirect:/admin/ch/loan_bookList.action";
    }

}
