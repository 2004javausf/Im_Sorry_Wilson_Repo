package com.wilson.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.entity.User;
import com.wilson.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
		
		return ret;
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public User addNewUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
}
