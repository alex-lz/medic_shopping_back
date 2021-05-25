package com.medic.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
@Embeddable
public class PharmacyStoreID implements Serializable {
	
	@Column(name = "pharmacyID")
	private Long pharmacyID;
	 
	@Column(name = "productID") 
	private Long productID;
	
	public PharmacyStoreID() {
		
	}
	
	public PharmacyStoreID(Long pharmacyID, Long productID) {
		this.pharmacyID = pharmacyID;
		this.productID = productID;
	}

	public Long getPharmacyID() {
		return pharmacyID;
	}

	public void setPharmacyID(Long pharmacyID) {
		this.pharmacyID = pharmacyID;
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
        PharmacyStoreID that = ( PharmacyStoreID) o;
        return pharmacyID.equals(that.pharmacyID) &&
        		productID.equals(that.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pharmacyID, productID);
    }

}

