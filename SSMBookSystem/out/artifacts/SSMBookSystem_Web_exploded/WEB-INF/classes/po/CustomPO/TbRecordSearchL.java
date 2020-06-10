package po.CustomPO;

public class TbRecordSearchL extends TbRecordL {
    private String column;
    private String keyWord;

    private Integer currentPage;

    private Integer pageRows;

    private Integer totalRows;         // 总记录数
    private Integer totalPages;     // 总页数

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
    public Integer getCurrentPage() {
        return currentPage;
    }

    @Override
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

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

    @Override
    public String toString() {
        return "TbRecordSearchL{" +
                "column='" + column + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", currentPage=" + currentPage +
                ", pageRows=" + pageRows +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                "} " + super.toString();
    }
}