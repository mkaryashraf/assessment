package com.stc.assessment.service.item;

import com.stc.assessment.dataaccess.FileRepository;
import com.stc.assessment.dataaccess.ItemRepository;
import com.stc.assessment.dataaccess.PermissionGroupRepository;
import com.stc.assessment.dataaccess.PermissionRepository;
import com.stc.assessment.domain.File;
import com.stc.assessment.domain.Item;
import com.stc.assessment.domain.Permission;
import com.stc.assessment.domain.PermissionGroup;
import com.stc.assessment.restapi.item.ItemDto;
import com.stc.assessment.restapi.item.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    @Override
    public Item createItem(ItemDto itemDto, String userEmail) throws ItemProcessingException {
        String permissionLevel = verifyUserPermission(itemDto.getPermissionGroupDto().getGroupName(), userEmail);
        if(!permissionLevel.equals("edit")){
            throw new ItemProcessingException("user does not have permission to create items");
        }


        if(itemDto.getType().equals("space")){
            if(!(itemDto.getParentFilePath() == null || itemDto.getParentFilePath().isEmpty() )) {
                throw new ItemProcessingException("space cannot be created under another space");
            }
            Item space = itemRepository.findByNameAndType(itemDto.getName(),"space");
            if(space != null) {
                throw new ItemProcessingException("space already exists");
            }
        }

        Item parentItem = searchForItem(itemDto.getParentFilePath(),userEmail);
        if(!itemDto.getType().equals("space")){
            if (parentItem == null) {
                throw new ItemProcessingException("wrong path to create file");
            }
            if (parentItem.getType().equals("file")) {
                throw new ItemProcessingException("file type can not be a parent");
            }
        }

        PermissionGroup permissionGroup = permissionGroupRepository.findByGroupName(itemDto.getPermissionGroupDto().getGroupName());
        Item item = itemMapper.mapItemDtoToItem(itemDto);
        item.setPermissionGroup(permissionGroup);
        item.setParent(parentItem);
        item = itemRepository.save(item);
        return item;
    }



    @Override
    public File uploadFile(String filePath, String userEmail, MultipartFile multipartFile, String groupName) throws IOException, ItemProcessingException {
        String permissionLevel = verifyUserPermission(groupName, userEmail);
        if(!permissionLevel.equals("edit")){
            throw new ItemProcessingException("user does not have permission to upload file");
        }
        Item result =searchForItem(filePath, userEmail);
        File file = null;
        if(result == null) {
            throw new ItemProcessingException("item is not found");
        }
        file = fileRepository.findByItemId(result.getId());
        if(file == null) {
            file = new File();
        }
        file.setItem(result);
        file.setType(multipartFile.getContentType());
        file.setData(multipartFile.getBytes());
        return fileRepository.save(file);
    }

    @Override
    public Item viewItemMetaData(String itemPath, String userEmail, String groupName) throws ItemProcessingException {
        String permissionLevel = verifyUserPermission(groupName, userEmail);
        if(!(permissionLevel.equals("view") || permissionLevel.equals("edit"))){
            throw new ItemProcessingException("user does not have permission to view item metaData");
        }
        Item result = searchForItem(itemPath, userEmail);
        if(result == null) {
            throw new ItemProcessingException("item is not found");
        }
        return result;
    }

    @Override
    public File downloadFile(String filePath, String userEmail, String groupName) throws ItemProcessingException {
        String permissionLevel = verifyUserPermission(groupName, userEmail);

        if(!(permissionLevel.equals("view") || permissionLevel.equals("edit"))){
            throw new ItemProcessingException("user does not have permission to download file");
        }
        Item result = null;
        File file = null;
        result = searchForItem(filePath, userEmail);
        if(result == null) {
            throw new ItemProcessingException("item is not found");
        }

        file = fileRepository.findByItemId(result.getId());

        return file;
    }

    private Item searchForItem(String itemPath, String userEmail) {
        Item result = null;
        String[] hierarchy =  itemPath.split("/");

        Item item = itemRepository.findByName(hierarchy[0]);
        if(hierarchy.length==1){
            return item;
        }
        Permission userPermission = permissionRepository.
                findByUserEmailAndPermissionGroupId(userEmail, item.getPermissionGroup().getId());

        if(userPermission==null){
            return null;
        }

        for(int i=0; i<hierarchy.length-1;i++){
            Optional<Item> temp = itemRepository.findByNameAndParentName(hierarchy[i+1],hierarchy[i]);
            if(temp.isEmpty() ){
                return null;
            }else{
                result = temp.get();
            }
        }
        return result;
    }

    private String verifyUserPermission(String groupName, String userEmail) {
        Permission permission =permissionRepository.findByUserEmailAndPermissionGroupGroupName(
                userEmail, groupName);
        if (permission == null)
            return "unauthorized";
        return permission.getPermissionLevel();
    }
}
