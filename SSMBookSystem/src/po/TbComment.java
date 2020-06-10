package po;

public class TbComment {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Long commentdate;

    private Integer top;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Long getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Long commentdate) {
        this.commentdate = commentdate;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}