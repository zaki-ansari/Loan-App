package com.finzly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.entity.UserSignUp;
import com.finzly.exception.ResourceNotFoundException;
import com.finzly.repository.UserSignUpRepo;
import com.finzly.service.UserSignUpService;

@Service
public class UserSignUpServiceImpl implements UserSignUpService{

	@Autowired
	UserSignUpRepo userSignUpRepo;
	
	@Override
	public UserSignUp createUser(UserSignUp userSignUp) {
		
		UserSignUp existedUserSignUp = this.userSignUpRepo.findByUserEmail(userSignUp.getUserEmail());
		UserSignUp savedUserSignUp=null;
		if(existedUserSignUp==null) {
			savedUserSignUp = this.userSignUpRepo.save(userSignUp);
		}else {
			throw new ResourceNotFoundException("Already User Exists...");
		}
		
		return savedUserSignUp;
	}
	
	
}
