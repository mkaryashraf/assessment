package com.stc.assessment.restapi.file;

import com.stc.assessment.domain.File;
import com.stc.assessment.domain.Item;
import com.stc.assessment.restapi.item.ItemDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-01T01:08:26+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class FileMapperImpl extends FileMapper {

    @Override
    public File mapFileDtoToFile(FileDto fileDto) {
        if ( fileDto == null ) {
            return null;
        }

        File file = new File();

        file.setItem( itemDtoToItem( fileDto.getItemDto() ) );
        byte[] data = fileDto.getData();
        if ( data != null ) {
            file.setData( Arrays.copyOf( data, data.length ) );
        }
        file.setType( fileDto.getType() );

        return file;
    }

    @Override
    public FileDto mapFileToFileDto(File file) {
        if ( file == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        fileDto.setItemDto( itemToItemDto( file.getItem() ) );
        byte[] data = file.getData();
        if ( data != null ) {
            fileDto.setData( Arrays.copyOf( data, data.length ) );
        }
        fileDto.setType( file.getType() );

        return fileDto;
    }

    @Override
    public List<File> mapFileDtoListToFileList(List<FileDto> fileDtoList) {
        if ( fileDtoList == null ) {
            return null;
        }

        List<File> list = new ArrayList<File>( fileDtoList.size() );
        for ( FileDto fileDto : fileDtoList ) {
            list.add( mapFileDtoToFile( fileDto ) );
        }

        return list;
    }

    @Override
    public List<FileDto> mapFileListToFileDtoList(List<File> fileList) {
        if ( fileList == null ) {
            return null;
        }

        List<FileDto> list = new ArrayList<FileDto>( fileList.size() );
        for ( File file : fileList ) {
            list.add( mapFileToFileDto( file ) );
        }

        return list;
    }

    protected Item itemDtoToItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setName( itemDto.getName() );
        item.setType( itemDto.getType() );

        return item;
    }

    protected ItemDto itemToItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setName( item.getName() );
        itemDto.setType( item.getType() );

        return itemDto;
    }
}
