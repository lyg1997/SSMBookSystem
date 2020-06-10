package mapper.CustomMapper;
//图书借阅管理

import po.CustomPO.LoanOutTimeL;
import po.CustomPO.TbOrderL;
import po.CustomPO.TbRecordL;
import po.CustomPO.loanStatusL;
import po.TbRecord;

import java.util.List;

public interface Loan_managementMapperL {
    //借阅记录列表
    public List<TbRecordL> selectLoanRecord(TbRecordL tbRecordL) throws Exception;

    //借阅记录表 修改归还状态
    public void updateLoanReturnBook(loanStatusL loanStatusL) throws Exception;

    //预约记录列表
    public List<TbOrderL> selectBespeakRecord(TbOrderL TbOrderL) throws Exception;

    //    借出未还记录列表
    public List<TbRecordL> selectLoanOutStanding(TbOrderL tbOrderL) throws Exception;

    //    插入借阅记录
    public void insertLoanList(TbRecord tbRecord) throws Exception;

    //    删除预约记录
    public void deleteOrderList(Integer id) throws Exception;

    //    用户添加到黑名单
    public void updateUserBlack(Integer id) throws Exception;

    //查询借阅超时列表
    public List<LoanOutTimeL> selectOutTimeList(LoanOutTimeL loanOutTimeL) throws Exception;


}
