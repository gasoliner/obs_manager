package cn.obs.service;

import cn.obs.po.Manager;
import cn.obs.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface ManagerService {
    List<Manager> list(Page page);

    int insert(Manager record);

    int delete(Integer id);

    int update(Manager record);

    long count();

    Manager selectByPrimaryKey(Integer id);
}
