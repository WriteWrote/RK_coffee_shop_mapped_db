package model.dto;

import java.util.Map;
import java.util.UUID;

public class OrderDto {
	private final UUID uuid;
	private final UUID customerID;
	private final String phone;
	private final String fio;
	private final String address;
	private final String status;
	
	private Map<UUID, Integer> products;
	
	public OrderDto(UUID uuid, UUID customerID, String phone, String fio, String address, String status) {
		this.uuid = uuid;
		this.customerID = customerID;
		this.phone = phone;
		this.fio = fio;
		this.address = address;
		this.status = status;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	
	public UUID getCustomerID() {
		return customerID;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getFio() {
		return fio;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getStatus() {
		return status;
	}
	
	public Map<UUID, Integer> getProducts() {
		return products;
	}
	
	public void setProducts(Map<UUID, Integer> products) {
		this.products = products;
	}
}
