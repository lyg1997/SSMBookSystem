package mapper.CustomMapper;
//图书借阅管理

import po.TbUser;

import java.util.List;

public interface Login_userMapperL {
    //        通过用户名查询用户
    public List<TbUser> selectUserByUsername(TbUser tbUser) throws Exception;
}
