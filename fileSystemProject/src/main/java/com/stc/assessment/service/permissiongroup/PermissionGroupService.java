package com.stc.assessment.service.permissiongroup;

import com.stc.assessment.domain.Permission;
import com.stc.assessment.domain.PermissionGroup;
import com.stc.assessment.restapi.permissiongroup.PermissionGroupDto;

import java.util.List;

public interface PermissionGroupService {

    public PermissionGroup createPermissionGroup(PermissionGroupDto permissionGroupDto);

    public PermissionGroup getPermissionGroupByName(String groupName);

    public PermissionGroup getPermissionGroupById(Long groupId);

    public List<Permission> getAllPermissionByPermissionGroupGroupName(String groupName);

    public List<Permission> getAllPermissionByPermissionGroupId(Long groupId);
}
