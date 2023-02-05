package com.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	@Id@GeneratedValue
	private int empId;
	private String empName;
	private double salary;
	private String gender;
	private Date doj;
	private String country;
	private String emailId;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="deptId")
	Department department;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Employee(int empId, String empName, double salary, String gender, Date doj, String country, String emailId,
			String password) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.gender = gender;
		this.doj = doj;
		this.country = country;
		this.emailId = emailId;
		this.password = password;
	}



	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", gender=" + gender
				+ ", doj=" + doj + ", country=" + country + ", emailId=" + emailId + ", password=" + password
				+ ", department=" + department + "]";
	}

	
}

