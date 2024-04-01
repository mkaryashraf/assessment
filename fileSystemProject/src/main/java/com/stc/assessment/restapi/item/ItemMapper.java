package com.stc.assessment.restapi.item;

import com.stc.assessment.dataaccess.ItemRepository;
import com.stc.assessment.domain.Item;
import com.stc.assessment.domain.PermissionGroup;
import com.stc.assessment.restapi.permissiongroup.PermissionGroupMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ItemMapper {

    @Autowired
    protected ItemRepository itemRepository;

    @Autowired
    protected PermissionGroupMapper permissionGroupMapper;

    @Mapping(target= "children", ignore = true )
    @Mapping(target= "permissionGroup" , expression ="java(permissionGroupMapper.mapPermissionGroupDtoToPermissionGroup(itemDto.getPermissionGroupDto()))" )
    public abstract Item mapItemDtoToItem(ItemDto itemDto);

    @Mapping(target= "childrenDtoList", ignore = true )
    @Mapping(target= "permissionGroupDto" , expression ="java(permissionGroupMapper.mapPermissionGroupToPermissionGroupDto(item.getPermissionGroup()))" )
    public abstract ItemDto mapItemToItemDto(Item item);


    public abstract List<Item> mapItemDtoListToItemList(List<ItemDto> itemDtoList);

    public abstract List<ItemDto> mapItemListToItemDtoList(List<Item> itemList);


}
