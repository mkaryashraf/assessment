package com.stc.assessment.restapi.permission;

import com.stc.assessment.domain.PermissionGroup;
import com.stc.assessment.restapi.permissiongroup.PermissionGroupDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;


public class PermissionDto implements Serializable {
    @NotNull
    @Email
    private String userEmail;

    @NotNull
    private String permissionLevel;


    @NotNull
    private PermissionGroupDto permissionGroupDto;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public PermissionGroupDto getPermissionGroupDto() {
        return permissionGroupDto;
    }

    public void setPermissionGroupDto(PermissionGroupDto permissionGroupDto) {
        this.permissionGroupDto = permissionGroupDto;
    }
}
