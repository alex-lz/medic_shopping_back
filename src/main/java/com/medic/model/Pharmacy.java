package com.medic.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pharmacy")
public class Pharmacy {
	
	private long pharmacyID;
	private String name;
	private String pharmacyURLPicture;
	private int group;
	private String address;
	private String contactPharmacist;
	private double lat;
	private double lon;
	
	public Pharmacy() {
		
	}
	
	public Pharmacy(long pharmacyID, String name, String pharmacyURLPicture, int group, String address, String contactPharmacist, double lat, double lon) {
		super();
		this.pharmacyID = pharmacyID;
		this.name = name;
		this.pharmacyURLPicture = pharmacyURLPicture;
		this.group = group;
		this.address = address;
		this.contactPharmacist = contactPharmacist;
		this.lat = lat;
		this.lon = lon;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getPharmacyID() {
		return pharmacyID;
	}
	public void setPharmacyID(long pharmacyID) {
		this.pharmacyID = pharmacyID;
	}
	
	@Column(name = "pharmacy_name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "pharmacy_url_picture", nullable = false)
	public String getPharmacyURLPicture() {
		return pharmacyURLPicture;
	}
	public void setPharmacyURLPicture(String pharmacyURLPicture) {
		this.pharmacyURLPicture = pharmacyURLPicture;
	}
	
	@Column(name = "pharmacy_group", nullable = false)
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	
	@Column(name = "pharmacy_address", nullable = false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "contact_pharmacist", nullable = false)
	public String getContactPharmacist() {
		return contactPharmacist;
	}
	public void setContactPharmacist(String contactPharmacist) {
		this.contactPharmacist = contactPharmacist;
	}
	
	@Column(name = "lat", nullable = false)
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	@Column(name = "lon", nullable = false)
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}

}
