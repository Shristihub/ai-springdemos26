package com.training.service;

import java.util.Collection;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.training.model.JwtUser;
import com.training.repository.IJwtUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtUserServiceImpl implements UserDetailsManager{
	

	private IJwtUserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//call the custom queryand get the jwtuser
		JwtUser jwtuser =  userRepository.findByUsername(username)
								.orElseThrow(()-> new UsernameNotFoundException("username not found"));
		//get all details
		String nusername = jwtuser.getUsername();
		String password = jwtuser.getPassword();
//		Set<GrantedAuthority> authorities = jwtuser.getRoles()
//					.stream()
//					.map(role->new SimpleGrantedAuthority(role))
//					.collect(Collectors.toSet());
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) jwtuser.getAuthorities();
				
		//create a userdetails ref = User object (builtin User object)
		UserDetails userdetails = new User(nusername, password, authorities);
		return userdetails;
	}
	@Override
	public void createUser(UserDetails user) {
		//downcast
//		JwtUser jwtUser  = (JwtUser)user; 
		userRepository.save((JwtUser)user);
	}
	@Override
	public void updateUser(UserDetails user) {
		//downcast
//		JwtUser jwtUser  = (JwtUser)user; 
		userRepository.save((JwtUser)user);
	}
	@Override
	public void deleteUser(String username) {
		//returns the jwtUser object
		JwtUser jwtUser = userRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("username not found"));
		//call the built in method
		userRepository.deleteById(jwtUser.getJwtuserId());
	}
	@Override
	public void changePassword(@Nullable String oldPassword, @Nullable String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
