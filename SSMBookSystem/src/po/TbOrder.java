package po;

public class TbOrder {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Long orderdate;

    private Long deadline;

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

    public Long getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Long orderdate) {
        this.orderdate = orderdate;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }
}