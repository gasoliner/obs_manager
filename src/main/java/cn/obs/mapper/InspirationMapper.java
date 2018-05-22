package cn.obs.mapper;

import cn.obs.po.Inspiration;
import cn.obs.po.InspirationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InspirationMapper {
    long countByExample(InspirationExample example);

    int deleteByExample(InspirationExample example);

    int deleteByPrimaryKey(Integer inid);

    int insert(Inspiration record);

    int insertSelective(Inspiration record);

    List<Inspiration> selectByExample(InspirationExample example);

    Inspiration selectByPrimaryKey(Integer inid);

    int updateByExampleSelective(@Param("record") Inspiration record, @Param("example") InspirationExample example);

    int updateByExample(@Param("record") Inspiration record, @Param("example") InspirationExample example);

    int updateByPrimaryKeySelective(Inspiration record);

    int updateByPrimaryKey(Inspiration record);
}