package com.spring.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		//create the IoContainer
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring");
		//get the bean from the IocContainer
		Employee employee = (Employee)context.getBean("employee");
		System.out.println(employee);
	}
}
