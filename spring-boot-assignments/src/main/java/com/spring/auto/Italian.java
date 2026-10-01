package com.spring.auto;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Italian implements IMenu{

	@Override
	public List<String> itemsAvailable() {
		return Arrays.asList("Pasta","Pizza");
	}

}
