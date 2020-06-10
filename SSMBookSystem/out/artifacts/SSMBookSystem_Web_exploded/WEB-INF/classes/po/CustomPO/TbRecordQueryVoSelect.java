package po.CustomPO;

/**
 * 搜索用户借阅图书记录包装类
 */
public class TbRecordQueryVoSelect {
    //输入图书名称
    private String bookName;
    //用户id
    private Integer id;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
