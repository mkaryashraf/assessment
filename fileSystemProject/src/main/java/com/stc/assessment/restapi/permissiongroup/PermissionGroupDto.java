package com.stc.assessment.restapi.permissiongroup;

import com.stc.assessment.restapi.permission.PermissionDto;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class PermissionGroupDto implements Serializable {
    @NotNull
    private String groupName;

    private List<PermissionDto> permissionList;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<PermissionDto> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionDto> permissionList) {
        this.permissionList = permissionList;
    }
}
