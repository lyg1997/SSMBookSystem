package po.CustomPO;

import po.TbUser;

/**
 *
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

