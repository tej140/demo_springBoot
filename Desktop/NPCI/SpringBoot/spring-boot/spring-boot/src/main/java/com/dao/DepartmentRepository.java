package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	@Query("from Department d where d.deptName = :deptName")
	Department findByName(@Param("deptName") String deptName);
}

