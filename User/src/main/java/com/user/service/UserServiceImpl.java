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
//@Scope("prototype")
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
		System.out.println("dto in service:- "+ userdto);
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
		User userupdate = user.get();
		userupdate.setMobileNumber(userdto.getMobileNumber());
		userRepository.save(userupdate);
		return userupdate.getUserId();
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
