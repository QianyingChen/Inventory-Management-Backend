package com.skillstorm.inventoryManagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.skillstorm.inventoryManagement.dtos.ItemDto;
import com.skillstorm.inventoryManagement.models.Item;
import com.skillstorm.inventoryManagement.models.Warehouse;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	@Query("select i from Item i where i.warehouse.id = ?1")
	public List<Item> findAllItemsByWarehouseId(long id);
	
	@Query("SELECT i FROM Item i WHERE i.id = :itemId AND i.warehouse.id = :warehouseId")
    Optional<Item> findByIdAndWarehouseId(@Param("itemId") long itemId, @Param("warehouseId") long warehouseId);
	 
	 @Modifying
	 @Query("DELETE FROM Item i WHERE i.id = :itemId AND i.warehouse.id = :warehouseId")
	 void deleteByIdAndWarehouseId(@Param("itemId") long itemId, @Param("warehouseId") long warehouseId);
}
