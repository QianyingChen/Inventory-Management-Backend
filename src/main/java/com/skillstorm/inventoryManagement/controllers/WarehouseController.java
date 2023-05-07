package com.skillstorm.inventoryManagement.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.inventoryManagement.dtos.WarehouseDto;
import com.skillstorm.inventoryManagement.services.WarehouseService;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;
	
    @GetMapping
	public List<WarehouseDto> findAllWarehouse(String name) {
		return warehouseService.findAllWarehouse(name);
	}
	
	@GetMapping("/{id}")
	public WarehouseDto findWarehouseById(@PathVariable long id) {
		return warehouseService.findWarehouseById(id);
	}
		
	@PostMapping
	public ResponseEntity<WarehouseDto> createWarehouse(@Valid @RequestBody WarehouseDto warehouseData) {
		WarehouseDto warehouse = warehouseService.createWarehouse(warehouseData);
		return new ResponseEntity<>(warehouse, HttpStatus.CREATED);
	}

}
