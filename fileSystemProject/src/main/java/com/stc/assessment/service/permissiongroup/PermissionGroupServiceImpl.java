package com.stc.assessment.service.permissiongroup;

import com.stc.assessment.dataaccess.PermissionGroupRepository;
import com.stc.assessment.dataaccess.PermissionRepository;
import com.stc.assessment.domain.Permission;
import com.stc.assessment.domain.PermissionGroup;
import com.stc.assessment.restapi.permissiongroup.PermissionGroupDto;
import com.stc.assessment.restapi.permissiongroup.PermissionGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionGroupServiceImpl implements PermissionGroupService{

    @Autowired
    private PermissionGroupMapper permissionGroupMapper;

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    @Autowired
    private PermissionRepository permissionRepository;
    @Override
    public PermissionGroup createPermissionGroup(PermissionGroupDto permissionGroupDto) {
        PermissionGroup permissionGroup = permissionGroupMapper.mapPermissionGroupDtoToPermissionGroup(permissionGroupDto);
        permissionGroup = permissionGroupRepository.save(permissionGroup);
        return permissionGroup;
    }

    @Override
    public PermissionGroup getPermissionGroupByName(String groupName) {
        return permissionGroupRepository.findByGroupName(groupName);
    }

    @Override
    public PermissionGroup getPermissionGroupById(Long groupId) {
        return permissionGroupRepository.getById(groupId);
    }

    @Override
    public List<Permission> getAllPermissionByPermissionGroupGroupName(String groupName) {
        return permissionRepository.findAllByPermissionGroupGroupName(groupName);
    }

    @Override
    public List<Permission> getAllPermissionByPermissionGroupId(Long groupId) {
        return permissionRepository.findAllByPermissionGroupId(groupId);
    }
}
