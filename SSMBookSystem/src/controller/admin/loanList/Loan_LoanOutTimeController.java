package controller.admin.loanList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.CustomPO.LoanOutTimeL;
import po.CustomPO.loanStatusL;
import po.CustomPO.pageL;
import service.Loan_management;

import java.util.List;

/**

 * @desc 借阅逾期列表
 **/
@Controller
@RequestMapping("/admin")
public class Loan_LoanOutTimeController {
    @Autowired
    private Loan_management loan_management;

    @RequestMapping("/loan/outTimeList")
    public String outTimeList(Model model, Integer currentPage) throws Exception {
        LoanOutTimeL loanOutTimeL = new LoanOutTimeL();
        //如果传入的有页面
        if (currentPage != null) {
            loanOutTimeL.setCurrentPage(currentPage);
        }
        //查询数据和分页，并返回
        pageL pageL = this.loan_management.findOutTimeList(loanOutTimeL);
        List<LoanOutTimeL> outTimeList = (List<LoanOutTimeL>) pageL.getPo();

        model.addAttribute("pageL", pageL);
        model.addAttribute("outTimeList", outTimeList);
        return "admin/loan_outtime";
    }

    //借阅逾期搜索列表
    @RequestMapping("/loan/searchOutTimeList")
    public String searchOutTimeList(Model model, String searchSelect, String searchKeyWord, Integer currentPage) throws Exception {
        //实例化包装类（包装类中在原有类的基础上添加的column（列名称）和keyword（搜索关键字）两个字段）
        LoanOutTimeL loanOutTimeL = new LoanOutTimeL();
        loanOutTimeL.setColumn(searchSelect);
        loanOutTimeL.setKeyWord(searchKeyWord);
        //如果传入的有页面
        if (currentPage != null) {
            loanOutTimeL.setCurrentPage(currentPage);
        }
        //查询数据和分页，并返回
        pageL pageL = this.loan_management.findOutTimeList(loanOutTimeL);
        List<LoanOutTimeL> outTimeList = (List<LoanOutTimeL>) pageL.getPo();

        model.addAttribute("pageL", pageL);
        model.addAttribute("outTimeList", outTimeList);
        return "admin/loan_outtime";
    }

    //    归还图书
    @RequestMapping("/loan/outTimeReturnBook")
    public String returnBook(Model model, String id) throws Exception {
        //将借阅id和状态码存入 扩展类中
        loanStatusL loanStatusL = new loanStatusL();
        loanStatusL.setId(id);
        loanStatusL.setStatus("1");
        //调用更改借阅状态的service方法
        this.loan_management.changLoanStatus(loanStatusL);

        return "redirect:/admin/loan/outTimeList.action";
    }

    //    将为逾期未归还图书的用户添加到黑名单
    @RequestMapping("loan/AddToBlackList")
    public String AddToBlackList(Integer id, Integer userId) throws Exception {
        //将该用户添加到黑名单
        this.loan_management.addUserToBlack(userId);

        /*
         * 不删除被加入黑名单的用户的借阅逾期记录。当用户归还完逾期图书以后，才可以继续借书
         * */

        //删除借阅记录
        //this.loan_management.removeOutTimeLoan(id);
        return "redirect:/admin/loan/outTimeList.action";
    }
}
