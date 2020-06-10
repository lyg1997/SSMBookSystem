package controller.admin.loanList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.CustomPO.TbOrderL;
import po.CustomPO.pageL;
import po.TbRecord;
import service.Loan_management;

import java.util.List;

/**
 * @desc 预约记录
 **/
@Controller
@RequestMapping("/admin")
public class Loan_BespeakRecordController {
    @Autowired
    private Loan_management loan_management;

    //数据列表
    @RequestMapping("/loan/bespeakList")
    public String BespeakList(Model model, Integer currentPage) throws Exception {
        TbOrderL tbOrderL = new TbOrderL();
        //如果传入的有页面
        if (currentPage != null) {
            tbOrderL.setCurrentPage(currentPage);
        }
        //查询数据和分页，并返回
        pageL pageL = new pageL();
        pageL = this.loan_management.getBespeakRecord(tbOrderL);
        List<TbOrderL> BespeakList = (List<TbOrderL>) pageL.getPo();
        model.addAttribute("pageL", pageL);
        model.addAttribute("BespeakList", BespeakList);
        return "admin/loan_bespeak";
    }

    //列表查询
    @RequestMapping("/loan/searchBespeak")
    public String searchBespeak(Model model, String searchSelect, String searchKeyWord, Integer currentPage) throws Exception {
        TbOrderL tbOrderL = new TbOrderL();
        //如果传入的有页面
        if (currentPage != null) {
            tbOrderL.setCurrentPage(currentPage);
        }
        //实例化包装类（包装类中在原有类的基础上添加的column（列名称）和keyword（搜索关键字）两个字段）
        tbOrderL.setColumn(searchSelect);
        tbOrderL.setKeyWord(searchKeyWord);
        pageL pageL = new pageL();
        pageL = this.loan_management.getBespeakRecord(tbOrderL);
        List<TbOrderL> BespeakList = (List<TbOrderL>) pageL.getPo();
        model.addAttribute("pageL", pageL);
        model.addAttribute("BespeakList", BespeakList);
        return "admin/loan_bespeak";
    }

    //    领取操作
    @RequestMapping("/loan/getBespeak")
    public String getBespeak(Model model, Integer id, Integer bookid, Integer userid) throws Exception {
        //通过bookid和userid 借阅表插入借阅记录
        TbRecord tbRecord = new TbRecord();
        tbRecord.setBookId(bookid);
        tbRecord.setUserId(userid);
        this.loan_management.addLoanList(tbRecord);

        //通过id删除预约记录
        this.loan_management.removeOrderList(id);

        //返回借阅列表
        return "redirect:/admin/loan/bespeakList.action";
    }

    //    删除预约记录
    @RequestMapping("/loan/removeBespeak")
    public String removeBespeak(Integer id) throws Exception {
        this.loan_management.removeOrderList(id);
        return "redirect:/admin/loan/bespeakList.action";
    }
}
