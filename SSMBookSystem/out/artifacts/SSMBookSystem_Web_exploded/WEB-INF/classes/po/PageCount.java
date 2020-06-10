package po;

import java.util.List;

/**
 * @description: 分页pojo
 */

public class PageCount<T> {

    private Integer currentPage;    // 当前页数
    private Long totalRows;         // 总记录数
    private Integer totalPages;     // 总页数
    private Integer pageRows;       // 每页条数
    private List<T> contentList;    // 查询数据

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Long totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageRows() {
        return pageRows;
    }

    public void setPageRows(Integer pageRows) {
        this.pageRows = pageRows;
    }

    public List<T> getContentList() {
        return contentList;
    }

    public void setContentList(List<T> contentList) {
        this.contentList = contentList;
    }
}
