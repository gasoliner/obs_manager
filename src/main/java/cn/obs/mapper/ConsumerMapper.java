package cn.obs.mapper;

import cn.obs.po.Consumer;
import cn.obs.po.ConsumerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsumerMapper {
    long countByExample(ConsumerExample example);

    int deleteByExample(ConsumerExample example);

    int deleteByPrimaryKey(String cid);

    int insert(Consumer record);

    int insertSelective(Consumer record);

    List<Consumer> selectByExample(ConsumerExample example);

    Consumer selectByPrimaryKey(String cid);

    int updateByExampleSelective(@Param("record") Consumer record, @Param("example") ConsumerExample example);

    int updateByExample(@Param("record") Consumer record, @Param("example") ConsumerExample example);

    int updateByPrimaryKeySelective(Consumer record);

    int updateByPrimaryKey(Consumer record);
}