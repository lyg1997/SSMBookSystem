package mapper;

import org.apache.ibatis.annotations.Param;
import po.TbRecord;
import po.TbRecordExample;

import java.util.List;

public interface TbRecordMapper {
    int countByExample(TbRecordExample example);

    int deleteByExample(TbRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRecord record);

    int insertSelective(TbRecord record);

    List<TbRecord> selectByExample(TbRecordExample example);

    TbRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRecord record, @Param("example") TbRecordExample example);

    int updateByExample(@Param("record") TbRecord record, @Param("example") TbRecordExample example);

    int updateByPrimaryKeySelective(TbRecord record);

    int updateByPrimaryKey(TbRecord record);
}