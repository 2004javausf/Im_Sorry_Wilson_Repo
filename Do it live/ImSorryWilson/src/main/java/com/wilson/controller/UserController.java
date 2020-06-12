package com.wilson.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.entity.Login;
import com.wilson.entity.User;
import com.wilson.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	private UserService userService;
	@Autowired
	UserController(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public User getUserAuthenticate(@RequestParam String username, @RequestParam String password){
		return userService.login(username, password);
	}
	
	@RequestMapping(value = "/findbyusername", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public User getUserByUsername(@RequestParam String username){
		System.out.println(username);
		System.out.println(userService.getUserByUsername(username));
		return userService.getUserByUsername(username);
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public User addNewUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@RequestMapping(value= "/updatepassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public int updatePassword(@RequestParam String newPassword, @RequestParam int userID) {
		return this.userService.updatePassword(newPassword, userID);
	}
}
