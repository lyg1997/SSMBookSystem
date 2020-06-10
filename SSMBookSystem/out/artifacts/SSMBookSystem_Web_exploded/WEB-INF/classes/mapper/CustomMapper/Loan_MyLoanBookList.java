package mapper.CustomMapper;

import po.CustomPO.TbOrderItems;
import po.CustomPO.TbRecordQueryVo;
import po.CustomPO.TbRecordQueryVoSelect;

import java.util.List;

/**
 * 用户借阅记录
 */
public interface Loan_MyLoanBookList {
    //根据id查询用户借阅记录
    public List<TbRecordQueryVo> selectByPrimaryKey(Integer id);

    //搜索图书借阅
    public List<TbRecordQueryVo> selectLikeRecord(TbRecordQueryVoSelect tbRecordQueryVoSelect);

    //预约成功
    public List<TbOrderItems> selectOrderById(Integer id);

    //借阅中
    public List<TbRecordQueryVo> selectRecordRun(Integer id);

    //逾期，未归还
    public List<TbRecordQueryVo> selectRecordOverdue(Integer id);
    //挂失
    public List<TbRecordQueryVo> selectRecordGuashi(Integer id);

    //已归还
    public List<TbRecordQueryVo> selectRecordReturn(Integer id);
}
