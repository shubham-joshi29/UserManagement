package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserDTO;
import com.user.service.UserService;
import com.user.service.UserServiceImpl;

@RestController
@RequestMapping("/userApp")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> users = userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId){
		UserDTO user = userService.getUserById(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Integer> addUser(@RequestBody UserDTO userdto){
		System.out.println("########## user dto :- " +userdto);
		Integer userId = userService.addUser(userdto);
		return new ResponseEntity<>(userId,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<Integer> updateUser(@PathVariable Integer userId,@RequestBody UserDTO userdto){
		 Integer user = userService.updateUser(userId, userdto);
		 return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeUser/{userId}")
	public ResponseEntity<Integer> deleteUser(@PathVariable Integer userId){
		Integer id = userService.removeUser(userId);
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<UserDTO>> getUsers(){
		List<UserDTO> users = userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	//https://github.com/shubham-joshi29/UserManagement.git
	//now this is new line is added.
	//third line added.

}
