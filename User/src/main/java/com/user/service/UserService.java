package com.user.service;

import java.util.List;

import com.user.dto.UserDTO;

public interface UserService {
	List<UserDTO> getAllUsers();
	UserDTO getUserById(Integer userId);
	Integer addUser(UserDTO userdto);
	Integer updateUser(Integer userId,UserDTO userdto);
	Integer removeUser(Integer userId);

}
