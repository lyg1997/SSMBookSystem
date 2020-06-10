package controller.admin.userManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.CustomPO.TbUserQueryVo;
import po.TbUser;
import service.Loan_UserInfoList;

import java.util.List;

/**
 * 用户列表信息
 */

@Controller
@RequestMapping("/admin")
public class Loan_UserInfoController {
    @Autowired
    private Loan_UserInfoList loan_userInfoList;

    //查询用户信息列表
    @RequestMapping("/loan_userList")
    public String userList(Model model) {
        List<TbUser> userList = loan_userInfoList.findUserList();
/*        for(TbUser t : userList) {
            System.out.println(t);
        }*/
        model.addAttribute("userList", userList);
        return "admin/loan_userList";
    }

    //用户信息修改页面
    @RequestMapping("/loan_editUser")
    public String editUser(Integer id, Model model) {
        TbUser tbUser = loan_userInfoList.updataUserInfo(id);
        model.addAttribute("tbUser", tbUser);
        return "admin/loan_editUser";
    }

    //用户信息修改提交
    @RequestMapping("/editUser")
    public String editUser(TbUser tbUser, Model model) {
        int i = loan_userInfoList.editUser(tbUser);
        if (i > 0) {
            return "redirect:loan_userList.action";
        }
        //进行数据回显
        model.addAttribute("tbUser", tbUser);
        return "admin/loan_editUser";
    }

    //用户删除
    @RequestMapping("/loan_deleteUser")
    public String loan_deleteUser(Integer id) {
        int i = loan_userInfoList.deleteUser(id);
        if (i > 0) {
            return "redirect:loan_userList.action";
        }
        return "redirect:loan_userList.action";
    }

    //用户添加
    @RequestMapping("/loan_addUser")
    public String addUser(TbUser tbUser) {
        //注册时间
        tbUser.setRegisterdate(System.currentTimeMillis());
        //not online
        tbUser.setIsonline(0);
        tbUser.setPassword(tbUser.getUsername());
        int i = loan_userInfoList.addUser(tbUser);
        if (i > 0) {
            System.out.println("添加成功！");
            return "redirect:loan_userList.action";
        }

        return "redirect:loan_userList.action";
    }

    //用户列表模糊查询用户信息(用户名)
    @RequestMapping("/loan_selectLikeName")
    public String Loan_selectLikeName(TbUser tbUser, Model model) {
        Integer online = null;
        TbUserQueryVo tbUserQueryVo = new TbUserQueryVo();
        tbUserQueryVo.setTbUser(tbUser);
        tbUserQueryVo.setOnline(online);
        List<TbUser> userList = loan_userInfoList.selectLikeName(tbUserQueryVo);
        model.addAttribute("userList", userList);
        return "admin/loan_userList";
    }
}


