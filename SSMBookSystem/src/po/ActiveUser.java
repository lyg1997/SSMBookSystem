package po;

/**
 *
 * @desc 用于记录用户身份信息的类
 **/
public class ActiveUser {
    private Integer userid;//用户id
    private String username;//用户名称
    private String headImg;//用户头像

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
