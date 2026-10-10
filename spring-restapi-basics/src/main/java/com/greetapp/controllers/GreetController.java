package com.greetapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	// add restend points / rest apis
	
//	http://localhost:8080/show
	@GetMapping("/show")
	String showMessage(){
	  return "Have a great day"; // response sent to client
	}
	
//	http://localhost:8080/greet/Priya - data comes in the url
	@GetMapping("/greet/{username}") 
	String greetUser(@PathVariable String username){
		return "Welcome "+username;
	}
	
//	http://localhost:8080/show-books
	@GetMapping("/show-books")
	List<String> showBooks(){
		return Arrays.asList("Java","Angular","Spring");
	}
	
//	 http://localhost:8080/print?username=Priya&city=Bangalore -queryString
//	use @RequestParam annotation
	  @GetMapping("/print")
	  String printDetails(@RequestParam("username") String  name,
			              @RequestParam String city){
		  return "Hello "+name +"!!Welcome to "+city;
	  }
	  
	  
	  
	  
	  
	  
	  
	
}






