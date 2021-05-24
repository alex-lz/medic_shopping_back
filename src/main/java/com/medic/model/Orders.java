package com.medic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	
	private long orderID;
	private String userEmail;
	private String deliverUser;
	private String shippingAddress;
	private String orderDate;
	private double amount;
	private String orderStatus;
	 
	public Orders() {
		 
	}
	 
	public Orders(long orderID, String userEmail, String deliverUser, String shippingAddress, String orderDate,
				double amount, String orderStatus) {
		this.orderID = orderID;
		this.userEmail = userEmail;
		this.deliverUser = deliverUser;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
		this.amount = amount;
		this.orderStatus = orderStatus;
	}
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	
	@Column(name = "user_email", nullable = false)
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Column(name = "deliver_user", nullable = false)
	public String getDeliverUser() {
		return deliverUser;
	}
	public void setDeliverUser(String deliverUser) {
		this.deliverUser = deliverUser;
	}
	
	@Column(name = "shipping_address", nullable = false)
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	@Column(name = "order_date", nullable = false)
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	@Column(name = "amount", nullable = false)
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Column(name = "order_status", nullable = false)
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
