package po.CustomPO;

import po.TbLibrary;
import po.TbUser;

public class TbRecordL {
    private String column;

    private String keyWord;

    private Integer currentPage;

    private Integer pageRows;

    private Integer totalRows; // 总记录数

    private Integer totalPages;//总页数

    private Long timeDifference;

    private TbUser tbUser;

    private TbLibrary tbLibrary;

    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Long recorddate;

    private Long backdate;

    private Boolean returnbook;

    private Float ticketffee;

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public TbLibrary getTbLibrary() {
        return tbLibrary;
    }

    public void setTbLibrary(TbLibrary tbLibrary) {
        this.tbLibrary = tbLibrary;
    }

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

    public Boolean getReturnbook() {
        return returnbook;
    }

    public void setReturnbook(Boolean returnbook) {
        this.returnbook = returnbook;
    }

    public Float getTicketffee() {
        return ticketffee;
    }

    public void setTicketffee(Float ticketffee) {
        this.ticketffee = ticketffee;
    }

    public Long getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(Long timeDifference) {
        this.timeDifference = timeDifference;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageRows() {
        return pageRows;
    }

    public void setPageRows(Integer pageRows) {
        this.pageRows = pageRows;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "TbRecordL{" +
                "column='" + column + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", currentPage=" + currentPage +
                ", pageRows=" + pageRows +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                ", timeDifference=" + timeDifference +
                ", tbUser=" + tbUser +
                ", tbLibrary=" + tbLibrary +
                ", id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", recorddate=" + recorddate +
                ", backdate=" + backdate +
                ", returnbook=" + returnbook +
                ", ticketffee=" + ticketffee +
                '}';
    }
}