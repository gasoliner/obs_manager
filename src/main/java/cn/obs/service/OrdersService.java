package cn.obs.service;

import cn.obs.po.Orders;
import cn.obs.po.Page;
import cn.obs.vo.VoOrders;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface OrdersService {
    List<Orders> list(Page page);
    int insert(Orders record);

    int delete(Integer id);

    int update(Orders record);

    long count();

    Orders selectByPrimaryKey(Integer hid);

    List<VoOrders> vo(List<Orders> list);

    List<Orders> listByCid(int i);

    List<Orders> listByState(Page page,String state);
}
