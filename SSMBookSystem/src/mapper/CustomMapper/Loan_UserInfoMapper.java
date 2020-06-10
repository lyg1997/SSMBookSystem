package mapper.CustomMapper;

import po.CustomPO.TbUserQueryVo;
import po.TbUser;

import java.util.List;

/**
 * 用户信息管理
 */
public interface Loan_UserInfoMapper {
    //查询黑名单列表
    public List<TbUser> findUserByOnline(Integer integer);

    //用户列表模糊查询用户信息(用户名)
    public List<TbUser> selectLikeName(TbUserQueryVo tbUserQueryVo);
}
