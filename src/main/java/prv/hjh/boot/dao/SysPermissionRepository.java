package prv.hjh.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import prv.hjh.boot.domain.SysPermission;

import java.util.List;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/14.
 * 系统权限dao
 */
public interface SysPermissionRepository extends JpaRepository<SysPermission,Integer>{

    /**
     * 通过父ID获取权限实体
     * @param parentId
     * @return
     */
    List<SysPermission> getSysPermissionByParentId(Long parentId);
}
