package com.stc.assessment.restapi.permission;

import com.stc.assessment.domain.Permission;
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
public class PermissionMapperImpl extends PermissionMapper {

    @Override
    public Permission mapPermissionDtoToPermission(PermissionDto permissionDto) {
        if ( permissionDto == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setUserEmail( permissionDto.getUserEmail() );
        permission.setPermissionLevel( permissionDto.getPermissionLevel() );

        permission.setPermissionGroup( permissionGroupMapper.mapPermissionGroupDtoToPermissionGroup(permissionDto.getPermissionGroupDto()) );

        return permission;
    }

    @Override
    public PermissionDto mapPermissionToPermissionDto(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionDto permissionDto = new PermissionDto();

        permissionDto.setUserEmail( permission.getUserEmail() );
        permissionDto.setPermissionLevel( permission.getPermissionLevel() );

        permissionDto.setPermissionGroupDto( permissionGroupMapper.mapPermissionGroupToPermissionGroupDto(permission.getPermissionGroup()) );

        return permissionDto;
    }

    @Override
    public List<Permission> mapPermissionDtoListToPermissionList(List<PermissionDto> permissionDtoList) {
        if ( permissionDtoList == null ) {
            return null;
        }

        List<Permission> list = new ArrayList<Permission>( permissionDtoList.size() );
        for ( PermissionDto permissionDto : permissionDtoList ) {
            list.add( mapPermissionDtoToPermission( permissionDto ) );
        }

        return list;
    }

    @Override
    public List<PermissionDto> mapPermissionListToPermissionDtoList(List<Permission> permissionList) {
        if ( permissionList == null ) {
            return null;
        }

        List<PermissionDto> list = new ArrayList<PermissionDto>( permissionList.size() );
        for ( Permission permission : permissionList ) {
            list.add( mapPermissionToPermissionDto( permission ) );
        }

        return list;
    }
}
