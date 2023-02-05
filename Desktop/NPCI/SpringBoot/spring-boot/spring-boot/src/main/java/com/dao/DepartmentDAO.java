package com.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Department;

@Service
public class DepartmentDAO {
	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department getDeptById(int deptId) {
		return departmentRepository.findById(deptId).orElse(null);
	}

	public Department getDeptByName(String deptName) {
		return departmentRepository.findByName(deptName);
	}

	public Department registerDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public void deleteDepartment(int deptId) {
		departmentRepository.deleteById(deptId);
	}
}


