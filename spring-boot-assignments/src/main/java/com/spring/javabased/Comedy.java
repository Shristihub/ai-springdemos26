package com.spring.javabased;

import java.util.Arrays;
import java.util.List;

public class Comedy implements IMovie {

	@Override
	public List<String> showMoviesList(String language) {
		return Arrays.asList("Sheldon","Anbe");
	}

}
