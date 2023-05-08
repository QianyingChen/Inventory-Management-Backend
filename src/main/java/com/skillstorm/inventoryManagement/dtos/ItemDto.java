package com.skillstorm.inventoryManagement.dtos;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ItemDto {
    private Long id;

    @NotBlank(message = "Name is required")
//    @Size(max = 255, message = "Name must be less than or equal to 255 characters")
    private String name;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be a positive number")
    private Integer quantity;
    
    @NotNull
    @Min(value = 1, message = "Max capacity must be at least 1")
    @Max(value = 100, message = "Max capacity cannot exceed 100")
    private int maxCapacity;
    
    @NotNull
    private Long warehouseId;
    
    public ItemDto() {
		
	}

	public ItemDto(Long id, String name, Integer quantity, int maxCapacity, Long warehouseId) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.maxCapacity = maxCapacity;
		this.warehouseId = warehouseId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, maxCapacity, name, quantity, warehouseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDto other = (ItemDto) obj;
		return Objects.equals(id, other.id) && maxCapacity == other.maxCapacity && Objects.equals(name, other.name)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(warehouseId, other.warehouseId);
	}

	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", name=" + name + ", quantity=" + quantity + ", maxCapacity=" + maxCapacity
				+ ", warehouseId=" + warehouseId + "]";
	}

	
	
    
}
