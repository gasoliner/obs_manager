package cn.obs.service.impl;

import cn.obs.mapper.OrdersMapper;
import cn.obs.po.Consumer;
import cn.obs.po.Orders;
import cn.obs.po.OrdersExample;
import cn.obs.po.Page;
import cn.obs.service.ConsumerService;
import cn.obs.service.OrdersService;
import cn.obs.util.TimeUtils;
import cn.obs.vo.VoOrders;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    OrdersMapper ordersMapper;

    long total = 0L;

    @Override
    public List<Orders> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Orders> list = ordersMapper.selectByExample(new OrdersExample());
        PageInfo<Orders> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Orders record) {
        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public Orders selectByPrimaryKey(Integer hid) {
        return ordersMapper.selectByPrimaryKey(hid);
    }

    @Override
    public List<VoOrders> vo(List<Orders> list) {
        List<VoOrders> list1 = new ArrayList<>();
        for (Orders orders:
                list) {
            VoOrders voOrders = new VoOrders(orders);
            Consumer consumer = consumerService.selectByPrimaryKey(voOrders.getCid());
            voOrders.setVoCid(consumer.getNickname());
            voOrders.setVoPublish(TimeUtils.dateToString(voOrders.getTime()));
            voOrders.setVoReceive(consumer.getReceive());
            if ("已支付".equals(voOrders.getState())) {
                voOrders.setVoAction("<a href = \"#\" onclick=\"setShipped('" + voOrders.getOid() + "')\">设置为已发货</a>");
            } else {
                voOrders.setVoAction("无");
            }
            list1.add(voOrders);
        }
        return list1;
    }

    @Override
    public List<Orders> listByCid(int i) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(i);
        List<Orders> list = ordersMapper.selectByExample(example);
        this.total = list.size();
        return list;
    }

    @Override
    public List<Orders> listByState(Page page, String state) {
        PageHelper.startPage(page.getPage(), page.getRows());
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(state);
        List<Orders> list = ordersMapper.selectByExample(example);
        PageInfo<Orders> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

}
