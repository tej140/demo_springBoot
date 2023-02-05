package com.npci;

import java.util.List;
import com.dao.DepartmentDAO;
import com.model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DepartmentController {

	@Autowired
	DepartmentDAO deptDAO;
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments() {
		return deptDAO.getAllDepartments();
	}
	@GetMapping("/getDeptById/{deptId}")
	public Department getDeptById(@PathVariable("deptId") int deptId) {
		Department dept = deptDAO.getDeptById(deptId);
		
		if (dept != null)
			return dept;
		return new Department(0, "Department Not Found!!!", "");
	}
	
	@GetMapping("/getDeptByName/{deptName}")
	public Department getDeptByName(@PathVariable("deptName") String deptName) {
		Department dept = deptDAO.getDeptByName(deptName);
		
		if (dept != null)
			return dept;
		return new Department(0, "Department Not Found!!!", "");
	}
	
	@PostMapping("/registerDepartment")
	public String registerDepartment(@RequestBody Department department) {
		
		Department dept = deptDAO.registerDepartment(department);
		
		if (dept != null)
			return "Department Registered into the Database";

		return "Department Registeration Failed!!!";
	}
	
	@GetMapping("/registerDepartmentHC")
	public String registerDepartmentHC() {
		
		Department detp1 = new Department(1, "Mechanical", "Hyderabad");
		Department detp2 = new Department(2, "Computers",  "Chennai");
		Department detp3 = new Department(3, "Accounts",   "Pune");
		
		deptDAO.registerDepartment(detp1);
		deptDAO.registerDepartment(detp2);
		deptDAO.registerDepartment(detp3);
		
		return "Departments Registered into the Database";
	}

	@PutMapping("/updateDepartment")
	public String updateDepartment(@RequestBody Department department) {
		
		Department dept = deptDAO.registerDepartment(department);
		
		if (dept != null)
			return "Department Registered into the Database";

		return "Department Registeration Failed!!!";
	}
	
	
	@DeleteMapping("/deleteDepartment/{deptId}")
	public String deleteDepartment(@PathVariable("deptId") int deptId) {
		deptDAO.deleteDepartment(deptId);
		return "Department(" + deptId + ") Record Deleted Successfully!";
	}
	
}


