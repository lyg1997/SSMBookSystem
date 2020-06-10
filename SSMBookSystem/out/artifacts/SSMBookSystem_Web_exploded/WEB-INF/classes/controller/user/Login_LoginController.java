package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.ActiveAdmin;
import po.ActiveUser;
import po.TbUser;
import service.Login_loginValidation;

import javax.servlet.http.HttpSession;

/**

 * @desc 登录注册Controller
 **/
@Controller
@RequestMapping("/login")
public class Login_LoginController {
    @Autowired
    private Login_loginValidation login_loginValidation;

    @RequestMapping("/login")
    public String login(Model model, HttpSession session, String user, String pwd, String passwd2, String tel, String authcode, String statu) throws Exception {
        //提示信息
        String msg;
        //跳转页面
        String url;
        //登录
        ActiveUser activeUser = new ActiveUser();
        TbUser tbUser = new TbUser();
        if ("1".equals(statu)) {
            activeUser = this.login_loginValidation.authenticat(user, pwd);
            if (activeUser == null) {
                msg = "用户名或密码错误！";
                url = "/login.action";
                model.addAttribute("msg", msg);
                model.addAttribute("url", url);
                return "user/error";
            }
            session.setAttribute("activeUser", activeUser);
            return "redirect:/user/userSystem.action";
        } else if ("2".equals(statu)) { //注册
            //获取生成的验证码
            String validateCode = (String) session.getAttribute("randomCode");
            //判断用户名或密码是否为空
            if ("".equals(user) || user == null || "".equals(pwd) || pwd == null) {
                msg = "用户名或密码不能为空！";
                url = "/login.action";
                model.addAttribute("msg", msg);
                model.addAttribute("url", url);
            }
            //判断两次密码是否不一致
            if (!pwd.equals(passwd2)) {
                msg = "您输入的两次密码不一致！";
                url = "/login.action";
                model.addAttribute("msg", msg);
                model.addAttribute("url", url);
            }
            //判断手机号是否为空
            if (!"".equals(tel) || tel == null) {
                msg = "手机号不能为空！";
                url = "/login.action";
                model.addAttribute("msg", msg);
                model.addAttribute("url", url);
            }
            //判断验证码是否错误
            if (!validateCode.equals(authcode)) {
                msg = "您输入的验证码错误！";
                url = "/login.action";
                model.addAttribute("msg", msg);
                model.addAttribute("url", url);
                return "user/error";
            }
            //如果都正确，注册用户
            tbUser.setUsername(user);
            tbUser.setPassword(pwd);
            tbUser.setTelnum(tel);
            long nowTime = System.currentTimeMillis() / 1000;
            tbUser.setRegisterdate(nowTime);

            int result = this.login_loginValidation.addUser(tbUser);
            //判断是否注册成功
            if (0 == result) {
                msg = "注册失败，用户名已存在！";
                url = "/login.action";
                model.addAttribute("msg", msg);
                model.addAttribute("url", url);
                return "user/error";
            }
            //注册成功，将用户名放入seesion中
            tbUser = this.login_loginValidation.findUserByUserName(user);
            activeUser.setUserid(tbUser.getId());
            activeUser.setUsername(tbUser.getUsername());
            activeUser.setHeadImg(tbUser.getHeadimg());
            session.setAttribute("activeUser", activeUser);
            msg = "注册成功！正在为您登录，请稍候...";
            url = "/user/userSystem.action";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            return "user/error";
        } else {
            msg = "参数错误！";
            url = "/login.action";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            return "user/error";
        }
    }

    //账号退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/login.action";
    }

    //    管理员登录
    @RequestMapping("/adminlogin")
    public String adminlogin(Model model, HttpSession session, String adminuser, String adminpassword) throws Exception {
        String msg;
        String url;

        //判断用户名为空
        if ("".equals(adminuser) || adminuser == null || "".equals(adminpassword) || adminpassword == null) {
            msg = "用户名或密码不能为空！";
            url = "/admin.action";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            return "user/error";
        }
        ActiveAdmin activeAdmin = this.login_loginValidation.authenticatAdmin(adminuser, adminpassword);
        if (activeAdmin == null) {
            msg = "用户名或密码错误！";
            url = "/admin.action";
            model.addAttribute("msg", msg);
            model.addAttribute("url", url);
            return "user/error";
        }
        session.setAttribute("activeAdmin", activeAdmin);
        return "redirect:/admin/admin.action";
    }
}
