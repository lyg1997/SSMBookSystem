package service;

import po.CustomPO.*;
import po.TbRecord;

/**
 * 图书借阅管理service接口
 */
public interface Loan_management {
    //获取 借阅列表
    public pageL getLoanRecord(TbRecordL tbRecordL) throws Exception;

    //修改借阅列表归还状态
    public void changLoanStatus(loanStatusL loanStatusL) throws Exception;

    //   获取预约借阅列表
    public pageL getBespeakRecord(TbOrderL tbOrderL) throws Exception;

    //    获取借阅未还列表
    public pageL getLoanOutStanding(TbOrderL tbOrderL) throws Exception;

    //    插入借阅记录
    public void addLoanList(TbRecord tbRecord) throws Exception;

    //删除预约记录
    public void removeOrderList(Integer id) throws Exception;

    //    添加用户到黑名单
    public void addUserToBlack(Integer id) throws Exception;

    //    删除已逾期的借阅记录
    public void removeOutTimeLoan(Integer id) throws Exception;

    //    获取借阅逾期列表
    public pageL findOutTimeList(LoanOutTimeL loanOutTimeL) throws Exception;


}
