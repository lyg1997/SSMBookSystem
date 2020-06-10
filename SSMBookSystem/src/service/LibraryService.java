package service;

import org.springframework.web.multipart.MultipartFile;
import po.*;
import po.CustomPO.BookExt;
import po.CustomPO.TbLibraryQuery;
import po.CustomPO.TblibraryExt;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 *
 * @description: Library 服务接口
 *
 */

public interface LibraryService {
    /**
     * 按条件 分页查询图书列表
     *
     * @param tbLibraryQuery 查询条件
     * @param pageCount      分页信息
     * @return
     */
    PageCount<TblibraryExt> findLibraryByAll(TbLibraryQuery tbLibraryQuery, PageCount pageCount);

    /**
     * 通过 图书id 查询图书信息
     *
     * @param id 图书id
     * @return
     */
    TbLibrary findLibraryByBid(int id);

    /**
     * 修改图书信息
     *
     * @param uploadFile 图片
     * @param library    图书信息
     * @return
     */
    String updateOrSaveLibrary(MultipartFile uploadFile, TbLibrary library, HttpServletRequest request) throws IOException;


    /**
     * 根据 图书 id 来删除图书
     *
     * @param id
     */
    void delBookById(int id);


    /**
     * 通过 图书的 id 来查询 图书 的 详细信息
     *
     * @param id
     * @return
     */
    BookExt getBookInfoById(int id);

    /**
     * 添加评论信息
     *
     * @param comment
     */
    void addCommentInfo(TbComment comment);

    /**
     * 预约图书
     *
     * @param order
     */
    void jieyueBookById(TbOrder order);


}
