package com.aquakloud.PosSystem.controller;

import com.aquakloud.PosSystem.dto.ItemDTO;
import com.aquakloud.PosSystem.dto.request.ItemSaveRequestDTO;
import com.aquakloud.PosSystem.dto.request.ItemUpdateDTO;
import com.aquakloud.PosSystem.dto.response.ItemGetResponseDTO;
import com.aquakloud.PosSystem.service.ItemService;
import com.aquakloud.PosSystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping( path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
       String message = itemService.saveItem(itemSaveRequestDTO);
       return new ResponseEntity<StandardResponse>(
               new StandardResponse(201,"Item Saved Successfull",itemSaveRequestDTO),
               HttpStatus.OK
       );
    }

    @PutMapping(path = "/update-item")
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
        String message = itemService.updateItem(itemUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201," Update Success",itemUpdateDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> getItemById(@RequestParam(value = "id") int itemId){
        ItemDTO itemDTO = itemService.getItemById(itemId);
        return new ResponseEntity<StandardResponse>(
            new StandardResponse(200,"Success",itemDTO),
            HttpStatus.CREATED
        );
    }

    @DeleteMapping(
            path = "/delete-customer/{id}"
    )
    public String deleteItem(@PathVariable(value = "id") int itemId){
        String deleted = itemService.deleteItem(itemId);
        return deleted;
    }

    @GetMapping(
            path = "get-all-item"
    )
    public ResponseEntity<StandardResponse> getAllItem(){
        List<ItemDTO> itemDTOList = itemService.getAllItem();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",itemDTOList),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name") String name){
        List<ItemGetResponseDTO> itemGetResponseDTOList = itemService.getItemByNameAndStatusByMapstruct(name);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204,"Success",itemGetResponseDTOList),
                HttpStatus.CREATED
        );
    }
}
