package com.medic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "orderdetails")
public class OrderDetails implements Serializable {
	
	@EmbeddedId
	private OrderDetailsID orderDetailsID;
	
	private int quantity;
	private int pharmacyID;
	private boolean orderStatus;
	
	public OrderDetails() {
		
	}	
	
	public OrderDetails(OrderDetailsID orderDetailsID, int quantity, int pharmacyID, boolean orderStatus) {
		super();
		this.orderDetailsID = orderDetailsID;
		this.quantity = quantity;
		this.pharmacyID = pharmacyID;
		this.orderStatus = orderStatus;
	}
	
	public OrderDetailsID getOrderDetailsID() {
		return orderDetailsID;
	}
	public void setOrderDetailsID(OrderDetailsID orderDetailsID) {
		this.orderDetailsID = orderDetailsID;
	}
	
	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "pharmacyid", nullable = false)
	public int getPharmacyID() {
		return pharmacyID;
	}
	public void setPharmacyID(int pharmacyID) {
		this.pharmacyID = pharmacyID;
	}
	
	@Column(name = "order_status", nullable = false)
	public boolean isOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

}
