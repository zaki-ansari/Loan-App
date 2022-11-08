package com.finzly.service;

import com.finzly.entity.UserSignIn;

public interface UserSignInService {

	UserSignIn loginUser(UserSignIn userSignIn);
	
	UserSignIn logoutUser(UserSignIn userSignIn);
}
