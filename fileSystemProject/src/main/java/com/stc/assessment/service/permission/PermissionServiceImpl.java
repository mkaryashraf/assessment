package com.stc.assessment.service.permission;

import com.stc.assessment.dataaccess.PermissionGroupRepository;
import com.stc.assessment.dataaccess.PermissionRepository;
import com.stc.assessment.domain.Permission;
import com.stc.assessment.restapi.permission.PermissionDto;
import com.stc.assessment.restapi.permission.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    @Override
    public Permission getPermissionByUserEmailAndPermissionGroupGroupName(String userEmail, String groupName) {
        return permissionRepository.findByUserEmailAndPermissionGroupGroupName(userEmail,groupName);
    }

    @Override
    public List<Permission> getPermissionByUserEmail(String userEmail) {
        return permissionRepository.findAllByUserEmail(userEmail);
    }

    @Override
    public Permission createPermission(PermissionDto permissionDto) {
        Permission permission = permissionMapper.mapPermissionDtoToPermission(permissionDto);
        permission.setPermissionGroup(permissionGroupRepository.findByGroupName(permissionDto.getPermissionGroupDto().getGroupName()));
        permission = permissionRepository.save(permission);
        return permission;
    }
}
