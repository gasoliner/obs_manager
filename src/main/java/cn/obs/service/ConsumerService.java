package cn.obs.service;

import cn.obs.po.Consumer;
import cn.obs.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface ConsumerService {
    List<Consumer> list(Page page);

    int insert(Consumer record);

    int delete(Integer id);

    int update(Consumer record);

    long count();

    Consumer selectByPrimaryKey(Integer cid);
}
