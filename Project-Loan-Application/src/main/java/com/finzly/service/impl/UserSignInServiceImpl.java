package com.finzly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.entity.UserSignIn;
import com.finzly.exception.ResourceNotFoundException;
import com.finzly.repository.UserSignInRepo;
import com.finzly.service.UserSignInService;

@Service
public class UserSignInServiceImpl implements UserSignInService{

	@Autowired
	private UserSignInRepo userSignInRepo;
	
	@Override
	public UserSignIn loginUser(UserSignIn userSignIn) {
		UserSignIn existedUserSignIn = this.userSignInRepo.findByUserEmail(userSignIn.getUserEmail());
		UserSignIn savedUserSignIn = null;
		if(existedUserSignIn==null) {
			savedUserSignIn = this.userSignInRepo.save(userSignIn);
		}else {
			throw new ResourceNotFoundException("Already User Logged In...");
		}
		return savedUserSignIn;
	}

	@Override
	public UserSignIn logoutUser(UserSignIn userSignIn) {
		
		this.userSignInRepo.delete(userSignIn);
		return userSignIn;
	}

}
