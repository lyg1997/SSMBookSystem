package po.CustomPO;

import po.TbLibrary;
import po.TbUser;

//预约表的扩展类
public class TbOrderL {
    private Integer currentPage;

    private Integer pageRows;

    private Integer totalRows;         // 总记录数
    private Integer totalPages;     // 总页数
    private TbUser tbUser;

    private String column;

    private String keyWord;

    private TbLibrary tbLibrary;

    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Long orderdate;

    private Long deadline;

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

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
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