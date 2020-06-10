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
 * 用户黑名单
 */

@Controller
@RequestMapping("/admin")
public class Loan_UserOnlineController {

    @Autowired
    private Loan_UserInfoList loan_userInfoList;

    //查询黑名单列表
    @RequestMapping("/loan_blackList")
    public String loan_blackList(Model model) {
        List<TbUser> userByOnline = loan_userInfoList.findUserByOnline(1);
/*        for(TbUser t : userByOnline) {
            System.out.println(t);
        }*/
        model.addAttribute("userByOnline", userByOnline);
        return "admin/loan_blackList";
    }

    //用户列表模糊查询用户信息(用户名)
    @RequestMapping("/loan_selectLikeOnline")
    public String Loan_selectLikeName(TbUser tbUser, Model model) {
        Integer online = 1;
        TbUserQueryVo tbUserQueryVo = new TbUserQueryVo();
        tbUserQueryVo.setTbUser(tbUser);
        tbUserQueryVo.setOnline(online);
        List<TbUser> userByOnline = loan_userInfoList.selectLikeName(tbUserQueryVo);
        model.addAttribute("userByOnline", userByOnline);
        return "admin/loan_blackList";
    }

    //用户删除
    @RequestMapping("/loan_deleteUserOnline")
    public String loan_deleteUser(Integer id) {
        int i = loan_userInfoList.deleteUser(id);
        if (i > 0) {
            return "redirect:loan_blackList.action";
        }
        return "redirect:loan_blackList.action";
    }

    //恢复黑名单
    @RequestMapping("/loan_recoverUserOnline")
    public String loan_recoverUserOnline(Integer id) {
        TbUser tbUser = new TbUser();
        tbUser.setId(id);
        tbUser.setIsonline(0);
        int i = loan_userInfoList.editUser(tbUser);
        if (i > 0) {
            return "redirect:loan_blackList.action";
        }
        return "redirect:loan_blackList.action";
    }
}
