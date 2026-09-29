package com.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.basics.constr.Student;
import com.basics.setter.Employee;

@SpringBootApplication
public class SpringBootBasicsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicsApplication.class, args);
	}
	
	@Autowired
	ApplicationContext context;
	
	private Employee employee;
	private Student student;
	
	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Autowired
	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public void run(String... args) throws Exception {
		
//		Employee employ = context.getBean("employee", Employee.class);
//		System.out.println(employ);
//		System.out.println();
		String[] beans = context.getBeanDefinitionNames();
		// iterate 
		//convert array to a stream
//		Arrays.stream(beans).forEach(System.out::println);
		
		
		
		System.out.println(employee);
		System.out.println(student);
		
		
	}

}
