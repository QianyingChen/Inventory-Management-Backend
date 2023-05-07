package com.skillstorm.inventoryManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.inventoryManagement.models.Warehouse;
import com.skillstorm.inventoryManagement.dtos.WarehouseDto;
import com.skillstorm.inventoryManagement.repositories.WarehouseRepository;

@Service
public class WarehouseService {
	
	@Autowired
	private WarehouseRepository warehouseRepository; 
	
	public List<WarehouseDto> findAllWarehouse(String name){
		if (name == null) {
			return warehouseRepository.findAll()
					.stream()
					.map(s -> s.toDto()) // Perform some action that mutates each item in a list, use map
					.toList(); // Condense into a list
		}
		// SELECT * FROM STORES WHERE name = ?;
		return warehouseRepository.findByName(name)
				.stream()
				.map(s -> s.toDto())
				.toList();
	}

	
	public WarehouseDto findWarehouseById(long id) {
		return warehouseRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	public WarehouseDto createWarehouse(WarehouseDto warehouseData) {
		Warehouse warehouse = new Warehouse(warehouseData.getId(), warehouseData.getName(), warehouseData.getAddress(),warehouseData.getContactPerson(), warehouseData.getPhoneNumber());
		return warehouseRepository.save(warehouse).toDto();
	}

	public WarehouseDto updateWarehouse(WarehouseDto warehouseData) {
		Warehouse warehouse = new Warehouse(warehouseData.getId(), warehouseData.getName(), warehouseData.getAddress(),warehouseData.getContactPerson(), warehouseData.getPhoneNumber());
		return warehouseRepository.save(warehouse).toDto();
	}

	public void deleteWarehouse(long id) {
		warehouseRepository.deleteById(id);
		
	}
	
}