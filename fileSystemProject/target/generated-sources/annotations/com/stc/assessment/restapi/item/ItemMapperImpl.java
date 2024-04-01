package com.stc.assessment.restapi.item;

import com.stc.assessment.domain.Item;
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
public class ItemMapperImpl extends ItemMapper {

    @Override
    public Item mapItemDtoToItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setName( itemDto.getName() );
        item.setType( itemDto.getType() );

        item.setPermissionGroup( permissionGroupMapper.mapPermissionGroupDtoToPermissionGroup(itemDto.getPermissionGroupDto()) );

        return item;
    }

    @Override
    public ItemDto mapItemToItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setName( item.getName() );
        itemDto.setType( item.getType() );

        itemDto.setPermissionGroupDto( permissionGroupMapper.mapPermissionGroupToPermissionGroupDto(item.getPermissionGroup()) );

        return itemDto;
    }

    @Override
    public List<Item> mapItemDtoListToItemList(List<ItemDto> itemDtoList) {
        if ( itemDtoList == null ) {
            return null;
        }

        List<Item> list = new ArrayList<Item>( itemDtoList.size() );
        for ( ItemDto itemDto : itemDtoList ) {
            list.add( mapItemDtoToItem( itemDto ) );
        }

        return list;
    }

    @Override
    public List<ItemDto> mapItemListToItemDtoList(List<Item> itemList) {
        if ( itemList == null ) {
            return null;
        }

        List<ItemDto> list = new ArrayList<ItemDto>( itemList.size() );
        for ( Item item : itemList ) {
            list.add( mapItemToItemDto( item ) );
        }

        return list;
    }
}
