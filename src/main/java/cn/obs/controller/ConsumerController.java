package cn.obs.controller;

import cn.obs.po.DataGrid;
import cn.obs.po.Page;
import cn.obs.service.ConsumerService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ww on 2018/5/11.
 */

@Controller
@RequestMapping(value = "/consumer",produces = {"application/json;charset=UTF-8"} )
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(consumerService.list(page));
        dataGrid.setTotal(consumerService.count());
        return JSON.toJSONString(dataGrid);
    }


}
