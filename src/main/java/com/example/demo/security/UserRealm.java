package com.example.demo.security;

import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import com.example.demo.vo.ResourcesVo;
import com.example.demo.vo.RoleVo;
import com.example.demo.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 认证
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        log.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();

        User user = userService.findByName(name);
        if (null == user) {
            throw new UnknownAccountException();//没找到帐号
        }
        // 用户为禁用状态
        if (1 != user.getLock()) {
            throw new DisabledAccountException();
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassWord(), getName());
        log.info("---------------- 执行 Shiro 凭证成功 ----------------------");
        return authenticationInfo;
    }

    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        log.info("---------------- 执行 Shiro 权限获取 ---------------------");
        User user = (User) principal.getPrimaryPrincipal();
        UserVo userVo = userService.findUserByName(user.getUserName());

        Set<String> roles = new HashSet<>();
        Set<String> resources = new HashSet<>();

        Set<RoleVo> userRoles = userVo.getRoles();
        for (RoleVo r : userRoles) {
            roles.add(r.getRname());
            for (ResourcesVo re : r.getResourcesVos()) {
                resources.add(re.getRename());
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(resources);
        log.info("---------------- Shiro 权限获取成功 ----------------------");
        return info;
    }
}
