package com.stc.assessment.service.item;

import com.stc.assessment.domain.File;
import com.stc.assessment.domain.Item;
import com.stc.assessment.restapi.item.ItemDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ItemService {

    public Item createItem (ItemDto itemDto, String userEmail) throws ItemProcessingException;

    public File uploadFile (String filePath, String userEmail, MultipartFile multipartFile, String groupName) throws IOException, ItemProcessingException;

    public Item viewItemMetaData(String itemPath, String userEmail, String groupName) throws ItemProcessingException;

    public File downloadFile(String filePath, String userEmail, String groupName) throws ItemProcessingException;
}
