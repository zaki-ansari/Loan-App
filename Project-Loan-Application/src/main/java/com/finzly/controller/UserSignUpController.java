package com.finzly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.entity.UserSignUp;
import com.finzly.service.UserSignUpService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/userSignUp")
public class UserSignUpController {
	
	@Autowired
	UserSignUpService userSignUpService;
	
	@PostMapping("/create")
	ResponseEntity<UserSignUp> createUser(@ RequestBody UserSignUp userSignUp){
		
		UserSignUp createdUserSignUp = this.userSignUpService.createUser(userSignUp);
		
		return new ResponseEntity<UserSignUp>(createdUserSignUp,HttpStatus.CREATED);
	}
	
	
}
