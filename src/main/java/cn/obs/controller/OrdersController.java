package cn.obs.controller;

import cn.obs.po.Orders;
import cn.obs.po.DataGrid;
import cn.obs.po.Page;
import cn.obs.service.OrdersService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ww on 2018/5/11.
 */

@Controller
@RequestMapping(value = "/orders",produces = {"application/json;charset=UTF-8"} )
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("/listbystate/{state}")
    @ResponseBody
    public String getList(Page page,@PathVariable String state){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(ordersService.vo(ordersService.listByState(page,state)));
        dataGrid.setTotal(ordersService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(ordersService.list(page));
        dataGrid.setTotal(ordersService.count());
        return JSON.toJSONString(dataGrid);
    }


    @RequestMapping("/addition")
    @ResponseBody
    public String add(Orders Orders) {
        try {
            ordersService.insert(Orders);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Orders orders) {
        orders.setOid(id);
        try {
            ordersService.update(orders);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            ordersService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/setShipped/{id}")
    @ResponseBody
    public String setShipped(@PathVariable Integer id) {
        Orders orders = new Orders();
        orders.setState("已发货");
        orders.setOid(id);
        try {
            ordersService.update(orders);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

}
