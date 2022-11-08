package com.finzly.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserSignUp {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userSignUpId;
	private String userEmail;
	private String userPassword;
}
