package com.aquakloud.PosSystem.service.serviceIMPL;

import com.aquakloud.PosSystem.dto.ItemDTO;
import com.aquakloud.PosSystem.dto.request.ItemSaveRequestDTO;
import com.aquakloud.PosSystem.dto.request.ItemUpdateDTO;
import com.aquakloud.PosSystem.dto.response.ItemGetResponseDTO;
import com.aquakloud.PosSystem.entity.Item;
import com.aquakloud.PosSystem.repo.ItemRepo;
import com.aquakloud.PosSystem.service.ItemService;
import com.aquakloud.PosSystem.util.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {

        Item item = itemMapper.DtoToEntity(itemSaveRequestDTO);
        itemRepo.save(item);
        return item.getItemName()+" Saved Item";
    }

    @Override
    public String updateItem(ItemUpdateDTO itemUpdateDTO) {
        if(itemRepo.existsById(itemUpdateDTO.getItemId())) {
            Item item = itemMapper.updateDtoToEntity(itemUpdateDTO);
            itemRepo.save(item);
            return itemUpdateDTO.getItemName() + " Update Item";
        }else{
            throw new RuntimeException("No Data Found for that id");
        }
    }

    @Override
    public ItemDTO getItemById(int itemId) {
        if(itemRepo.existsById(itemId)){
            Item item = itemRepo.getReferenceById(itemId);
            ItemDTO itemDTO = itemMapper.entityToDto(item);
            return itemDTO;
        }else{
            throw new RuntimeException("No Item");
        }

    }

    @Override
    public String deleteItem(int itemId) {
        if(itemRepo.existsById(itemId)){
           itemRepo.deleteById(itemId);
            return itemId + " Deleted Item";
        }else{
            throw new RuntimeException("No Customer for Deleted");
        }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        List<Item> itemList = itemRepo.findAll();
        List<ItemDTO> itemDTOList = itemMapper.listToDtoList(itemList);
        return itemDTOList;
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String name) {
        boolean b = true;
        List<Item> itemList = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(name, b);
        if(itemList.size() > 0){
            List<ItemGetResponseDTO> itemGetResponseDTOList = itemMapper.entityListToDtoList(itemList);
            return itemGetResponseDTOList;
        }else{
            throw new RuntimeException("No Item to show");
        }
    }
}
