package service.impl;

import mapper.CustomMapper.Loan_managementMapperL;
import mapper.TbRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import po.CustomPO.*;
import po.TbRecord;
import service.Loan_management;

/**
 * 图书借阅管理service实现类
 */
@Service
public class Loan_managementImpl implements Loan_management {
    @Autowired
    private Loan_managementMapperL loan_managementMapperL;
    @Autowired
    private TbRecordMapper tbRecordMapper;

    //从配置文件读取默认的当前页数
    @Value("${CURRENT_PAGE}")
    private String CURRENT_PAGE;

    @Value("${PAGE_ROWS}")
    private String PAGE_ROWS;

    int currentPage; //当前页
    int pageRows; //当前页条数
    int totalRows;         // 总记录数
    int totalPages;     // 总页数
    int currentPageBySql;//在数据库中需要用到的当前页参数

    @Override
    public pageL getLoanRecord(TbRecordL tbRecordL) throws Exception {
        //判断是否有搜索条件
        //为了保证数据安全性 前端页面下拉菜单中的选项 不直接使用数据库列名称，使用标识符，然后在service层进行匹配，并设置对应的数据库列名称
        String column = tbRecordL.getColumn();
        if (("username").equals(column)) {
            tbRecordL.setColumn("tbuser.userName");
        } else if (("recId").equals(column)) {
            tbRecordL.setColumn("rec.id");
        } else if (("bookId").equals(column)) {
            tbRecordL.setColumn("book.id");
        } else if (("userId").equals(column)) {
            tbRecordL.setColumn("tbuser.id");
        } else if (("bookName").equals(column)) {
            tbRecordL.setColumn("book.bookName");
        } else if (("tel").equals(column)) {
            tbRecordL.setColumn("tbuser.telNum");
        }

        //如果未传入页数 对页数设置默认值
        if (tbRecordL.getCurrentPage() == null) {
            //设置默认当前页条数
            tbRecordL.setPageRows(Integer.parseInt(PAGE_ROWS));
            //设置默认的当前页码，因为第一页为1-10  第二页为11-20  所以 (currentPage-1)*pageRows
            tbRecordL.setCurrentPage((Integer.parseInt(CURRENT_PAGE) - 1) * Integer.parseInt(PAGE_ROWS));
            //将当前页返回到Controller
            currentPage = Integer.parseInt(CURRENT_PAGE);
        } else {
            //设置默认的当前页条数
            tbRecordL.setPageRows(Integer.parseInt(PAGE_ROWS));
            //传入页码，并保存，上一页下一页会用到
            currentPage = tbRecordL.getCurrentPage();
            //传入页码，计算出数据库中需要的正确的页码
            currentPageBySql = (tbRecordL.getCurrentPage() - 1) * Integer.parseInt(PAGE_ROWS);
            //如果传入的值计算后小于0，就从第一行开始取
            if (currentPageBySql < 0) {
                currentPageBySql = 0;
            }
            //将传入的页码设置到pageL对象中
            tbRecordL.setCurrentPage(currentPageBySql);
        }

        //查询数据库里的总条数，无条件查询，所有设置一个空格对象进行查询
        TbRecordL tbRecordLNull = new TbRecordL();
        totalRows = this.loan_managementMapperL.selectLoanRecord(tbRecordLNull).size();
        //设置默认的当前页条数，为配置文件中的
        pageRows = Integer.parseInt(PAGE_ROWS);
        //计算总页数，向上取整。因为向上取整需要Double类型，所以需要先转换一下，取整完以后再转换回来
        double totalRowsTemp = Double.valueOf(totalRows);
        double pageRowsTemp = Double.valueOf(pageRows);
        totalPages = (int) Math.ceil(totalRowsTemp / pageRowsTemp);

        //将Controller需要的当前页，总页数，列表内容 返回回去。
        pageL pageL1 = new pageL();
        pageL1.setCurrentPage(currentPage);
        pageL1.setPageRows(pageRows);
        pageL1.setTotalRows(totalRows);
        pageL1.setTotalPages(totalPages);
        //通过条件查询当前页的内容，返回回去
        pageL1.setPo(this.loan_managementMapperL.selectLoanRecord(tbRecordL));
        return pageL1;
    }

    @Override
    public void changLoanStatus(loanStatusL loanStatusL) throws Exception {
        if (loanStatusL.getId() == null) {
            //    抛出异常
        }
        this.loan_managementMapperL.updateLoanReturnBook(loanStatusL);
    }

