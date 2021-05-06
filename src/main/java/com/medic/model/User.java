package com.medic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	private String userEmail;
	private int userAddress;
	private String userPassword;
	private String userFCMToken;
	private String userName;
	private String userLast;
	private long userCellphone;
	private String userURLPicture;
	private String userType;
	private int UserPharmacy;
	
	public User() {
		
	}
	
	public User(String userEmail, int userAddress, String userPassword, String userFCMToken, String userName,
			String userLast, long userCellphone, String userURLPicture, String userType, int userPharmacy) {
		
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userPassword = userPassword;
		this.userFCMToken = userFCMToken;
		this.userName = userName;
		this.userLast = userLast;
		this.userCellphone = userCellphone;
		this.userURLPicture = userURLPicture;
		this.userType = userType;
		UserPharmacy = userPharmacy;
	}

	@Id
	@Column(name = "user_email", nullable = false)
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "user_address", nullable = false)
	public int getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(int userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "user_password", nullable = false)
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_fcm_token", nullable = false)
	public String getUserFCMToken() {
		return userFCMToken;
	}

	public void setUserFCMToken(String userFCMToken) {
		this.userFCMToken = userFCMToken;
	}

	@Column(name = "user_name", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_last", nullable = false)
	public String getUserLast() {
		return userLast;
	}

	public void setUserLast(String userLast) {
		this.userLast = userLast;
	}

	@Column(name = "user_cellphone", nullable = false)
	public long getUserCellphone() {
		return userCellphone;
	}

	public void setUserCellphone(long userCellphone) {
		this.userCellphone = userCellphone;
	}

	@Column(name = "user_url_picture", nullable = false)
	public String getUserURLPicture() {
		return userURLPicture;
	}

	public void setUserURLPicture(String userURLPicture) {
		this.userURLPicture = userURLPicture;
	}

	@Column(name = "user_type", nullable = false)
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "User_pharmacy", nullable = false)
	public int getUserPharmacy() {
		return UserPharmacy;
	}

	public void setUserPharmacy(int userPharmacy) {
		UserPharmacy = userPharmacy;
	}

}
