package com.finzly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finzly.entity.UserSignUp;

public interface UserSignUpRepo extends JpaRepository<UserSignUp, Integer>{

	public UserSignUp findByUserEmail(String userEmail);
}
