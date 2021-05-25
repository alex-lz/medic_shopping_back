package com.medic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	private long productID;
	private int categoryID;
	private String productName;
	private String productPower;
	private String activeSubstance;
	private String brand;
	private String productDescription;
	private double unitPrice;
	private String productURLPicture;
	private int sells;
	private boolean productStatus;
	
	public Product() {
		
	}
	
	public Product(long productID, int categoryID, String productName, String productPower, String activeSubstance, String brand,
			String productDescription, double unitPrice, String productURLPicture, int sells, boolean productStatus) {
	
		this.productID = productID;
		this.categoryID = categoryID;
		this.productName = productName;
		this.productPower = productPower;
		this.activeSubstance = activeSubstance;
		this.brand = brand;
		this.productDescription = productDescription;
		this.unitPrice = unitPrice;
		this.productURLPicture = productURLPicture;
		this.sells = sells;
		this.productStatus = productStatus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	@Column(name = "categoryID", nullable = false)
	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	@Column(name = "product_name", nullable = false)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name = "product_power", nullable = false)
	public String getProductPower() {
		return productPower;
	}

	public void setProductPower(String productPower) {
		this.productPower = productPower;
	}

	@Column(name = "active_substance", nullable = false)
	public String getActiveSubstance() {
		return activeSubstance;
	}

	public void setActiveSubstance(String activeSubstance) {
		this.activeSubstance = activeSubstance;
	}

	@Column(name = "brand", nullable = false)
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "product_description", nullable = false)
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Column(name = "unit_price", nullable = false)
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "product_url_picture", nullable = false)
	public String getProductURLPicture() {
		return productURLPicture;
	}

	public void setProductURLPicture(String productURLPicture) {
		this.productURLPicture = productURLPicture;
	}
	
	@Column(name = "sells", nullable = false)
	public int getSells() {
		return sells;
	}

	public void setSells(int sells) {
		this.sells = sells;
	}


	@Column(name = "product_status", nullable = false)
	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}


}
