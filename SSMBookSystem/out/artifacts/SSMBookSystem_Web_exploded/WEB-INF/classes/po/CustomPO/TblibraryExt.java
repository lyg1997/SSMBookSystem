package po.CustomPO;

import po.TbLibrary;

/**
 * @description: library扩展类
 */

public class TblibraryExt extends TbLibrary {
    private String categoryname;
    private String create_admin;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getCreate_admin() {
        return create_admin;
    }

    public void setCreate_admin(String create_admin) {
        this.create_admin = create_admin;
    }
}
