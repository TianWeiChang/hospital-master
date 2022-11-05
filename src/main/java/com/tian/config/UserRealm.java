package com.tian.config;

import com.tian.entity.User;
import com.tian.service.MenuService;
import lombok.extern.slf4j.Slf4j;
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
 * @date 2022年09月16日
 * <p>
 * 认证
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    private MenuService menuService;

    @Resource
    private RedisConfig redisConfig;

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取的前台username

        String userName = (String) authenticationToken.getPrincipal();

        User sysUser = null;
        try {
            sysUser = menuService.loginName(userName);
        } catch (Exception e) {
            log.error("查询数据库失败,error:", e);
        }
        //判断对象是否有值
        if (sysUser == null) {
            log.error("用户信息不存在，userName={}", userName);
            return null;
        }
        //用户信息缓存到Redis中
        redisConfig.add(RedisKeyPre.USER_INFO_KEY_PRE + sysUser.getUserid(), sysUser);

        //密码不需要我们比对，shiro会给我们比对                      //对象    //获取前台密码
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPwd(), ByteSource.Util.bytes(sysUser.getSalt()), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