    //获取预约列表
    @Override
    public pageL getBespeakRecord(TbOrderL tbOrderL) throws Exception {
        //为了保证数据安全性 前端页面下拉菜单中的选项 不直接使用数据库列名称，使用标识符，然后在service层进行匹配，并设置对应的数据库列名称
        String column = tbOrderL.getColumn();
        if (("username").equals(column)) {
            tbOrderL.setColumn("user.userName");
        } else if (("recId").equals(column)) {
            tbOrderL.setColumn("tborder.id");
        } else if (("bookId").equals(column)) {
            tbOrderL.setColumn("tborder.book_id");
        } else if (("userId").equals(column)) {
            tbOrderL.setColumn("tborder.user_id");
        } else if (("bookName").equals(column)) {
            tbOrderL.setColumn("library.bookName");
        } else if (("tel").equals(column)) {
            tbOrderL.setColumn("user.telNum");
        }
        //如果未传入页数 对页数设置默认值
        if (tbOrderL.getCurrentPage() == null) {
            //设置默认当前页条数
            tbOrderL.setPageRows(Integer.parseInt(PAGE_ROWS));
            //设置默认的当前页码，因为第一页为1-10  第二页为11-20  所以 (currentPage-1)*pageRows
            tbOrderL.setCurrentPage((Integer.parseInt(CURRENT_PAGE) - 1) * Integer.parseInt(PAGE_ROWS));
            //将当前页返回到Controller
            currentPage = Integer.parseInt(CURRENT_PAGE);
        } else {
            //设置默认的当前页条数
            tbOrderL.setPageRows(Integer.parseInt(PAGE_ROWS));
            //传入页码，并保存，上一页下一页会用到
            currentPage = tbOrderL.getCurrentPage();
            //传入页码，计算出数据库中需要的正确的页码
            currentPageBySql = (tbOrderL.getCurrentPage() - 1) * Integer.parseInt(PAGE_ROWS);
            //如果传入的值计算后小于0，就从第一行开始取
            if (currentPageBySql < 0) {
                currentPageBySql = 0;
            }
            //将传入的页码设置到pageL对象中
            tbOrderL.setCurrentPage(currentPageBySql);
        }

        //查询数据库里的总条数，无条件查询，所有设置一个空格对象进行查询
        TbOrderL tbOrderLNull = new TbOrderL();
        totalRows = this.loan_managementMapperL.selectBespeakRecord(tbOrderLNull).size();
        //设置默认的当前页条数，为配置文件中的
        pageRows = Integer.parseInt(PAGE_ROWS);
        //计算总页数，向上取整。因为向上取整需要Double类型，所以需要先转换一下，取整完以后再转换回来
        double totalRowsTemp = Double.valueOf(totalRows);
        double pageRowsTemp = Double.valueOf(pageRows);
        totalPages = (int) Math.ceil(totalRowsTemp / pageRowsTemp);

        //将Controller需要的当前页，总页数，列表内容 返回回去。
        pageL pageL1 = new pageL();
        pageL1.setCurrentPage(currentPage);
        pageL1.setPageRows(pageRows);
        pageL1.setTotalRows(totalRows);
        pageL1.setTotalPages(totalPages);
        //通过条件查询当前页的内容，返回回去
        pageL1.setPo(this.loan_managementMapperL.selectBespeakRecord(tbOrderL));
        return pageL1;
    }

    //获取借阅未还列表
    @Override
    public pageL getLoanOutStanding(TbOrderL tbOrderL) throws Exception {
        //为了保证数据安全性 前端页面下拉菜单中的选项 不直接使用数据库列名称，使用标识符，然后在service层进行匹配，并设置对应的数据库列名称
        String column = tbOrderL.getColumn();
        if (("username").equals(column)) {
            tbOrderL.setColumn("tbuser.userName");
        } else if (("recId").equals(column)) {
            tbOrderL.setColumn("record.id");
        } else if (("bookId").equals(column)) {
            tbOrderL.setColumn("record.book_id");
        } else if (("userId").equals(column)) {
            tbOrderL.setColumn("record.user_id");
        } else if (("bookName").equals(column)) {
            tbOrderL.setColumn("library.bookName");
        } else if (("tel").equals(column)) {
            tbOrderL.setColumn("tbuser.telNum");
        }

        //如果未传入页数 对页数设置默认值
        if (tbOrderL.getCurrentPage() == null) {
            //设置默认当前页条数
            tbOrderL.setPageRows(Integer.parseInt(PAGE_ROWS));
            //设置默认的当前页码，因为第一页为1-10  第二页为11-20  所以 (currentPage-1)*pageRows
            tbOrderL.setCurrentPage((Integer.parseInt(CURRENT_PAGE) - 1) * Integer.parseInt(PAGE_ROWS));
            //将当前页返回到Controller
            currentPage = Integer.parseInt(CURRENT_PAGE);
        } else {
            //设置默认的当前页条数
            tbOrderL.setPageRows(Integer.parseInt(PAGE_ROWS));
            //传入页码，并保存，上一页下一页会用到
            currentPage = tbOrderL.getCurrentPage();
            //传入页码，计算出数据库中需要的正确的页码
            currentPageBySql = (tbOrderL.getCurrentPage() - 1) * Integer.parseInt(PAGE_ROWS);
            //如果传入的值计算后小于0，就从第一行开始取
            if (currentPageBySql < 0) {
                currentPageBySql = 0;
            }
            //将传入的页码设置到pageL对象中
            tbOrderL.setCurrentPage(currentPageBySql);
        }

        //tbOrderL，无条件查询，所有设置一个空格对象进行查询。查询出来的就是所有记录，获取查询长度，就是总条数了
        TbOrderL tbOrderLNull = new TbOrderL();
        totalRows = this.loan_managementMapperL.selectLoanOutStanding(tbOrderLNull).size();
        //设置默认的当前页条数，为配置文件中的
        pageRows = Integer.parseInt(PAGE_ROWS);
        //计算总页数，向上取整。因为向上取整需要Double类型，所以需要先转换一下，取整完以后再转换回来
        double totalRowsTemp = Double.valueOf(totalRows);
        double pageRowsTemp = Double.valueOf(pageRows);
        totalPages = (int) Math.ceil(totalRowsTemp / pageRowsTemp);

        //将Controller需要的当前页，总页数，列表内容 返回回去。
        pageL pageL1 = new pageL();
        pageL1.setCurrentPage(currentPage);
        pageL1.setPageRows(pageRows);
        pageL1.setTotalRows(totalRows);
        pageL1.setTotalPages(totalPages);
        //通过条件查询当前页的内容，返回回去
        pageL1.setPo(this.loan_managementMapperL.selectLoanOutStanding(tbOrderL));
        return pageL1;
    }

