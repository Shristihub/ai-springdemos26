package com.spring.javabased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Thriller implements IMovie {

	@Override
	public List<String> showMoviesList(String language) {
		List<String> movies = new ArrayList<>();
		if (language.equalsIgnoreCase("malayalam"))
			movies = Arrays.asList("Dhrishyam", "Dridam");
		else if (language.equalsIgnoreCase("tamil"))
			movies = Arrays.asList("24", "Jo");
		else if (language.equalsIgnoreCase("telugu"))
			movies = Arrays.asList("KGF", "Hit");
		else
			movies = Arrays.asList("no moviesavailable");
		return movies;
	}

}
