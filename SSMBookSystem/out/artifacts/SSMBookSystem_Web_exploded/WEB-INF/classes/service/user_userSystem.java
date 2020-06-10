package service;

import org.springframework.web.multipart.MultipartFile;
import po.CustomPO.TbUserRestInfoL;
import po.TbUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户系统service接口
 */
public interface user_userSystem {
    //根据用户id查询用户信息
    public TbUser findUserById(Integer id) throws Exception;

    //根据用户id修改用户密码
    public int updateUserPassword(TbUserRestInfoL tbUserRestInfoL) throws Exception;

    //    根据用户id修改用户信息
    public void updateUserOne(TbUser tbUser, MultipartFile uploadFile, HttpServletRequest request) throws Exception;

}
