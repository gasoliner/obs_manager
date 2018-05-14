package cn.obs.controller;

import cn.obs.po.Manager;
import cn.obs.po.DataGrid;
import cn.obs.po.Page;
import cn.obs.service.ManagerService;
import cn.obs.util.PageUtil;
import cn.obs.util.StringUtil;
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
@RequestMapping(value = "/manager",produces = {"application/json;charset=UTF-8"} )
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(managerService.list(page));
        dataGrid.setTotal(managerService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Manager manager) {
        try {
            managerService.insert(manager);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Manager manager) {
        manager.setMid(id);
        try {
            managerService.update(manager);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            managerService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/password")
    @ResponseBody
    public String password(Integer mid,String oldpassword,String newpassword1,String newpassword2) {
        if (StringUtil.isNotEmpty(newpassword1) &&
                StringUtil.isNotEmpty(newpassword2) &&
                newpassword1.equals(newpassword2)) {
            try {
                if (managerService.selectByPrimaryKey(mid).getPassword().equals(oldpassword)) {
                    Manager manager = new Manager();
                    manager.setMid(mid);
                    manager.setPassword(newpassword1);
                    managerService.update(manager);
                    return JSON.toJSONString("操作成功");
                }
            } catch (Exception e) {
            }
        }
        return JSON.toJSONString("操作失败");
    }
}
