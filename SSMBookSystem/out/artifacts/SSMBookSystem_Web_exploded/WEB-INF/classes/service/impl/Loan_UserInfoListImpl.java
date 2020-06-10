package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.CustomMapper.Loan_MyLoanBookList;
import mapper.CustomMapper.Loan_UserInfoMapper;
import mapper.TbOrderMapper;
import mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import po.CustomPO.TbOrderItems;
import po.CustomPO.TbRecordQueryVo;
import po.CustomPO.TbRecordQueryVoSelect;
import po.CustomPO.TbUserQueryVo;
import po.PageCount;
import po.TbUser;
import po.TbUserExample;
import service.Loan_UserInfoList;

import java.util.List;

/**
 * 用户信息列表serviceImpl
 */
//@Service("user_UserInfoList")
@Service
public class Loan_UserInfoListImpl implements Loan_UserInfoList {
    //注入dao
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private Loan_UserInfoMapper loan_userInfoMapper;
    @Autowired
    private Loan_MyLoanBookList loan_myLoanBookList;
    @Autowired
    private TbOrderMapper tbOrderMapper;


    @Value("${CURRENT_PAGE}")
    private String CURRENT_PAGE;
    @Value("${PAGE_ROWS}")
    private String PAGE_ROWS;

    @Override
    public List<TbUser> findUserList() {
        List<TbUser> userList = tbUserMapper.selectByExample(null);
        return userList;
    }

    @Override
    public List<TbUser> findUserByOnline(Integer integer) {
        List<TbUser> userByOnline = loan_userInfoMapper.findUserByOnline(integer);
        return userByOnline;
    }

    @Override
    public TbUser updataUserInfo(Integer id) {
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(id);
        return tbUser;
    }

    @Override
    public int editUser(TbUser tbUser) {
        int i = tbUserMapper.updateByPrimaryKeySelective(tbUser);
        return i;
    }

    @Override
    public int deleteUser(Integer id) {
        int i = tbUserMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int addUser(TbUser tbUser) {
        int insert = tbUserMapper.insert(tbUser);
        return insert;
    }

    @Override
    public List<TbUser> selectLikeName(TbUserQueryVo tbUserQueryVo) {
        List<TbUser> userList = loan_userInfoMapper.selectLikeName(tbUserQueryVo);
        return userList;
    }

    @Override
    public List<TbRecordQueryVo> findLoanBookList(Integer id) {
        List<TbRecordQueryVo> tbRecordQueryVos = loan_myLoanBookList.selectByPrimaryKey(id);
        return tbRecordQueryVos;
    }

    @Override
    public List<TbRecordQueryVo> selectLikeRecord(TbRecordQueryVoSelect tbRecordQueryVoSelect) {
        List<TbRecordQueryVo> tbRecordQueryVos = loan_myLoanBookList.selectLikeRecord(tbRecordQueryVoSelect);
        return tbRecordQueryVos;
    }

    @Override
    public List<TbOrderItems> selectOrderById(Integer id) {
        List<TbOrderItems> tbOrderItems = loan_myLoanBookList.selectOrderById(id);
        return tbOrderItems;
    }


    @Override
    public List<TbRecordQueryVo> selectRecordRun(Integer id) {
        List<TbRecordQueryVo> recordRunList = loan_myLoanBookList.selectRecordRun(id);
        return recordRunList;
    }

    @Override
    public List<TbRecordQueryVo> selectRecordOverdue(Integer id) {
        List<TbRecordQueryVo> recordOverdueList = loan_myLoanBookList.selectRecordOverdue(id);
        return recordOverdueList;
    }
    @Override
    public List<TbRecordQueryVo> selectRecordGuashi(Integer id) {
        List<TbRecordQueryVo> recordOverdueList = loan_myLoanBookList.selectRecordGuashi(id);
        return recordOverdueList;
    }

    @Override
    public List<TbRecordQueryVo> selectRecordReturn(Integer id) {
        List<TbRecordQueryVo> recordReturnList = loan_myLoanBookList.selectRecordReturn(id);
        return recordReturnList;
    }

    @Override
    public PageCount<TbUser> findAllUser(PageCount pageCount) {
        TbUserExample userExample = new TbUserExample();

        if (pageCount == null) {
            pageCount = new PageCount();
        }

        if (pageCount.getCurrentPage() == null) {
            pageCount.setCurrentPage(Integer.parseInt(CURRENT_PAGE));
        }
        if (pageCount.getPageRows() == null) {
            pageCount.setPageRows(Integer.parseInt(PAGE_ROWS));
        }

        PageHelper.startPage(pageCount.getCurrentPage(), pageCount.getPageRows());

        List<TbUser> users = tbUserMapper.selectByExample(userExample);

        PageInfo<TbUser> userInfo = new PageInfo<TbUser>(users);

        pageCount.setContentList(users);
        pageCount.setTotalPages(userInfo.getPageNum());
        pageCount.setTotalRows(userInfo.getTotal());

        return pageCount;
    }

    @Override
    public int deleteOrder(Integer id) {
        int i = tbOrderMapper.deleteByPrimaryKey(id);
        return i;
    }

}
