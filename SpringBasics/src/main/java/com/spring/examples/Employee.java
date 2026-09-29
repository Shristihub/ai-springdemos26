package com.spring.examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {//the bean name is employee

	private String empName;
	private int empId;
	private double salary;
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
	@Value("Priya")
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	@Value("100")
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", salary=" + salary + "]";
	}
	
}
