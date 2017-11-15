package prv.hjh.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prv.hjh.boot.dao.SysPermissionRepository;
import prv.hjh.boot.domain.SysPermission;
import prv.hjh.boot.service.SysPermissionService;

import java.util.List;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/14.
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionRepository permissionRepository;

    @Override
    public List<SysPermission> getPermissionByParentId(Long parentId) {
        return permissionRepository.getSysPermissionByParentId(parentId);
    }
}
