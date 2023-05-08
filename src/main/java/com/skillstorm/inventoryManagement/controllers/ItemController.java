package com.skillstorm.inventoryManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventoryManagement.dtos.ItemDto;
import com.skillstorm.inventoryManagement.services.ItemService;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    
    @GetMapping("/warehouses/{id}/items")
	public List<ItemDto> findAllClothesByStoreId(@PathVariable long id) {
		return itemService.findAllItemsByWarehouseId(id);
	}
    
    @GetMapping("/warehouses/{warehouseId}/items/{itemId}")
    public ItemDto getItemByIdAndWarehouseId(@PathVariable long warehouseId, @PathVariable long itemId, @RequestBody ItemDto itemData) {
    return itemService.findItemByIdAndWarehouseId(itemId, warehouseId, itemData);
    }

    
    @PostMapping("/warehouses/{id}/items")
    public ItemDto createItemByWarehouseId(@PathVariable long id, @RequestBody ItemDto itemData) {
    	itemData.setWarehouseId(id);
    	return itemService.createItems(itemData);
    }
    
    @PutMapping("/warehouses/{warehouseId}/items/{itemId}")
    public ItemDto updateItemByWarehouseId(@PathVariable long warehouseId, @PathVariable long itemId, @RequestBody ItemDto itemData) {
    itemData.setId(itemId);
    itemData.setWarehouseId(warehouseId);
    return itemService.updateItem(itemId, itemData);
    }


    @DeleteMapping("/warehouses/{warehouseId}/items/{itemId}")
    public void deleteItemByWarehouseId(@PathVariable long warehouseId, @PathVariable long itemId) {
    itemService.deleteItemByIdAndWarehouseId(warehouseId, itemId);
    }
}

