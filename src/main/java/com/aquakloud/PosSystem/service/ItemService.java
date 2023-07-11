package com.aquakloud.PosSystem.service;

import com.aquakloud.PosSystem.dto.ItemDTO;
import com.aquakloud.PosSystem.dto.request.ItemSaveRequestDTO;
import com.aquakloud.PosSystem.dto.request.ItemUpdateDTO;
import com.aquakloud.PosSystem.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    String updateItem(ItemUpdateDTO itemUpdateDTO);

    ItemDTO getItemById(int itemId);

    String deleteItem(int itemId);

    List<ItemDTO> getAllItem();

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String name);
}
