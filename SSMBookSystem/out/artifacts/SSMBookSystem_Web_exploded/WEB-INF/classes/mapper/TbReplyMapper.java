package mapper;

import org.apache.ibatis.annotations.Param;
import po.TbReply;
import po.TbReplyExample;

import java.util.List;

public interface TbReplyMapper {
    int countByExample(TbReplyExample example);

    int deleteByExample(TbReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbReply record);

    int insertSelective(TbReply record);

    List<TbReply> selectByExampleWithBLOBs(TbReplyExample example);

    List<TbReply> selectByExample(TbReplyExample example);

    TbReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbReply record, @Param("example") TbReplyExample example);

    int updateByExampleWithBLOBs(@Param("record") TbReply record, @Param("example") TbReplyExample example);

    int updateByExample(@Param("record") TbReply record, @Param("example") TbReplyExample example);

    int updateByPrimaryKeySelective(TbReply record);

    int updateByPrimaryKeyWithBLOBs(TbReply record);

    int updateByPrimaryKey(TbReply record);
}