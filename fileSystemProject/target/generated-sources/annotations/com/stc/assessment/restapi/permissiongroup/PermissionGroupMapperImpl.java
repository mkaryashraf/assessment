package com.stc.assessment.restapi.permissiongroup;

import com.stc.assessment.domain.Permission;
import com.stc.assessment.domain.PermissionGroup;
import com.stc.assessment.restapi.permission.PermissionDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-01T01:08:26+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class PermissionGroupMapperImpl extends PermissionGroupMapper {

    @Override
    public PermissionGroup mapPermissionGroupDtoToPermissionGroup(PermissionGroupDto permissionGroupDto) {
        if ( permissionGroupDto == null ) {
            return null;
        }

        PermissionGroup permissionGroup = new PermissionGroup();

        permissionGroup.setGroupName( permissionGroupDto.getGroupName() );
        permissionGroup.setPermissionList( permissionDtoListToPermissionList( permissionGroupDto.getPermissionList() ) );

        return permissionGroup;
    }

    @Override
    public PermissionGroupDto mapPermissionGroupToPermissionGroupDto(PermissionGroup permissionGroup) {
        if ( permissionGroup == null ) {
            return null;
        }

        PermissionGroupDto permissionGroupDto = new PermissionGroupDto();

        permissionGroupDto.setGroupName( permissionGroup.getGroupName() );
        permissionGroupDto.setPermissionList( permissionListToPermissionDtoList( permissionGroup.getPermissionList() ) );

        return permissionGroupDto;
    }

    @Override
    public List<PermissionGroup> mapPermissionGroupDtoListToPermissionGroupList(List<PermissionGroupDto> permissionGroupDtoList) {
        if ( permissionGroupDtoList == null ) {
            return null;
        }

        List<PermissionGroup> list = new ArrayList<PermissionGroup>( permissionGroupDtoList.size() );
        for ( PermissionGroupDto permissionGroupDto : permissionGroupDtoList ) {
            list.add( mapPermissionGroupDtoToPermissionGroup( permissionGroupDto ) );
        }

        return list;
    }

    @Override
    public List<PermissionGroupDto> mapPermissionGroupListToPermissionGroupDtoList(List<PermissionGroup> permissionGroupList) {
        if ( permissionGroupList == null ) {
            return null;
        }

        List<PermissionGroupDto> list = new ArrayList<PermissionGroupDto>( permissionGroupList.size() );
        for ( PermissionGroup permissionGroup : permissionGroupList ) {
            list.add( mapPermissionGroupToPermissionGroupDto( permissionGroup ) );
        }

        return list;
    }

    protected Permission permissionDtoToPermission(PermissionDto permissionDto) {
        if ( permissionDto == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setUserEmail( permissionDto.getUserEmail() );
        permission.setPermissionLevel( permissionDto.getPermissionLevel() );

        return permission;
    }

    protected List<Permission> permissionDtoListToPermissionList(List<PermissionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Permission> list1 = new ArrayList<Permission>( list.size() );
        for ( PermissionDto permissionDto : list ) {
            list1.add( permissionDtoToPermission( permissionDto ) );
        }

        return list1;
    }

    protected PermissionDto permissionToPermissionDto(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionDto permissionDto = new PermissionDto();

        permissionDto.setUserEmail( permission.getUserEmail() );
        permissionDto.setPermissionLevel( permission.getPermissionLevel() );

        return permissionDto;
    }

    protected List<PermissionDto> permissionListToPermissionDtoList(List<Permission> list) {
        if ( list == null ) {
            return null;
        }

        List<PermissionDto> list1 = new ArrayList<PermissionDto>( list.size() );
        for ( Permission permission : list ) {
            list1.add( permissionToPermissionDto( permission ) );
        }

        return list1;
    }
}
