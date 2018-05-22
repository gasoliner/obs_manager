package cn.obs.service.impl;

import cn.obs.mapper.ConsumerMapper;
import cn.obs.po.Consumer;
import cn.obs.po.ConsumerExample;
import cn.obs.po.Page;
import cn.obs.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ConsumerMapper consumerMapper;

    @Override
    public List<Consumer> list(Page page) {
        return consumerMapper.selectByExample(new ConsumerExample());
    }

    @Override
    public int insert(Consumer record) {
        return consumerMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return consumerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Consumer record) {
        return consumerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return consumerMapper.countByExample(new ConsumerExample());
    }

    @Override
    public Consumer selectByPrimaryKey(Integer cid) {
        return consumerMapper.selectByPrimaryKey(cid);
    }
}
