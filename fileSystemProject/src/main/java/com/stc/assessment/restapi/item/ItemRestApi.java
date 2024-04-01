package com.stc.assessment.restapi.item;

import com.stc.assessment.domain.File;
import com.stc.assessment.domain.Item;
import com.stc.assessment.service.ResponseMessage;
import com.stc.assessment.service.item.ItemProcessingException;
import com.stc.assessment.service.item.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/items")
public class ItemRestApi {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemMapper itemMapper;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> createItem (@RequestBody @Valid ItemDto itemDto, @RequestParam String userEmail){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(
                    "success", itemMapper.mapItemToItemDto(itemService.createItem(itemDto, userEmail))));
        }catch (ItemProcessingException ex){
            return ResponseEntity.badRequest().body(new ResponseMessage(ex.getMessage(),itemDto));
        }
    }

    @PostMapping("/files/upload")
    public ResponseEntity<ResponseMessage> uploadFile (@RequestParam String filePath, @RequestParam String userEmail, @RequestParam MultipartFile multipartFile,  @RequestParam String groupName){

        try {
           File file = itemService.uploadFile(filePath, userEmail, multipartFile,groupName );
        } catch (IOException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage(),null));
        } catch (ItemProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage(),null));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("success", null));
    }

    @GetMapping("/metaData")
    public ResponseEntity<ResponseMessage> viewItemMetaData(@RequestParam String itemPath, @RequestParam String userEmail, @RequestParam String groupName){
        Item item = null;
        try {
            item = itemService.viewItemMetaData(itemPath, userEmail,groupName );
        } catch (ItemProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage(),null));
        }
        ItemDto itemDto = itemMapper.mapItemToItemDto(item);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("success",itemDto));
    }

    @GetMapping("/files/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam String filePath,@RequestParam String userEmail, @RequestParam String groupName){
        File file = null;
        try {
            file = itemService.downloadFile(filePath, userEmail, groupName);
        } catch (ItemProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(file.getData());
    }
}
