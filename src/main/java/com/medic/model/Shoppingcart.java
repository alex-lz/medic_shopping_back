package com.medic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "shoppingcart")
public class Shoppingcart  implements Serializable {
	
	@EmbeddedId
	private ShoppingcartID shoppingcartID;
	
	private int quantity;
	private boolean shoppingcartStatus;
	
	public Shoppingcart() {
		
	}
	
	public Shoppingcart(ShoppingcartID shoppingcartID, int quantity, boolean shoppingcartStatus) {
		super();
		this.shoppingcartID = shoppingcartID;
		this.quantity = quantity;
		this.shoppingcartStatus = shoppingcartStatus;
	}

	public ShoppingcartID getShoppingcartID() {
		return shoppingcartID;
	}

	public void setShoppingcartID(ShoppingcartID shoppingcartID) {
		this.shoppingcartID = shoppingcartID;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "shoppingcart_status", nullable = false)
	public boolean isShoppingcartStatus() {
		return shoppingcartStatus;
	}

	public void setShoppingcartStatus(boolean shoppingcartStatus) {
		this.shoppingcartStatus = shoppingcartStatus;
	}
	


}
