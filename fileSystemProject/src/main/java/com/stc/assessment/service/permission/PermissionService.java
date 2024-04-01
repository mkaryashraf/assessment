package com.stc.assessment.service.permission;

import com.stc.assessment.domain.Permission;
import com.stc.assessment.restapi.permission.PermissionDto;

import java.util.List;

public interface PermissionService {
    public Permission getPermissionByUserEmailAndPermissionGroupGroupName(String userEmail, String groupName);

    public List<Permission> getPermissionByUserEmail(String userEmail);

    public Permission createPermission(PermissionDto permissionDto);
}
