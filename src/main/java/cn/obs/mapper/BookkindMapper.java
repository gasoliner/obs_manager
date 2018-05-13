package cn.obs.mapper;

import cn.obs.po.Bookkind;
import cn.obs.po.BookkindExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookkindMapper {
    long countByExample(BookkindExample example);

    int deleteByExample(BookkindExample example);

    int deleteByPrimaryKey(Integer bkid);

    int insert(Bookkind record);

    int insertSelective(Bookkind record);

    List<Bookkind> selectByExample(BookkindExample example);

    Bookkind selectByPrimaryKey(Integer bkid);

    int updateByExampleSelective(@Param("record") Bookkind record, @Param("example") BookkindExample example);

    int updateByExample(@Param("record") Bookkind record, @Param("example") BookkindExample example);

    int updateByPrimaryKeySelective(Bookkind record);

    int updateByPrimaryKey(Bookkind record);
}