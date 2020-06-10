package service;

import po.CustomPO.TbCategoryExt;
import po.PageCount;
import po.TbCategory;

import javax.servlet.http.HttpSession;
import java.util.List;

    //图书类目 服务接口
public interface LibraryCategoryService {
    // 获取 图书类目集合
    List<TbCategory> getCategoryAll();
     //获取带类目名称的图书集合
    PageCount<TbCategoryExt> getCategoryAllWithParentName(PageCount pageCount);
     //添加类目
    void addBookCategory(TbCategory category, HttpSession session);
     //根据类目id删除
    void delBookCategoryById(int id);
    //  根据类目id 修改
    void updateBookCategoryById(TbCategory category);
    //根据 类目 id 查询数据
    TbCategory getCategoryById(int id);
    //根据 父类目查询 其子类目
    List<TbCategory> getCategoryByParentId(int parentId);
    // 若当前类目为父类目则获取其下面的所有子类目
    // 若当前类目为子类目则获取其同级类目
    List<TbCategory> getCategoryByCid(int cid);

}
