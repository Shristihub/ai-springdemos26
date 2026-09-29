package com.basics.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {//the bean name is employee

	private String empName;
	private int empId;
	private double salary;
	@Autowired
	private Address address;
	
	public Employee(String empName, int empId, double salary) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmpName() {
		return empName;
	}
	@Value("${employee.name}")
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	@Value("${employee.empId}")
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getSalary() {
		return salary;
	}
	@Value("${employee.salary}")
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", salary=" + salary + ", address=" + address
				+ "]";
	}
	
}

