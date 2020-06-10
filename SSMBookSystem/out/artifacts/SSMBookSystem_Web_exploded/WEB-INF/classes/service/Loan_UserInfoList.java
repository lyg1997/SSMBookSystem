package service;

import po.CustomPO.TbOrderItems;
import po.CustomPO.TbRecordQueryVo;
import po.CustomPO.TbRecordQueryVoSelect;
import po.CustomPO.TbUserQueryVo;
import po.PageCount;
import po.TbUser;

import java.util.List;

/**
 * 用户信息列表service
 */
public interface Loan_UserInfoList {
    //查询用户信息列表
    public List<TbUser> findUserList();

    //查询黑名单列表
    public List<TbUser> findUserByOnline(Integer integer);

    //修改用户信息页面
    public TbUser updataUserInfo(Integer id);

    //修改用户信息提交
    public int editUser(TbUser tbUser);

    //删除用户
    public int deleteUser(Integer id);

    //添加用户
    public int addUser(TbUser tbUser);

    //用户列表模糊查询用户信息(用户名)
    public List<TbUser> selectLikeName(TbUserQueryVo tbUserQueryVo);

    //查询用户借阅记录
    public List<TbRecordQueryVo> findLoanBookList(Integer id);

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

    //查询用户列表
    public PageCount<TbUser> findAllUser(PageCount pageCount);

    //取消预约
    public int deleteOrder(Integer id);

}

