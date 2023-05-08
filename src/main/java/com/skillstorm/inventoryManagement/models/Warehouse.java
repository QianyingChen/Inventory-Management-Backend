package com.skillstorm.inventoryManagement.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.skillstorm.inventoryManagement.dtos.WarehouseDto;

@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "max_capacity")
    private int maxCapacity;
    
    public Warehouse() {
		
	}

	
	public Warehouse(Long id, String name, String address, String contactPerson, String phoneNumber, int maxCapacity) {
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


	public WarehouseDto toDto() {
		return new WarehouseDto (id, name, address, contactPerson, phoneNumber, maxCapacity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", name=" + name + ", address=" + address + ", contactPerson=" + contactPerson
				+ ", phoneNumber=" + phoneNumber + ", maxCapacity=" + maxCapacity + "]";
	}
    
    
    
}
