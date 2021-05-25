package com.medic.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "pharmacystore")
public class PharmacyStore implements Serializable {
	
	@EmbeddedId
	private PharmacyStoreID pharmacyStoreID;
	
	private double unitPrice;
	private float discount;
	private boolean pharmacyStatus;
	
	public PharmacyStore(PharmacyStoreID pharmacyStoreID, double unitPrice, float discount, boolean pharmacyStatus) {
		super();
		this.pharmacyStoreID = pharmacyStoreID;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.pharmacyStatus = pharmacyStatus;
	}

	public PharmacyStoreID getPharmacyStoreID() {
		return pharmacyStoreID;
	}
	public void setPharmacyStoreID(PharmacyStoreID pharmacyStoreID) {
		this.pharmacyStoreID = pharmacyStoreID;
	}
	
	@Column(name = "unit_price", nullable = false)
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Column(name = "discount", nullable = false)
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	@Column(name = "pharmacy_status", nullable = false)
	public boolean isPharmacyStatus() {
		return pharmacyStatus;
	}
	public void setPharmacyStatus(boolean pharmacyStatus) {
		this.pharmacyStatus = pharmacyStatus;
	}

}
