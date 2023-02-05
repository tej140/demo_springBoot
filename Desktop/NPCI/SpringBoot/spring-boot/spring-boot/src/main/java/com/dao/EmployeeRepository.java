package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("from Employee e where e.empName = :empName")
	Employee findByName(@Param("empName") String empName);

	@Query("from Employee e where e.emailId = :emailId and e.password = :password")
	Employee getEmployee(@Param("emailId") String emailId, @Param("password") String password);
}

