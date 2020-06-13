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
import com.wilson.service.PostService;
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
	

	@RequestMapping(value = "/findbyusername", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
		
		return ret; //Returns json with null values if does not exist, filled json if it does.
	}

	
	@RequestMapping(value = "/findbyid", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public User getUserById(@RequestBody User user){
		List<User> temp = new ArrayList<User>();
		User ret = new User();
		temp = this.userService.getAllUsers();
		for(int i=0; i<temp.size(); i++) {
			if(temp.get(i).getId().equals(user.getId())) { //if username matches
				ret = temp.get(i);
				i=temp.size(); //we're done here
			}
		}
		
		return ret; //Returns json with null values if does not exist, filled json if it does.
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public User addNewUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@RequestMapping(value= "/updatepassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public int updatePassword(@RequestBody User user) {
		return this.userService.updatePassword(user.getPassword(), user.getId());
	}
	
	@RequestMapping(value= "/updateinfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	
	public int updateInformation(@RequestBody User u) {
		return this.userService.updateInformation(u.getFirstName(), u.getLastName(), u.getEmail(), u.getUsername());
	}
}
