package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	@Id@GeneratedValue
	private int deptId;
	private String deptName;
	private String location;
	
	@JsonIgnore
	@OneToMany(mappedBy="department",cascade = CascadeType.REMOVE)
	List<Employee> employees = new ArrayList<Employee>();

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int deptId, String deptName, String location) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
	}

	public Department(int deptId, String deptName, String location, List<Employee> employees) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
		this.employees = employees;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", location=" + location +"]";
	}

	
}

