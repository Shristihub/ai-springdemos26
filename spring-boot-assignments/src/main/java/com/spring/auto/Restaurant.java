package com.spring.auto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {

	private IMenu menu; // menu = new Indian();
	
	@Autowired
	// to pick and choose a specific bean
	@Qualifier("indian") // autowiring by type 
	public void setMenu(IMenu menu) {
		this.menu = menu;
	}
	// if the instance variable is same as that of the bean name
	@Autowired
	private IMenu italian; // italian = new Italian() autowiring by name
	
	
	private IMenu newMenu;
	
	// no need of @Autpwired above this.It will be injected
	public Restaurant(@Qualifier("chinese")  IMenu newMenu) {
		super();
		this.newMenu = newMenu;
	}
	
	public List<String> showMenu(String choice){
		List<String> menuItems = new ArrayList<>();
		if(choice.equalsIgnoreCase("in"))
			menuItems = menu.itemsAvailable();
		else if(choice.equalsIgnoreCase("it"))
			menuItems = italian.itemsAvailable();
		else if(choice.equalsIgnoreCase("ch"))
			menuItems = newMenu.itemsAvailable();
		else
			menuItems =  Arrays.asList("No menu available");
		return menuItems;
	}

}









