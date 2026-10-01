package com.spring.javabased;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Theatre {
	
	@Autowired
	private IMovie movieref;

	public List<String> showMovies(String language){
		return movieref.showMoviesList(language);
		
	}
}
