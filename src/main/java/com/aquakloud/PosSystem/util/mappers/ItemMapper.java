package com.aquakloud.PosSystem.util.mappers;

import com.aquakloud.PosSystem.dto.ItemDTO;
import com.aquakloud.PosSystem.dto.request.ItemSaveRequestDTO;
import com.aquakloud.PosSystem.dto.request.ItemUpdateDTO;
import com.aquakloud.PosSystem.dto.response.ItemGetResponseDTO;
import com.aquakloud.PosSystem.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item DtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);

    Item updateDtoToEntity(ItemUpdateDTO itemUpdateDTO);

    ItemDTO entityToDto(Item item);

    List<ItemDTO> listToDtoList(List<Item> itemList);

    List<ItemGetResponseDTO> entityListToDtoList(List<Item> itemList);
}
