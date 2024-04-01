package com.stc.assessment.restapi.permission;


import com.stc.assessment.service.permission.PermissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionRestApi {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PermissionMapper permissionMapper;

    @GetMapping("/permission")
    public ResponseEntity<PermissionDto> getPermissionByUserEmailAndPermissionGroupGroupName(@RequestParam String userEmail, @RequestParam String groupName){
        PermissionDto permissionDto = permissionMapper.mapPermissionToPermissionDto(
                permissionService.getPermissionByUserEmailAndPermissionGroupGroupName(userEmail, groupName));
        return ResponseEntity.ok(permissionDto);
    }

    @GetMapping("/permission/user")
    public ResponseEntity<List<PermissionDto>> getPermissionByUserEmail(@RequestParam String userEmail){
        List<PermissionDto> permissionDtoList = permissionMapper.mapPermissionListToPermissionDtoList(
                permissionService.getPermissionByUserEmail(userEmail));
        return ResponseEntity.ok(permissionDtoList);
    }

    @PostMapping("/create")
    public ResponseEntity<PermissionDto> createPermission(@RequestBody @Valid PermissionDto permissionDto){
        PermissionDto permissionDtoResponse = permissionMapper.mapPermissionToPermissionDto(
                permissionService.createPermission(permissionDto));
        return ResponseEntity.ok(permissionDtoResponse);
    }
}
