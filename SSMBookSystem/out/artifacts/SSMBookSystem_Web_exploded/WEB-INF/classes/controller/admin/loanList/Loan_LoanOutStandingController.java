package controller.admin.loanList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.CustomPO.TbOrderL;
import po.CustomPO.TbRecordL;
import po.CustomPO.loanStatusL;
import po.CustomPO.pageL;
import service.Loan_management;

import java.util.List;
@Controller
@RequestMapping("/admin")
public class Loan_LoanOutStandingController {
    @Autowired
    private Loan_management loan_management;

    //数据列表
    @RequestMapping("/loan/outStanding")
    public String outStanding(Model model, Integer currentPage) throws Exception {
        TbOrderL tbOrderL = new TbOrderL();
        //如果传入的有页面
        if (currentPage != null) {
            tbOrderL.setCurrentPage(currentPage);
        }
        //查询数据和分页，并返回
        pageL pageL = this.loan_management.getLoanOutStanding(tbOrderL);
        List<TbRecordL> outStandingList = (List<TbRecordL>) pageL.getPo();

        model.addAttribute("pageL", pageL);
        model.addAttribute("outStandingList", outStandingList);
        return "admin/loan_outstanding";
    }

    //    数据搜索
    @RequestMapping("/loan/searchOutStanding")
    public String searchOutStanding(Model model, String searchSelect, String searchKeyWord, Integer currentPage) throws Exception {
        TbOrderL tbOrderL = new TbOrderL();
        //如果传入的有页面
        if (currentPage != null) {
            tbOrderL.setCurrentPage(currentPage);
        }
        //实例化包装类（包装类中在原有类的基础上添加的column（列名称）和keyword（搜索关键字）两个字段）
        tbOrderL.setColumn(searchSelect);
        tbOrderL.setKeyWord(searchKeyWord);
        //将查询结果保存到list集合并通过model将对象集合放入request域中
        //查询数据和分页，并返回
        pageL pageL = this.loan_management.getLoanOutStanding(tbOrderL);
        List<TbRecordL> outStandingList = (List<TbRecordL>) pageL.getPo();

        model.addAttribute("pageL", pageL);
        model.addAttribute("outStandingList", outStandingList);
        return "admin/loan_outstanding";
    }

    //    归还图书
    @RequestMapping("/loan/returnBook")
    public String returnBook(Model model, String id) throws Exception {
        //将借阅id和状态码存入 扩展类中
        loanStatusL loanStatusL = new loanStatusL();
        loanStatusL.setId(id);
        loanStatusL.setStatus("1");
        //调用更改借阅状态的service方法
        this.loan_management.changLoanStatus(loanStatusL);

        return "redirect:/admin/loan/outStanding.action";
    }

}
