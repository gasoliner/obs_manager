package cn.obs.service;

import cn.obs.po.Bookkind;
import cn.obs.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface BookkindService {
    List<Bookkind> list(Page page);

    int insert(Bookkind record);

    int delete(Integer id);

    int update(Bookkind record);

    long count();

    Bookkind selectByPrimaryKey(Integer kind);
}
