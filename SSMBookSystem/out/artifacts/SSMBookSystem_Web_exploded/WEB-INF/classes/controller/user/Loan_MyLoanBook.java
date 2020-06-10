package controller.user;

import mapper.TbRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.ActiveUser;
import po.CustomPO.TbOrderItems;
import po.CustomPO.TbRecordQueryVo;
import po.TbUser;
import service.Loan_UserInfoList;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 用户图书借阅记录
 */

@Controller
@RequestMapping("/user")
public class Loan_MyLoanBook {
    @Autowired
    private Loan_UserInfoList loan_userInfoList;
    @Autowired
    private TbRecordMapper recordMapper;

    //查询用户借阅列表
    @RequestMapping("/user_MyloanList")
    public String user_MyloanList(HttpSession session, Model model) {
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        TbUser tbUser = new TbUser();
        tbUser.setId(activeUser.getUserid());
        session.setAttribute("userInfo", tbUser);
        //获取session用户信息
//        TbUser userInfo = (TbUser) session.getAttribute("activeUser");
        TbUser userInfo = (TbUser) session.getAttribute("userInfo");
        //根据用户id查询用户借阅记录
        Integer id = userInfo.getId();
        //预约成功
        List<TbOrderItems> tbOrderItems = loan_userInfoList.selectOrderById(id);
        long l = System.currentTimeMillis() / 1000;

        //借阅中
        List<TbRecordQueryVo> recordRunList = loan_userInfoList.selectRecordRun(id);

        //逾期，未归还
        List<TbRecordQueryVo> recordOverdueList = loan_userInfoList.selectRecordOverdue(id);
        //挂失
        List<TbRecordQueryVo> recordGuashi = loan_userInfoList.selectRecordGuashi(id);

        //已归还
        List<TbRecordQueryVo> recordReturnList = loan_userInfoList.selectRecordReturn(id);

        for (TbRecordQueryVo vo : recordOverdueList) {
            Date nowDate = new Date();
            Long time = vo.getBackdate() * 1000L;
            Date date = new Date(time);
            int days = differentDays(nowDate, date);
            if (days < 0) {
                vo.setTicketffee(0.1f * days);
                recordMapper.updateByPrimaryKey(vo);
            }
        }

        model.addAttribute("recordGuashi", recordGuashi);
        model.addAttribute("tbOrderItems", tbOrderItems);
        model.addAttribute("recordRunList", recordRunList);
        model.addAttribute("recordOverdueList", recordOverdueList);
        model.addAttribute("recordReturnList", recordReturnList);
        model.addAttribute("l", l);
        return "user/user_MyloanList";
    }


    /**
     * date2比date1多的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }


    //取消预约
    @RequestMapping("/deleteOrder")
    public String deleteOrder(Integer id) {
        int i = loan_userInfoList.deleteOrder(id);
        if (i > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
        return "redirect:user_MyloanList.action";
    }


/*//    搜索图书
    @RequestMapping("/loan_selectLikeRecord")
    public String loan_selectLikeRecord(HttpSession session,String bookName,Model model) {
        TbUser tbUser = new TbUser();
        tbUser.setId(1);
        session.setAttribute("userInfo",tbUser);
        //获取session用户信息
//        TbUser userInfo = (TbUser) session.getAttribute("activeUser");
        TbUser userInfo = (TbUser) session.getAttribute("userInfo");
        Integer id = userInfo.getId();
        //将查询的内容和用户的id保存到包装类中
        TbRecordQueryVoSelect tbRecordQueryVoSelect = new TbRecordQueryVoSelect();
        tbRecordQueryVoSelect.setId(id);
        tbRecordQueryVoSelect.setBookName(bookName);
        List<TbRecordQueryVo> loanBookList = loan_userInfoList.selectLikeRecord(tbRecordQueryVoSelect);
        model.addAttribute("loanBookList",loanBookList);
        return "user/user_MyloanList";
    }*/
}
