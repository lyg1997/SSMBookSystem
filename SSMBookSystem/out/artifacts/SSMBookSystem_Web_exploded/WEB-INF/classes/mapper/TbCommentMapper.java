package mapper;

import org.apache.ibatis.annotations.Param;
import po.TbComment;
import po.TbCommentExample;

import java.util.List;

public interface TbCommentMapper {
    int countByExample(TbCommentExample example);

    int deleteByExample(TbCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbComment record);

    int insertSelective(TbComment record);

    List<TbComment> selectByExampleWithBLOBs(TbCommentExample example);

    List<TbComment> selectByExample(TbCommentExample example);

    TbComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbComment record, @Param("example") TbCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") TbComment record, @Param("example") TbCommentExample example);

    int updateByExample(@Param("record") TbComment record, @Param("example") TbCommentExample example);

    int updateByPrimaryKeySelective(TbComment record);

    int updateByPrimaryKeyWithBLOBs(TbComment record);

    int updateByPrimaryKey(TbComment record);
}