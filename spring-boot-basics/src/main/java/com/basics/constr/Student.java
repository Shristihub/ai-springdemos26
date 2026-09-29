package com.basics.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	private String studentName;
	private int studentId;
	private Department department;
	// constructor
	// department will be injected automatically
	// no need to add @Autowired
	public Student(Department department) {
		super();
		this.department = department;
	}
	public String getStudentName() {
		return studentName;
	}
	@Value("Raju")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	@Value("10")
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", department=" + department + "]";
	}
	
	
}
