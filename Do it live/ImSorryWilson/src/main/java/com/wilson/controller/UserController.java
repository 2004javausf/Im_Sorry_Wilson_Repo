package com.wilson.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.entity.User;
import com.wilson.service.UserService;
import com.wilson.util.LogThis;

@RestController
@RequestMapping("/user")
@CrossOrigin

public class UserController {
	private UserService userService;
	@Autowired
	UserController(UserService userService){
		this.userService = userService;
	}
  
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody()
	public User getUser(@RequestBody User user){
		List<User> temp = new ArrayList<User>();
		User ret = new User();
		temp = this.userService.getAllUsers();
		for(int i=0; i<temp.size(); i++) {
			if(temp.get(i).getUsername().equals(user.getUsername())) { //if username matches
				if(temp.get(i).getPassword().equals(user.getPassword())) {
					ret = temp.get(i);
				}
				i=temp.size();
			}
		}
		LogThis.LogIt("info", "User:" +ret.getUsername()+ " logged in!");
		return ret;
	}
	

	@RequestMapping(value = "/findbyusername", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody()
	public User getUserByUsername(@RequestBody User user){
		List<User> temp = new ArrayList<User>();
		User ret = new User();
		temp = this.userService.getAllUsers();
		for(int i=0; i<temp.size(); i++) {
			if(temp.get(i).getUsername().equals(user.getUsername())) { //if username matches
				ret = temp.get(i);
				i=temp.size(); //we're done here
			}
			
		}
		return ret;
	}

	
	@RequestMapping(value= "/register", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody()
	public User addNewUser(@RequestBody User user) {
		LogThis.LogIt("info", "Account:" +user.getUsername()+ " was created!");
		return this.userService.addUser(user);
	}
	
	@RequestMapping(value= "/updatepassword", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody()
	public int updatePassword(@RequestBody User user) {
		return this.userService.updatePassword(user.getPassword(), user.getId());
	}
	
	@RequestMapping(value= "/updateinfo", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody()
	public int updateInformation(@RequestBody User u) {
		return this.userService.updateInformation(u.getFirstName(), u.getLastName(), u.getEmail(),u.getPic(), u.getUsername());
	}
}