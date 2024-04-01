package com.stc.assessment.restapi.item;

import com.stc.assessment.restapi.permissiongroup.PermissionGroupDto;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

public class ItemDto implements Serializable {

    private String parentFilePath;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private PermissionGroupDto permissionGroupDto;


    private ItemDto parentDto;


    List<ItemDto> childrenDtoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PermissionGroupDto getPermissionGroupDto() {
        return permissionGroupDto;
    }

    public void setPermissionGroupDto(PermissionGroupDto permissionGroupDto) {
        this.permissionGroupDto = permissionGroupDto;
    }

    public ItemDto getParentDto() {
        return parentDto;
    }

    public void setParentDto(ItemDto parentDto) {
        this.parentDto = parentDto;
    }

    public List<ItemDto> getChildrenDtoList() {
        return childrenDtoList;
    }

    public void setChildrenDtoList(List<ItemDto> childrenDtoList) {
        this.childrenDtoList = childrenDtoList;
    }

    public String getParentFilePath() {
        return parentFilePath;
    }

    public void setParentFilePath(String parentFilePath) {
        this.parentFilePath = parentFilePath;
    }
}
