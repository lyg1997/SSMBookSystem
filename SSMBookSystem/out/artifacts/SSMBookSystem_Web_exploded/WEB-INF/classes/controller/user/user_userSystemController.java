package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import po.CustomPO.TbUserRestInfoL;
import po.TbUser;
import service.user_userSystem;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc 前台用户功能Controller
 **/
@Controller
@RequestMapping("/user")
public class user_userSystemController {
    @Autowired
    private user_userSystem user_userSystem;

    //重置用户密码
    @RequestMapping("/resetPwd")
    public String resetPassword(Model model, Integer id, String oldPassword, String newPassword, String newPassword2) throws Exception {
        String msg;
        String url;
        //判断输入的值是否为空
        if ("".equals(oldPassword) || oldPassword == null || "".equals(newPassword) || newPassword == null || "".equals(newPassword2) || newPassword2 == null) {
            msg = "不能有空值";
            url = "/user/user_resetPassword.action";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            return "user/error";
        }
        //判断两次输入的密码是否正确
        if (!newPassword.equals(newPassword2)) {
            msg = "两次新密码不一致";
            url = "/user/user_resetPassword.action";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            return "user/error";
        }
        //如果都正确，传入旧密码和新密码到service层进行校验
        TbUserRestInfoL tbUserRestInfoL = new TbUserRestInfoL();
        tbUserRestInfoL.setPassword(oldPassword);
        tbUserRestInfoL.setNewPassword(newPassword);
        tbUserRestInfoL.setId(id);

        int result = this.user_userSystem.updateUserPassword(tbUserRestInfoL);
        //返回值0 表示通过传入的id为找到用户
        if (0 == result) {
            msg = "未找到该用户！";
            url = "/user/user_resetPassword.action";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            return "user/error";
        }

        //返回值2 用户输入的旧密码和数据库中的密码不匹配
        if (2 == result) {
            msg = "旧密码输入错误！";
            url = "/user/user_resetPassword.action";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            return "user/error";
        }
        //密码修改成功，跳转回修改页面
        msg = "密码修改成功！";
        url = "/user/user_resetPassword.action";
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        return "user/error";
    }

    //回填用户信息
    @RequestMapping("/showRestUserInfo")
    public String showRestUserInfo(Model model, int id) throws Exception {
        String msg;
        String url;
        TbUser tbUser = this.user_userSystem.findUserById(id);
        if (tbUser == null) {
            msg = "拉取用户信息失败！";
            url = "/user/user_resetUserInfo.action";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            return "user/error";
        }
        model.addAttribute("tbUser", tbUser);
        return "user/user_resetUserInfo";
    }

    @RequestMapping("/resetInfo")
    public String resetUserInfo(Model model, TbUser tbUser, MultipartFile pictureFile, HttpServletRequest request) throws Exception {
        //调用service层的更新方法
        this.user_userSystem.updateUserOne(tbUser, pictureFile,request);

        TbUser tbUser1 = this.user_userSystem.findUserById(tbUser.getId());
        model.addAttribute("tbUser", tbUser1);
        return "user/user_resetUserInfo";
    }
}
