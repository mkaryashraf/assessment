package com.stc.assessment.restapi.file;

import com.stc.assessment.restapi.item.ItemDto;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


public class FileDto implements Serializable {

    private byte[] data;

    @NotNull
    private ItemDto itemDto;

    @NotNull
    private String type;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public ItemDto getItemDto() {
        return itemDto;
    }

    public void setItemDto(ItemDto itemDto) {
        this.itemDto = itemDto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
