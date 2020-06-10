package po;

public class TbRecord {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Long recorddate;

    private Long backdate;

    private Integer returnbook;

    private Float ticketffee;

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

    public Long getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Long recorddate) {
        this.recorddate = recorddate;
    }

    public Long getBackdate() {
        return backdate;
    }

    public void setBackdate(Long backdate) {
        this.backdate = backdate;
    }

    public Integer getReturnbook() {
        return returnbook;
    }

    public void setReturnbook(Integer returnbook) {
        this.returnbook = returnbook;
    }

    public Float getTicketffee() {
        return ticketffee;
    }

    public void setTicketffee(Float ticketffee) {
        this.ticketffee = ticketffee;
    }

    @Override
    public String toString() {
        return "TbRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", recorddate=" + recorddate +
                ", backdate=" + backdate +
                ", returnbook=" + returnbook +
                ", ticketffee=" + ticketffee +
                '}';
    }
}