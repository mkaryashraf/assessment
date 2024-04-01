package com.stc.assessment.restapi.permission;

import com.stc.assessment.dataaccess.PermissionRepository;

import com.stc.assessment.domain.Permission;
import com.stc.assessment.restapi.permissiongroup.PermissionGroupMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PermissionMapper {

    @Autowired
    protected PermissionRepository permissionRepository;

    @Autowired
    protected PermissionGroupMapper permissionGroupMapper;

    @Mapping(target= "permissionGroup" , expression ="java(permissionGroupMapper.mapPermissionGroupDtoToPermissionGroup(permissionDto.getPermissionGroupDto()))" )
    public abstract Permission mapPermissionDtoToPermission(PermissionDto permissionDto);

    @Mapping(target= "permissionGroupDto" , expression ="java(permissionGroupMapper.mapPermissionGroupToPermissionGroupDto(permission.getPermissionGroup()))" )
    public abstract PermissionDto mapPermissionToPermissionDto(Permission permission);


    public abstract List<Permission> mapPermissionDtoListToPermissionList(List<PermissionDto> permissionDtoList);

    public abstract List<PermissionDto> mapPermissionListToPermissionDtoList(List<Permission> permissionList);

}
