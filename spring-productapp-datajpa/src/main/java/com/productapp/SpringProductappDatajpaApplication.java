package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappDatajpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappDatajpaApplication.class, args);
	}
	
	
	private IProductService productService;

	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}


	@Override
	public void run(String... args) throws Exception {
		Product product = new Product("Mobile",null,20000,"Samsung","Electronics",4);
		productService.addProduct(product);
		product = new Product("Television",null,200000,"Samsung","Electronics",3);
		productService.addProduct(product);
		product = new Product("Pen",null,200,"Classmate","Stationary",4);
		productService.addProduct(product);
		
		
	}

}
