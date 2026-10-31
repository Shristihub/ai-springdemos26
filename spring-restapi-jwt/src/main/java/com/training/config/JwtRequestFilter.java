package com.training.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.training.util.JwtTokenUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtRequestFilter extends OncePerRequestFilter{
	
    final JwtTokenUtil tokenUtil;
    

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// get the request header with tha name "Authorization"
		//returns Bearer eytwesq123123
		String header = request.getHeader("Authorization");
		//check
		if(header==null && (!header.startsWith("Bearer"))){
			logger.warn("no header");
		}else {
			// get the token from the header value
			String token = header.substring(7);
			//extract username from the token
			String username = tokenUtil.getUsernameFromToken(token);
			//check if username is available
			
			
			
		}
	
		
		
		
		
		
		
		
		
		
		
		
	}

}
