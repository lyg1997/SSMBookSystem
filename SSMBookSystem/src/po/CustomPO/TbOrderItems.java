package po.CustomPO;

import po.TbOrder;

/**
 * 预约成功
 */
public class TbOrderItems extends TbOrder {
    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
