package com.medic.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
@Embeddable
public class ShoppingcartID implements Serializable{
	
	@Column(name = "user_email")
	private String userEmail;
	 
	@Column(name = "productID") 
	private Long productID;
	
	public ShoppingcartID() {
		
	}
	
	public ShoppingcartID(String userEmail, long productID) {
		this.userEmail = userEmail;
		this.productID = productID;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingcartID that = (ShoppingcartID) o;
        return userEmail.equals(that.userEmail) &&
        		productID.equals(that.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, productID);
    }


}
