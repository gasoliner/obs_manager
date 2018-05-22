package cn.obs.controller;

import cn.obs.po.Manager;
import cn.obs.service.ManagerService;
import cn.obs.util.PageUtil;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"} )
public class LoginController {


    @Autowired
    ManagerService managerService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String name, String password, HttpSession session){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                name,
                password
        );
        try {
            currentUser.login(token);
            Manager manager = managerService.selectByPrimaryKey(Integer.parseInt(name));
            session.setAttribute("manager",manager);
            return "/";
        }catch (Exception e){
            return "/login";
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public void logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return;
    }

}
