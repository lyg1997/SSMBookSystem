package po.CustomPO;

import po.TbUser;

/**
 * 用户信息包装类
 */
public class TbUserQueryVo {
    private TbUser tbUser;
    private Integer online;

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }
}
