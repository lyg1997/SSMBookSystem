package po;

public class TbReply {
    private Integer id;

    private Integer commentId;

    private Long replydate;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Long getReplydate() {
        return replydate;
    }

    public void setReplydate(Long replydate) {
        this.replydate = replydate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}