package po.CustomPO;

import po.TbLibrary;

/**

 * @description: 图书信息扩展类
 */

public class BookExt {
    private TbLibrary library;
    private String formatDate;

    public TbLibrary getLibrary() {
        return library;
    }

    public void setLibrary(TbLibrary library) {
        this.library = library;
    }

    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }
}
