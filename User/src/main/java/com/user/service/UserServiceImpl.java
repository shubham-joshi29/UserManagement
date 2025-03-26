package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userdtos = new ArrayList<>();
		
		for(User user : users) {
			UserDTO us = UserDTO.entityToDto(user);
			userdtos.add(us);
		}
		return userdtos;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.equals(null)) {
			return null;
		}
		UserDTO user1 = UserDTO.entityToDto(user.get());
		return user1;
	}

	@Override
	public Integer addUser(UserDTO userdto) {
		Optional<User> i = userRepository.findById(userdto.getUserId());
		if(i.isPresent()) {
			return null;
		}
		User user = UserDTO.dtoToEntity(userdto);
		User newuser = userRepository.save(user);
		return newuser.getUserId();
	}

	@Override
	public Integer updateUser(Integer userId, UserDTO userdto) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()) {
			return null;
		}
		User updatedUser = user.get();
		System.out.println("usee############ "+ updatedUser+ "$$$$$$$$$ "+ userdto.getUserId() );
		
		if(!userdto.getUserId().equals(updatedUser.getUserId())) {
			return 400;
		}else {
			if(userdto.getUserName()!= null) {
				updatedUser.setUserName(userdto.getUserName());
			}
			if(userdto.getGender()!= null) {
				updatedUser.setGender(userdto.getGender());
			}
			if(userdto.getDob()!= null) {
				updatedUser.setDob(userdto.getDob());
			}
			if(userdto.getMobileNumber()!= null) {
				updatedUser.setMobileNumber(userdto.getMobileNumber());
			}
			if(userdto.getAddress()!= null) {
				updatedUser.setAddress(userdto.getAddress());
			}
			
			
		}
		userRepository.save(updatedUser);
		return updatedUser.getUserId();
		
	}

	@Override
	public Integer removeUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()) {
			return null;
		}
		userRepository.deleteById(userId);
		return userId;
	}

	
}
