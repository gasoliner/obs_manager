package cn.obs.security;

import cn.obs.po.Manager;
import cn.obs.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class DefineRealm extends AuthorizingRealm {

    @Autowired
    ManagerService managerService;

//    授权的验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

//    登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("shiro 登录");
        String name = (String) authenticationToken.getPrincipal();
        Manager manager = managerService.selectByPrimaryKey(Integer.parseInt(name));
        if(manager == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                manager.getName(),
                manager.getPassword(),
                getName()
        );
        return authenticationInfo;
    }
}
