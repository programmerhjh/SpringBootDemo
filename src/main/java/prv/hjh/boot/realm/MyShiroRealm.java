package prv.hjh.boot.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import prv.hjh.boot.domain.Role;
import prv.hjh.boot.domain.SysPermission;
import prv.hjh.boot.domain.UserInfo;
import prv.hjh.boot.service.SysPermissionService;
import prv.hjh.boot.service.UserInfoService;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/13.
 * 自定义的 Realm
 * 用于进行权限信息的验证，我们自己实现。
 * Realm 本质上是一个特定的安全 DAO：它封装与数据源连接的细节，得到Shiro 所需的相关的数据。
 * 在配置 Shiro 的时候，你必须指定至少一个Realm 来实现认证（authentication）和/或授权（authorization）
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private UserInfoService userInfoService;

    /*
     * Shiro的链接权限授权是通过继承AuthorizingRealm抽象类，重载doGetAuthorizationInfo();
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo进行角色的添加和权限的添加。
     *
     *
     *
     * 也可以添加set集合：
     * authorizationInfo.setRoles(roles);
     * authorizationInfo.setStringPermissions(stringPermissions);
     * roles是从数据库查询的当前用户的角色，stringPermissions是从数据库查询的当前用户对应的权限
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”, “perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”, “roles[100002]，perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限和具有“100002”这个角色才可以访问。
     */

    /**
     * 获取用户权限信息来配置用户权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principalCollection.getPrimaryPrincipal();
        for(Role role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            /*
            // 标识权限id来判断其最高的权限id
            Long tempParentId;
            if (null != role.getPermissions()){
                tempParentId = role.getPermissions().get(0).getParentId();
            }else{
                tempParentId = null;
            }*/
            for(SysPermission p:role.getPermissions()){
                /*
                if(null != tempParentId){
                    // 找出最高权限的父id
                    if(tempParentId > p.getParentId()){
                        tempParentId = p.getParentId();
                    }
                }
                */
                authorizationInfo.addStringPermission(p.getPermission());
            }
            /*
            getEntitySysPermissions(tempParentId);
            */
        }
        return authorizationInfo;
    }

    /**
     * 获取权限父ID下属所有权限的实体
     * // @param parentId
     */
    /*
    public void getEntitySysPermissions(Long parentId){
        // 临时存放权限的父ID
        Long tempParentId;
        List<SysPermission> sysPermissions = permissionService.getPermissionByParentId(parentId);
        if(null != sysPermissions){
            tempParentId = sysPermissions.get(0).getParentId();
            for(SysPermission permission:sysPermissions){
                permission.toString();
                if(tempParentId > permission.getParentId()){
                    tempParentId = permission.getParentId();
                }
            }
            if(tempParentId != 0){
                getEntitySysPermissions(tempParentId);
            }
        }
    }
    */

    /**
     * 登陆认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存。
        //如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户名
                userInfo,
                //密码
                userInfo.getPassword(),
                //salt=username+salt
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                //realm name
                getName()
        );
        return authenticationInfo;
    }
}
