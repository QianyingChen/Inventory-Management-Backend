package com.skillstorm.inventoryManagement.dtos;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class WarehouseDto {
	private Long id;
	
	@NotBlank
    private String name;
	
	@NotBlank
    private String address;
	
	@NotBlank
    private String contactPerson;
	
	@NotBlank
//	@Pattern(regexp="^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$")
    private String phoneNumber;
	
	@NotNull
    @Min(value = 1, message = "Warehouse Max capacity must be at least 1")
    @Max(value = 5000, message = "Warehouse Max capacity cannot exceed 100")
//	@Positive(message = "Capacity must be a positive number")
    private int maxCapacity;

	public WarehouseDto() {
		super();
	}

	public WarehouseDto(Long id, String name, String address, String contactPerson, String phoneNumber, int maxCapacity) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contactPerson = contactPerson;
		this.phoneNumber = phoneNumber;
		this.maxCapacity = maxCapacity;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, contactPerson, id, maxCapacity, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WarehouseDto other = (WarehouseDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(contactPerson, other.contactPerson)
				&& Objects.equals(id, other.id) && maxCapacity == other.maxCapacity && Objects.equals(name, other.name)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "WarehouseDto [id=" + id + ", name=" + name + ", address=" + address + ", contactPerson=" + contactPerson
				+ ", phoneNumber=" + phoneNumber + ", maxCapacity=" + maxCapacity + "]";
	}

	
	
	
	
}
