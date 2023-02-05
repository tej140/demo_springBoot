package com.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Employee;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployee(String emailId, String password) {		
		return employeeRepository.getEmployee(emailId, password);
	}

	public Employee getEmpById(int empId) {
		return employeeRepository.findById(empId).orElse(null);
	}

	public Employee getEmpByName(String empName) {
		return employeeRepository.findByName(empName);
	}

	public Employee registerEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
	}	
}


