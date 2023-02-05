package com.npci;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import com.dao.EmployeeDAO;
import com.model.Department;
import com.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAO empDAO;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return empDAO.getAllEmployees();
	}
	@GetMapping("/getEmpById/{empId}")
	public Employee getEmpById(@PathVariable("empId") int empId) {
		Employee emp = empDAO.getEmpById(empId);

		if (emp != null)
			return emp;
		
		java.util.Date utilDate = null;
		java.sql.Date sqlDate = null;
		
		try {
			utilDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-31");
			sqlDate = new java.sql.Date(utilDate.getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return new Employee(0, "Employee Not Found!!!", 0.0, "", sqlDate, "", "", "");
	}
	
	@GetMapping("/getEmployee/{emailId}/{password}")
	public Employee getEmployee(@PathVariable("emailId") String emailId, @PathVariable("password") String password) {
		return empDAO.getEmployee(emailId, password);
	}

	@GetMapping("/getEmpByName/{empName}")
	public Employee getDeptByName(@PathVariable("empName") String empName) {
		Employee emp = empDAO.getEmpByName(empName);

		if (emp != null)
			return emp;
		return new Employee(0, "Employee Not Found!!!", 0.0,"", null, "","","");
	}

	@PostMapping("/registerEmployee")
	public String registerEmployee(@RequestBody Employee employee) {

		Employee emp = empDAO.registerEmployee(employee);

		if (emp != null)
			return "Employee Registered into the Database";

		return "Employee Registeration Failed!!!";
	}
	
//	@RequestMapping("/registerEmployeeHC")
//	public String registerEmployeeHC() {		
//		
//		Object deptDAO;
//		List<Department> deptList = deptDAO.getAllDepartments();
//		
//		Employee emp1 = new Employee(1, "Pasha", 4545.45);
//		emp1.setDepartment(deptList.get(0));
//		
//		Employee emp2 = new Employee(2, "Venkat", 4545.45);
//		emp2.setDepartment(deptList.get(1));
//		
//		Employee emp3 = new Employee(3, "Deepika", 5454.54);
//		emp3.setDepartment(deptList.get(2));
//		
//		empDAO.registerEmployee(emp1);
//		empDAO.registerEmployee(emp2);
//		empDAO.registerEmployee(emp3);
//		
//		return "Employee Records Registered into the Database!";
//	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {

		Employee emp = empDAO.registerEmployee(employee);

		if (emp != null)
			return "Employee Record Updated in the Database";

		return "Employee Updation Failed!!!";
	}

	@DeleteMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable("empId") int empId) {
		empDAO.deleteEmployee(empId);
		return "Employee(" + empId + ") Record Deleted Successfully!";
	}

}


