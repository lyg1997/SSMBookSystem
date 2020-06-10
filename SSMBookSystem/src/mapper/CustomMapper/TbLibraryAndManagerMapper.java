package mapper.CustomMapper;

import po.CustomPO.TbLibraryQuery;
import po.CustomPO.TblibraryExt;

import java.util.List;

/**

 * @description: 接口类
 */

public interface TbLibraryAndManagerMapper {
    List<TblibraryExt> findLibraryByCriteria(TbLibraryQuery libraryQuery);

    List<TblibraryExt> findAll(TbLibraryQuery libraryQuery);
}
