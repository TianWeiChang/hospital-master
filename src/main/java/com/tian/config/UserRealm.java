package com.tian.config;

import com.tian.entity.User;
import com.tian.service.MenuService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @description 认证
 * @createTime 2022年09月16日
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private MenuService menuService;

    @Resource
    private RedisConfig redisConfig;

    /*
     * 认证
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取的前台username

        String username = (String) authenticationToken.getPrincipal();

        User sysUser = null;
        try {
            sysUser = menuService.loginName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断对象是否有值
        if (sysUser == null) {
            return null;
        }

        redisConfig.add(RedisKeyPre.USER_INFO_KEY_PRE + sysUser.getUserid(),sysUser);

        //密码不需要我们比对，shiro会给我们比对                      //对象    //获取前台密码
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, sysUser.getPwd(), ByteSource.Util.bytes(sysUser.getSalt()), getName());
        return info;

    }

    /*
     * 授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
