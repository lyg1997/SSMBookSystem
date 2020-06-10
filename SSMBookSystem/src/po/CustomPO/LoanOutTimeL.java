package po.CustomPO;

/**

 * @desc 借阅逾期
 **/
public class LoanOutTimeL extends TbRecordL {
    private Integer currentPage; //当前页
    private Integer pageRows; //当前页条数
    private Integer totalRows;         // 总记录数
    private Integer totalPages;     // 总页数
    private Long outTime;//超出时间

    @Override
    public Integer getPageRows() {
        return pageRows;
    }

    @Override
    public void setPageRows(Integer pageRows) {
        this.pageRows = pageRows;
    }

    @Override
    public Integer getTotalRows() {
        return totalRows;
    }

    @Override
    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    @Override
    public Integer getTotalPages() {
        return totalPages;
    }

    @Override
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getOutTime() {
        return outTime;
    }

    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    @Override
    public Integer getCurrentPage() {
        return currentPage;
    }

    @Override
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
