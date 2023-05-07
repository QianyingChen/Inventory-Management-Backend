package com.skillstorm.inventoryManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.inventoryManagement.models.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{
//	@Query("SELECT w FROM Warehouse w WHERE w.name = ?1")
	public List<Warehouse> findByName(String name);
}
