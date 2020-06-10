package po;

public class TbLibrary {
    private Integer id;

    private Integer cateId;

    private Integer managerId;

    private String bookname;

    private String description;

    private String author;

    private String press;

    private String img;

    private Float price;

    private Long publishdate;

    private Long createdate;

    private Integer booknum;

    private String barcode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Long publishdate) {
        this.publishdate = publishdate;
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public Integer getBooknum() {
        return booknum;
    }

    public void setBooknum(Integer booknum) {
        this.booknum = booknum;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return "TbLibrary{" +
                "id=" + id +
                ", cateId=" + cateId +
                ", managerId=" + managerId +
                ", bookname='" + bookname + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", img='" + img + '\'' +
                ", price=" + price +
                ", publishdate=" + publishdate +
                ", createdate=" + createdate +
                ", booknum=" + booknum +
                ", barcode='" + barcode + '\'' +
                '}';
    }
}