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
	private int group;
	private String address;
	private int contact;
	private int Lat;
	private int Lon;
	
	public Pharmacy() {
		
	}
	
	public Pharmacy(long pharmacyID, String name, int group, String address, int contact, int lat, int lon) {
		super();
		this.pharmacyID = pharmacyID;
		this.name = name;
		this.group = group;
		this.address = address;
		this.contact = contact;
		Lat = lat;
		Lon = lon;
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
	
	@Column(name = "contact", nullable = false)
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	
	@Column(name = "lat", nullable = false)
	public int getLat() {
		return Lat;
	}
	public void setLat(int lat) {
		Lat = lat;
	}
	
	@Column(name = "log", nullable = false)
	public int getLon() {
		return Lon;
	}
	public void setLon(int lon) {
		Lon = lon;
	}

}
