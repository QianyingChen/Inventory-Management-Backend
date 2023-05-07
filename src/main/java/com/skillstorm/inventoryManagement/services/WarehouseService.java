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
		
		return warehouseRepository.findAll()
				.stream()
				.map(w -> w.toDto())
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
	
}