package com.stc.assessment.restapi.permissiongroup;

import com.stc.assessment.dataaccess.PermissionGroupRepository;
import com.stc.assessment.dataaccess.PermissionRepository;
import com.stc.assessment.domain.PermissionGroup;
import com.stc.assessment.restapi.permission.PermissionMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PermissionGroupMapper {

    @Autowired
    protected PermissionGroupRepository PermissionGroupRepository;

    @Autowired
    protected PermissionRepository permissionRepository;


    public abstract PermissionGroup mapPermissionGroupDtoToPermissionGroup(PermissionGroupDto permissionGroupDto);

    public abstract PermissionGroupDto mapPermissionGroupToPermissionGroupDto(PermissionGroup permissionGroup);


    public abstract List<PermissionGroup> mapPermissionGroupDtoListToPermissionGroupList(List<PermissionGroupDto> permissionGroupDtoList);

    public abstract List<PermissionGroupDto> mapPermissionGroupListToPermissionGroupDtoList(List<PermissionGroup> permissionGroupList);

}
