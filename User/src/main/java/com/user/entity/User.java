package com.user.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="user_Id")
	private Integer userId;
	
	@Column(name="user_name")
	private String userName;
	
	private Character gender;
	
	@Column(name="mobile_number")
	private Long mobileNumber;
	
	private LocalDate dob;
	private String address;
	
	public User(Integer userId, String userName, Character gender, Long mobileNumber, LocalDate dob, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dob = dob;
		this.address = address;
	}
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", mobileNumber="
				+ mobileNumber + ", dob=" + dob + ", address=" + address + "]";
	}
	
	
	
	
	

}
