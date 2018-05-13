package cn.obs.controller;

import cn.obs.po.Bookkind;
import cn.obs.po.DataGrid;
import cn.obs.po.Page;
import cn.obs.service.BookkindService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ww on 2018/5/12.
 */
@Controller
@RequestMapping(value = "/bookkind",produces = {"application/json;charset=UTF-8"} )
public class BookkindController {

    @Autowired
    BookkindService bookkindService;

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(bookkindService.list(page));
        dataGrid.setTotal(bookkindService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Bookkind bookkind) {
        try {
            bookkindService.insert(bookkind);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id,Bookkind bookkind) {
        bookkind.setBkid(id);
        try {
            bookkindService.update(bookkind);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            bookkindService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }
}
