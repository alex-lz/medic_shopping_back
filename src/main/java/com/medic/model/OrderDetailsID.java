package com.medic.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
@Embeddable
public class OrderDetailsID implements Serializable {
	
	@Column(name = "orderID")
	private Long orderID;
	 
	@Column(name = "productID") 
	private Long productID;
	
	public OrderDetailsID() {
		
	}
	
	public OrderDetailsID(Long orderID, Long productID) {
		this.orderID = orderID;
		this.productID = productID;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsID that = ( OrderDetailsID) o;
        return orderID.equals(that.orderID) &&
        		productID.equals(that.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, productID);
    }

}
