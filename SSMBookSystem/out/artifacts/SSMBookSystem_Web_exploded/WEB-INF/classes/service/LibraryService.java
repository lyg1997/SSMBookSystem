package service;

import org.springframework.web.multipart.MultipartFile;
import po.*;
import po.CustomPO.BookExt;
import po.CustomPO.TbLibraryQuery;
import po.CustomPO.TblibraryExt;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

      //Library 服务接口
public interface LibraryService {
     //按条件分页查询图书列表
    PageCount<TblibraryExt> findLibraryByAll(TbLibraryQuery tbLibraryQuery, PageCount pageCount);
     //通过id查询图书信息
    TbLibrary findLibraryByBid(int id);
    //修改图书信息
    String updateOrSaveLibrary(MultipartFile uploadFile, TbLibrary library, HttpServletRequest request) throws IOException;
     //根据id来删除图书
    void delBookById(int id);
    //通过id来查询图书
    BookExt getBookInfoById(int id);
     //添加评论信息
    void addCommentInfo(TbComment comment);
    //预约图书
    void jieyueBookById(TbOrder order);


}
