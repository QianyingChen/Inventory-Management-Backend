package com.skillstorm.inventoryManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.inventoryManagement.dtos.ItemDto;
import com.skillstorm.inventoryManagement.models.Item;
import com.skillstorm.inventoryManagement.models.Warehouse;
import com.skillstorm.inventoryManagement.repositories.ItemRepository;
import com.skillstorm.inventoryManagement.repositories.WarehouseRepository;

@Service
@Transactional
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository; 
	
	public List<ItemDto> findAllItemsByWarehouseId(long id) {
		return itemRepository.findAllItemsByWarehouseId(id)
				.stream()
				.map(i -> i.toDto())
				.toList();
	}

	public ItemDto createItems(ItemDto itemData) {
		Warehouse warehouse = warehouseRepository.findById(itemData.getWarehouseId())
				.orElseThrow();
		Item item = new Item(itemData.getId(), itemData.getName(), itemData.getQuantity(), itemData.getMaxCapacity(), warehouse);
		return itemRepository.save(item).toDto();
		
	}
	

	public ItemDto findItemByIdAndWarehouseId(long itemId, long warehouseId, ItemDto itemData) {
		Warehouse warehouse = warehouseRepository.findById(warehouseId)
    		.orElseThrow(() -> new IllegalArgumentException("Warehouse with id " + warehouseId + " not found"));
		Item item = itemRepository.findById(itemId)
    		.orElseThrow(() -> new IllegalArgumentException("Item with id " + itemId + " not found"));
		if (!item.getWarehouse().getId().equals(warehouseId)) {
        throw new IllegalArgumentException("Item with id " + itemId + " does not belong to warehouse with id " + warehouseId);
		}
		return new ItemDto(item.getId(), item.getName(), item.getQuantity(), item.getMaxCapacity(), warehouseId);
}
	
	
	public ItemDto updateItem(long warehouseId, ItemDto itemData) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId)
        		.orElseThrow();
        Item item = itemRepository.findById(itemData.getId())
        		.orElseThrow();
        item.setName(itemData.getName());
        item.setQuantity(itemData.getQuantity());
        item.setMaxCapacity(itemData.getMaxCapacity());
        item.setWarehouse(warehouse);
        Item updateItem = itemRepository.save(item);
        return updateItem.toDto();
    }

    public void deleteItemByIdAndWarehouseId(long warehouseId, long itemId) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId)
        		.orElseThrow();
        Item item = itemRepository.findById(itemId)
        		.orElseThrow();
        if (!item.getWarehouse().getId().equals(warehouseId)) {
            throw new IllegalArgumentException("Item with id " + itemId + " does not belong to warehouse with id " + warehouseId);
        }
        itemRepository.delete(item);
    }

	
	
}
