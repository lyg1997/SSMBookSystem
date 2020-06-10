package po.CustomPO;

import po.TbRecord;

/**
 * 借阅图书扩展类
 */
public class TbRecordQueryVo extends TbRecord {
    private String bookname;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public String toString() {
        return "TbRecordQueryVo{" +
                "bookname='" + bookname + '\'' +
                "} " + super.toString();
    }
}
