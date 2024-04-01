package com.stc.assessment.restapi.file;

import com.stc.assessment.dataaccess.ItemRepository;
import com.stc.assessment.domain.File;
import com.stc.assessment.domain.Item;
import com.stc.assessment.restapi.item.ItemDto;
import com.stc.assessment.restapi.permissiongroup.PermissionGroupMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FileMapper {

    @Autowired
    protected ItemRepository itemRepository;



    @Mapping(target = "item" , source = "itemDto")
    public abstract File mapFileDtoToFile(FileDto fileDto);

    @Mapping(target = "itemDto", source = "item")
    public abstract FileDto mapFileToFileDto(File file);


    public abstract List<File> mapFileDtoListToFileList(List<FileDto> fileDtoList);

    public abstract List<FileDto> mapFileListToFileDtoList(List<File> fileList);
}
