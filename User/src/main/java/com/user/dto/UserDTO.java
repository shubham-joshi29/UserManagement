package com.user.dto;

import java.time.LocalDate;

import com.user.entity.User;

public class UserDTO {
	private Integer userId;
	private String userName;
	private Character gender;
	private Long mobileNumber;
	private LocalDate dob;
	private String address;
	
	public UserDTO(Integer userId, String userName, Character gender, Long mobileNumber, LocalDate dob,
			String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.dob = dob;
		this.address = address;
	}

	public UserDTO() {
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
	
	public static UserDTO entityToDto(User user) {
		
		UserDTO userdto = new UserDTO();
		
		userdto.setUserId(user.getUserId());
		userdto.setUserName(user.getUserName());
		userdto.setGender(user.getGender());
		userdto.setMobileNumber(user.getMobileNumber());
		userdto.setDob(user.getDob());
		userdto.setAddress(user.getAddress());
		
		return userdto;
	}
	
	public static User dtoToEntity(UserDTO userdto) {
		
		User user = new User();
		user.setUserId(userdto.getUserId());
		user.setUserName(userdto.getUserName());
		user.setGender(userdto.getGender());
		user.setMobileNumber(userdto.getMobileNumber());
		user.setDob(userdto.getDob());
		user.setAddress(userdto.getAddress());
		
		return user;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", mobileNumber="
				+ mobileNumber + ", dob=" + dob + ", address=" + address + "]";
	}
	
	
	
	
	
	

}
