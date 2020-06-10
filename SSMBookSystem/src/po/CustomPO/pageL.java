package po.CustomPO;

import java.util.List;

/**

 * @desc 分页参数PO
 **/
public class pageL {
    private Integer currentPage; //当前页

    private Integer pageRows; //当前页条数


    private Integer totalRows;         // 总记录数
    private Integer totalPages;     // 总页数

    private List<?> Po; //查询结果集

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

    public List<?> getPo() {
        return Po;
    }

    public void setPo(List<?> po) {
        Po = po;
    }
}
