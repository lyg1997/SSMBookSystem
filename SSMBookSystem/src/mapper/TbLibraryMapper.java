package mapper;

import org.apache.ibatis.annotations.Param;
import po.TbLibrary;
import po.TbLibraryExample;
import po.TbUser;

import java.util.List;

public interface TbLibraryMapper {
    int countByExample(TbLibraryExample example);

    int deleteByExample(TbLibraryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbLibrary record);

    int insertSelective(TbLibrary record);

    TbLibrary selectByBarcode(String barcode);

    TbUser selectByStuNum(@Param("stuNum")String stuNum);

    List<TbLibrary> selectByExample(TbLibraryExample example);

    TbLibrary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbLibrary record, @Param("example") TbLibraryExample example);

    int updateByExample(@Param("record") TbLibrary record, @Param("example") TbLibraryExample example);

    int updateByPrimaryKeySelective(TbLibrary record);

    int updateByPrimaryKey(TbLibrary record);
}