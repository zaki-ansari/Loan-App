package com.finzly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finzly.entity.UserSignIn;
import com.finzly.entity.UserSignUp;

public interface UserSignInRepo extends JpaRepository<UserSignIn, Integer>{

	public UserSignIn findByUserEmail(String userEmail);
}
