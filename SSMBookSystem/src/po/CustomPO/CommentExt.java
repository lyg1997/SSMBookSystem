package po.CustomPO;

import po.TbComment;
import po.TbUser;

/**
 * @description: 回复扩展pojo
 */

public class CommentExt {
    private String formatDate;
    private TbUser user;
    private TbComment comment;

    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }

    public TbComment getComment() {
        return comment;
    }

    public void setComment(TbComment comment) {
        this.comment = comment;
    }

    public TbUser getUser() {
        return user;
    }

    public void setUser(TbUser user) {
        this.user = user;
    }
}
