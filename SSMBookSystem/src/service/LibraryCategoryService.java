package service;

import po.CustomPO.TbCategoryExt;
import po.PageCount;
import po.TbCategory;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @description: 图书类目 服务接口
 *
 */

public interface LibraryCategoryService {
    // 获取 图书类目集合
    List<TbCategory> getCategoryAll();

    /**
     * 获取 图书类目集合,附带 父 id 的 类目名称
     *
     * @param pageCount 分页信息
     * @return
     */
    PageCount<TbCategoryExt> getCategoryAllWithParentName(PageCount pageCount);

    /**
     * 添加 新的 类目
     *
     * @param category
     * @param session
     */
    void addBookCategory(TbCategory category, HttpSession session);

    /**
     * 根据 类目id 删除 类目 信息
     *
     * @param id
     */
    void delBookCategoryById(int id);

    /**
     * 根据 类目id 修改 类目 信息
     *
     * @param category
     */
    void updateBookCategoryById(TbCategory category);

    /**
     * 根据 类目 id 查询数据
     */
    TbCategory getCategoryById(int id);

    /**
     * 根据 父类目查询 其子类目
     */
    List<TbCategory> getCategoryByParentId(int parentId);

    // 若 当前 类目 为 父类目 则获取 其 下面 的 所有子类目
    // 若 当前 类目 为 子类目 则获取 其 同级 类目
    List<TbCategory> getCategoryByCid(int cid);

}
