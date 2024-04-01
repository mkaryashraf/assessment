package com.stc.assessment.restapi.permissiongroup;

import com.stc.assessment.domain.Permission;
import com.stc.assessment.domain.PermissionGroup;
import com.stc.assessment.restapi.permission.PermissionDto;
import com.stc.assessment.restapi.permission.PermissionMapper;
import com.stc.assessment.service.ResponseMessage;
import com.stc.assessment.service.permissiongroup.PermissionGroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/permissionGroups/")
public class PermissionGroupRestApi {
    @Autowired
    private PermissionGroupService permissionGroupService;

    @Autowired
    private PermissionGroupMapper permissionGroupMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @PostMapping("/create")
    public ResponseEntity<PermissionGroupDto> createPermissionGroup(@RequestBody @Valid PermissionGroupDto permissionGroupDto){
        PermissionGroupDto permissionGroupDtoResponse = permissionGroupMapper.mapPermissionGroupToPermissionGroupDto(permissionGroupService.createPermissionGroup(permissionGroupDto));
        return ResponseEntity.ok(permissionGroupDtoResponse);
    }

    @GetMapping("/permissionGroup")
    public ResponseEntity<PermissionGroupDto> getPermissionGroupByName(@RequestParam String groupName){
        PermissionGroupDto permissionGroupDtoResponse = permissionGroupMapper.mapPermissionGroupToPermissionGroupDto(permissionGroupService.getPermissionGroupByName(groupName));
        return ResponseEntity.ok(permissionGroupDtoResponse);
    }

    @GetMapping("/permissionGroup/permissions")
    public ResponseEntity<List<PermissionDto>> getAllPermissionByPermissionGroupGroupName(@RequestParam String groupName){
        List<PermissionDto>permissionDtoList = permissionMapper.mapPermissionListToPermissionDtoList(permissionGroupService.getAllPermissionByPermissionGroupGroupName(groupName));
        return ResponseEntity.ok(permissionDtoList);
    }


}
