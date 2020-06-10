package service.impl;

import mapper.CustomMapper.TbUserMapperL;
import mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import po.CustomPO.TbUserRestInfoL;
import po.TbUser;
import service.user_userSystem;
import utils.UploadFileUtilsByUser;
import utils.createMD5;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc 用户系统service层实现类
 **/
@Service
public class user_userSystemImpl implements user_userSystem {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbUserMapperL tbUserMapperL;
    @Value("${USERIMG_FILE_SAVE_PATH}")
    private String USERIMG_FILE_SAVE_PATH;

    //根据用户id查询用户信息
    @Override
    public TbUser findUserById(Integer id) throws Exception {
        TbUser tbUser = this.tbUserMapper.selectByPrimaryKey(id);
        return tbUser;
    }

    @Override
    public int updateUserPassword(TbUserRestInfoL tbUserRestInfoL) throws Exception {
        TbUser tbUser = this.findUserById(tbUserRestInfoL.getId());
        //如果没有查询到该用户
        if (tbUser == null) {
            return 0;
        }
        //将用户输入的原密码转换为md5
        String oldPwdByMd5 = createMD5.makeToString(tbUserRestInfoL.getPassword());
        //对用户输入的原密码和数据库中的密码进行校验
        if (!tbUser.getPassword().equalsIgnoreCase(oldPwdByMd5)) {
            return 2;//校验码 2  用户输入的原密码和数据库中的密码不匹配
        }
        //上面的验证都通过，向数据库写数据
        //将新密码转换为md5放入tbuser对象中
        String newPwdByMd5 = createMD5.makeToString(tbUserRestInfoL.getNewPassword());
        tbUser.setPassword(newPwdByMd5);
        return tbUserMapper.updateByPrimaryKey(tbUser);
    }

    @Override
    public void updateUserOne(TbUser tbUser, MultipartFile uploadFile, HttpServletRequest request) throws Exception {
        String headImg = UploadFileUtilsByUser.updateLibrary(uploadFile, request,USERIMG_FILE_SAVE_PATH);
        System.out.println(headImg);
        tbUser.setHeadimg(headImg);
        this.tbUserMapperL.updateUserOne(tbUser);
    }
}
