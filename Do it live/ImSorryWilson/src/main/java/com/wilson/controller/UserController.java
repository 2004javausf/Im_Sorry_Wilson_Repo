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
import com.wilson.util.LogThis;

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
		LogThis.LogIt("info", "User:" +username+ " logged in!");
		return userService.login(username, password);
	}
	
	@RequestMapping(value = "/findbyusername", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public User getUserByUsername(@RequestParam String username){
        System.out.println(username);
        System.out.println(userService.getUserByUsername(username));
        return userService.getUserByUsername(username);
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
		LogThis.LogIt("info", "Account:" +user.getUsername()+ " was created!");
		return this.userService.addUser(user);
	}
	
	@RequestMapping(value= "/updatepassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public int updatePassword(@RequestParam String newPassword, @RequestParam int userID) {
		return this.userService.updatePassword(newPassword, userID);
	}
	
	@RequestMapping(value= "/updateinfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody()
	public int updateInformation(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String username) {
		return this.userService.updateInformation(firstName, lastName, email, username);
	}
}
