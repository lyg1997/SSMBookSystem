package po.CustomPO;

import po.TbCategory;

/**

 * @description: 商品类目扩展类

 */

public class TbCategoryExt {
    private String parentName;
    private TbCategory tbCategory;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public TbCategory getTbCategory() {
        return tbCategory;
    }

    public void setTbCategory(TbCategory tbCategory) {
        this.tbCategory = tbCategory;
    }
}
