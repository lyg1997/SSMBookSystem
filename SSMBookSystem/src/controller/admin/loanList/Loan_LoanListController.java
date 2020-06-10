package controller.admin.loanList;

import mapper.TbLibraryMapper;
import mapper.TbRecordMapper;
import mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.CustomPO.*;
import po.TbLibrary;
import po.TbOrder;
import po.TbRecord;
import po.TbUser;
import service.LibraryService;
import service.Loan_UserInfoList;
import service.Loan_management;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 图书借阅管理Controller
 *
 **/
@Controller
@RequestMapping("/admin")
public class Loan_LoanListController {
    @Autowired
    private Loan_management loan_management;

    @Autowired
    private LibraryService libraryService;
    @Autowired
    private TbLibraryMapper tbLibraryMapper;
    @Autowired
    private TbRecordMapper recordMapper;
    @Autowired
    private Loan_UserInfoList loan_userInfoList;


    @RequestMapping("/loan/to_jieyue_book2")
    public String jieyue_book2(Model model) {
        return "admin/jieshu_book";
    }

    @RequestMapping("/loan/jieyue_book2")
    public String jieyue_book2(HttpSession session, String xuehao, String barcode, Model model) {
        TbLibrary book = tbLibraryMapper.selectByBarcode(barcode);
        if (null == book) {
            model.addAttribute("errorMsg", "图书条形码不存在");
            return "errorMsg";
        }
        TbUser tbUser = tbLibraryMapper.selectByStuNum(xuehao);
        if (null == tbUser) {
            model.addAttribute("errorMsg", "学生学号不存在");
            return "errorMsg";
        }
        //逾期，未归还
        Integer id=tbUser.getId();
        List<TbRecordQueryVo> recordOverdueList = loan_userInfoList.selectRecordOverdue(id);
        for (TbRecordQueryVo vo : recordOverdueList) {
            if (vo.getTicketffee() < 0) {
                model.addAttribute("errorMsg", "该学生有欠款不可以借阅");
                return "errorMsg";
            }
        }


        TbRecord record = new TbRecord();
        // 获取 session 中的用户信息
        record.setUserId(tbUser.getId());
        record.setBookId(book.getId());
        Long currentTimeS = System.currentTimeMillis() / 1000;
        record.setRecorddate(currentTimeS); //预约 借阅时间
        record.setBackdate(currentTimeS + 3 * 30 * 24 * 60 * 60); //预约 3个月天 时间
        record.setTicketffee(0f);
        record.setReturnbook(0);
        // 插入数据
        recordMapper.insert(record);
        model.addAttribute("successMsg", "借阅成功");
        return "errorMsg";
    }


    //借阅列表显示
    @RequestMapping("/loan/loanList")
    public String loanList(Model model, Integer currentPage) throws Exception {
        TbRecordL tbRecordL = new TbRecordL();
        //如果传入的有页面
        if (currentPage != null) {
            tbRecordL.setCurrentPage(currentPage);
        }
        //查询数据和分页，并返回
        pageL pageL = this.loan_management.getLoanRecord(tbRecordL);
        List<TbRecordL> loanRecordList = (List<TbRecordL>) pageL.getPo();

        model.addAttribute("pageL", pageL);
        model.addAttribute("loanRecordList", loanRecordList);
        return "admin/loan_loanList";
    }

    //借阅列表搜素
    @RequestMapping("/loan/searchLoanList.action")
    public String searchLoanList(Model model, String searchSelect, String searchKeyWord) throws Exception {
        //实例化包装类（包装类中在原有类的基础上添加的column（列名称）和keyword（搜索关键字）两个字段）
        TbRecordSearchL tbRecordSearchL = new TbRecordSearchL();
        tbRecordSearchL.setColumn(searchSelect);
        tbRecordSearchL.setKeyWord(searchKeyWord);
        //将查询结果保存到list集合并通过model将对象集合放入request域中
        pageL pageL = this.loan_management.getLoanRecord(tbRecordSearchL);
        List<TbRecordL> loanRecordList = (List<TbRecordL>) pageL.getPo();
        model.addAttribute("loanRecordList", loanRecordList);
        return "admin/loan_loanList";
    }

    //    借阅列表归还状态修改
    @RequestMapping("/loan/changeLoanStatus")
    public String changeLoanStatus(Model model, String recid, String status) throws Exception {
        loanStatusL loanStatusL = new loanStatusL();
        loanStatusL.setId(recid);
        loanStatusL.setStatus(status);
        this.loan_management.changLoanStatus(loanStatusL);
        //返回借阅列表
        return "redirect:/admin/loan/loanList.action";
    }
}
