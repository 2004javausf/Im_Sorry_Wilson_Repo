package com.wilson.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.beans.User;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@PostMapping(value = "/login")
	public ResponseEntity <User> login(String username, String pass){
		
		return null;
	}

}
