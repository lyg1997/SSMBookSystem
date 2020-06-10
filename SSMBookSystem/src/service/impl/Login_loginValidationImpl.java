package service.impl;

import mapper.CustomMapper.TbUserMapperL;
import mapper.TbManagerMapper;
import mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.ActiveAdmin;
import po.ActiveUser;
import po.TbManager;
import po.TbManagerExample;
import po.TbUser;
import po.TbUserExample;
import service.Login_loginValidation;
import utils.*;

import java.util.List;

//用户登录校验
@Service
public class Login_loginValidationImpl implements Login_loginValidation {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbManagerMapper tbManagerMapper;
    @Autowired
    private TbUserMapperL tbUserMapperL;

    @Override
    public ActiveUser authenticat(String username, String password) throws Exception {
        //通过用户名查询用户信息
        TbUser tbUser = this.findUserByUserName(username);
        //如果用户信息不存在，返回空
        if (tbUser == null) {
            return null;
        }
        //将明文密码进行md5加密
        String password_db = tbUser.getPassword();
        String passwordInput_md5 = createMD5.makeToString(password);

        //判断数据的密码和数据库中的是否一致，不一致返回null
        if (!passwordInput_md5.equalsIgnoreCase(password_db)) {
            return null;
        }
        //如果用户名存在，密码正确，返回该用户的id和username,并更新最后一次登录时间
        TbUser tbUserLastLoginDate = new TbUser();
        tbUserLastLoginDate.setId(tbUser.getId());
        Long afterLoginTime = System.currentTimeMillis() / 1000;
        tbUserLastLoginDate.setAfterdate(afterLoginTime);
        this.tbUserMapperL.updateUserOne(tbUserLastLoginDate);

        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserid(tbUser.getId());
        activeUser.setUsername(tbUser.getUsername());
        activeUser.setHeadImg(tbUser.getHeadimg());

        return activeUser;
    }

    @Override
    public TbUser findUserByUserName(String username) throws Exception {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUser> list = tbUserMapper.selectByExample(tbUserExample);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }


    @Override
    public int addUser(TbUser tbUser) throws Exception {
        //判断输入的用户名是否存在
        TbUser tbUser1 = this.findUserByUserName(tbUser.getUsername());
        if (tbUser1 == null) {
            //将密码转换为md5加密
            tbUser.setPassword(createMD5.makeToString(tbUser.getPassword()));
            int count = tbUserMapper.insert(tbUser);
            return count;
        }
        return 0;
    }

    @Override
    public ActiveAdmin authenticatAdmin(String adminname, String adminpassword) throws Exception {
        //通过用户名查询信息
        TbManager tbManager = this.findAdminByAdminName(adminname);
        //如果没有查询到管理员
        if (tbManager == null) {
            return null;
        }

        //将明文密码进行md5加密
        String password_db = tbManager.getPassword();
        String passwordInput_md5 = createMD5.makeToString(adminpassword);

        if (!password_db.equalsIgnoreCase(passwordInput_md5)) {
            return null;
        }

        ActiveAdmin activeAdmin = new ActiveAdmin();
        activeAdmin.setUserid(tbManager.getId());
        activeAdmin.setUsername(tbManager.getManagername());

        return activeAdmin;
    }

    @Override
    public TbManager findAdminByAdminName(String adminname) throws Exception {
        TbManagerExample tbManagerExample = new TbManagerExample();
        TbManagerExample.Criteria criteria = tbManagerExample.createCriteria();
        criteria.andManagernameEqualTo(adminname);
        List<TbManager> list = tbManagerMapper.selectByExample(tbManagerExample);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