    //插入借阅记录
    @Override
    public void addLoanList(TbRecord tbRecord) throws Exception {
        this.loan_managementMapperL.insertLoanList(tbRecord);
    }

    //删除预约记录
    @Override
    public void removeOrderList(Integer id) throws Exception {
        this.loan_managementMapperL.deleteOrderList(id);
    }

    //添加用户到黑名单
    @Override
    public void addUserToBlack(Integer id) throws Exception {
        this.loan_managementMapperL.updateUserBlack(id);
    }

    @Override
    public void removeOutTimeLoan(Integer id) throws Exception {
        this.tbRecordMapper.deleteByPrimaryKey(id);
    }

    //    通过搜索获取借阅逾期列表
    @Override
    public pageL findOutTimeList(LoanOutTimeL loanOutTimeL) throws Exception {
        //为了保证数据安全性 前端页面下拉菜单中的选项 不直接使用数据库列名称，使用标识符，然后在service层进行匹配，并设置对应的数据库列名称
        String column = loanOutTimeL.getColumn();
        if (("username").equals(column)) {
            loanOutTimeL.setColumn("tbuser.userName");
        } else if (("recId").equals(column)) {
            loanOutTimeL.setColumn("rec.id");
        } else if (("bookId").equals(column)) {
            loanOutTimeL.setColumn("book.id");
        } else if (("userId").equals(column)) {
            loanOutTimeL.setColumn("tbuser.id");
        } else if (("bookName").equals(column)) {
            loanOutTimeL.setColumn("book.bookName");
        } else if (("tel").equals(column)) {
            loanOutTimeL.setColumn("tbuser.telNum");
        }
        //如果未传入页数 对页数设置默认值
        if (loanOutTimeL.getCurrentPage() == null) {
            //设置默认当前页条数
            loanOutTimeL.setPageRows(Integer.parseInt(PAGE_ROWS));
            //设置默认的当前页码，因为第一页为1-10  第二页为11-20  所以 (currentPage-1)*pageRows
            loanOutTimeL.setCurrentPage((Integer.parseInt(CURRENT_PAGE) - 1) * Integer.parseInt(PAGE_ROWS));
            //将当前页返回到Controller
            currentPage = Integer.parseInt(CURRENT_PAGE);
        } else {
            //设置默认的当前页条数
            loanOutTimeL.setPageRows(Integer.parseInt(PAGE_ROWS));
            //传入页码，并保存，上一页下一页会用到
            currentPage = loanOutTimeL.getCurrentPage();
            //传入页码，计算出数据库中需要的正确的页码
            currentPageBySql = (loanOutTimeL.getCurrentPage() - 1) * Integer.parseInt(PAGE_ROWS);
            //如果传入的值计算后小于0，就从第一行开始取
            if (currentPageBySql < 0) {
                currentPageBySql = 0;
            }
            //将传入的页码设置到pageL对象中
            loanOutTimeL.setCurrentPage(currentPageBySql);
        }

        //查询数据库里的总条数，无条件查询，所有设置一个空格对象进行查询
        LoanOutTimeL loanOutTimeLNull = new LoanOutTimeL();
        totalRows = this.loan_managementMapperL.selectOutTimeList(loanOutTimeLNull).size();
        //设置默认的当前页条数，为配置文件中的
        pageRows = Integer.parseInt(PAGE_ROWS);
        //计算总页数，向上取整。因为向上取整需要Double类型，所以需要先转换一下，取整完以后再转换回来
        double totalRowsTemp = Double.valueOf(totalRows);
        double pageRowsTemp = Double.valueOf(pageRows);
        totalPages = (int) Math.ceil(totalRowsTemp / pageRowsTemp);

        //将Controller需要的当前页，总页数，列表内容 返回回去。
        pageL pageL1 = new pageL();
        pageL1.setCurrentPage(currentPage);
        pageL1.setPageRows(pageRows);
        pageL1.setTotalRows(totalRows);
        pageL1.setTotalPages(totalPages);
        //通过条件查询当前页的内容，返回回去
        pageL1.setPo(this.loan_managementMapperL.selectOutTimeList(loanOutTimeL));
        return pageL1;
    }
}
