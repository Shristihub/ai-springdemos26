package com.training.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.JwtUser;
import com.training.model.JwtUserLogin;
import com.training.model.JwtUserRequest;
import com.training.service.JwtUserServiceImpl;
import com.training.util.JwtTokenUtil;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class JwtUserController {
	
	  ModelMapper mapper;
	  PasswordEncoder encoder; // inject this
	  JwtUserServiceImpl userServiceImpl; // inject this
	  JwtTokenUtil tokenUtil;
	
	//user gets created
	@PostMapping("/register")
	ResponseEntity<Void> registerUser(@RequestBody JwtUserRequest jwtUserRequest){
		// convert the userRequest to JwtUser object
		JwtUser jwtUser = mapper.map(jwtUserRequest, JwtUser.class);
		
		// get the password for jwtUser
		String password = jwtUser.getPassword();
		// encode the password using PasswordEncoder
		String encodedPassword =  encoder.encode(password);
		//set the password to JwtUser
		jwtUser.setPassword(encodedPassword);
		
		// call the method of jwtUSerServiceImpl
		userServiceImpl.createUser(jwtUser);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//user is authenticated and the token is returned back to the client
	@PostMapping("/login")
	ResponseEntity<String> authenticateUser(@RequestBody JwtUserLogin jwtUserLogin){
		//call the method of the service and get the userdetails object
		UserDetails userDetails = userServiceImpl.loadUserByUsername(jwtUserLogin.getUsername());
		
		//call the jwtToken util class to generate the token and get the token
		String token = tokenUtil.generateToken(userDetails, userDetails.getUsername());
		//return the jwttoken to the client
		return ResponseEntity.ok(token);
	}
	
	

}
