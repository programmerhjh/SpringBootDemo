package prv.hjh.boot.restcontroller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/14.
 * 用户信息控制器
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    /**
     * 用户查询.
     * @return
     * @RequiresPermissions 权限管理
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")
    public String userInfo(){
        return "shiro/userInfo";
    }

    /**
     * 用户添加;
     * @return
     * @RequiresPermissions 权限管理
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd(){
        return "shiro/userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     * @RequiresPermissions 权限管理
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    public String userDel(){
        return "shiro/userInfoDel";
    }
}
