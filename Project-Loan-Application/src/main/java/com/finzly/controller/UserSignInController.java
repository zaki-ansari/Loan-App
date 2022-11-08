package com.finzly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.entity.UserSignIn;
import com.finzly.service.UserSignInService;

@RestController
@RequestMapping("/userSignIn")
public class UserSignInController {

	@Autowired
	UserSignInService userSignInService;
	
	@PostMapping("/login")
	public ResponseEntity<UserSignIn> loginUser(@RequestBody UserSignIn userSignIn) {
		
		UserSignIn loginUser = this.userSignInService.loginUser(userSignIn);
		
		return new ResponseEntity<UserSignIn>(loginUser,HttpStatus.ACCEPTED);
	}
}
