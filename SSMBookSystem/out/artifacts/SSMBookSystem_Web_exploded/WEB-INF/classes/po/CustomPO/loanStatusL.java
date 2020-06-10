package po.CustomPO;

/**
 * @desc 借阅列表归还状态po
 **/
public class loanStatusL {
    private Integer currentPage;

    private Integer pageRows;

    private Integer totalRows;         // 总记录数
    private Integer totalPages;     // 总页数

    private String id;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
