package po.CustomPO;

import po.TbUser;

/**
 * @author Hiseico
 * @create 2018-04-11 16:42
 * @desc 用户数据修改po
 **/
public class TbUserRestInfoL extends TbUser {
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}

