package com.aitutech.lorenzo.common.shiro;

import com.aitutech.lorenzo.common.domain.User;
import com.aitutech.lorenzo.common.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;
    /**
     *  用于授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        User user = (User)principals.getPrimaryPrincipal();
//        if (user != null){
//            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
////            authorizationInfo.addRoles(permissionService.findPermissionRolesOfUser(userToken.getUser()));
//            authorizationInfo.addStringPermissions(permissionService.findPermissionPrivilegesByUser());
//            return authorizationInfo;
//        }
        return null;
    }

    /**
     *  定义如何获取用户信息的业务逻辑，给shiro做登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;

        // 获取从表单传过来的用户名
        String username = usernamePasswordToken.getUsername();

        User user = this.loginService.findByUsername(username);

        if (user == null){
            throw new UnknownAccountException("用户不存在！");
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
