package prv.hjh.boot.service;

import prv.hjh.boot.domain.SysPermission;

import java.util.List;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/14.
 * 系统权限接口
 */
public interface SysPermissionService {

    /**
     * 通过父ID获取权限实体集合
     * @param parentId
     * @return
     */
    List<SysPermission> getPermissionByParentId(Long parentId);
}
