package service.impl;

import po.ActiveAdmin;
import po.ActiveUser;
import po.TbManager;
import po.TbUser;

//用户登录校验
public interface Login_loginValidation {
    //public int findUserAndPasswordCont(String username,String password) throws Exception;
    //根据用户的身份和密码进行认证，如果认证通过，返回用户身份信息
    public ActiveUser authenticat(String username, String password) throws Exception;

    //根据用户账号查询用户信息
    public TbUser findUserByUserName(String username) throws Exception;

    //添加用户信息到数据库
    public int addUser(TbUser tbUser) throws Exception;

    //    根据管理员身份和密码进行认证，如果认证通过，返回管理员信息
    public ActiveAdmin authenticatAdmin(String adminname, String adminpassword) throws Exception;

    //    根据管理员账号查询管理员信息
    public TbManager findAdminByAdminName(String adminname) throws Exception;
}
