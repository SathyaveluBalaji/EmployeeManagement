package com.employee.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.manage.model.Employee;
import com.employee.manage.repository.EmployeeRepository;

@Repository
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository Employeerepository;

	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		return Employeerepository.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) 
	{
		return Employeerepository.save(employee);
	}
	
	
	@GetMapping("/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable int empId)
	{
		//Employee employee = Employeerepository.findById((int) empId).orElseThrow(null);
		return Employeerepository.findById(empId);
		//return "redirect:/Employee/{empId}"; 
	}
	
	@PutMapping("/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody(required=false) Employee Employee1)
	{
		Employee employee = Employeerepository.findById((int) empId).orElseThrow(null);

		employee.setEmpId(Employee1.getEmpId());
		employee.setfName(Employee1.getfName());
		employee.setlName(Employee1.getlName());
		employee.setDob(Employee1.getDob());
		employee.setGender(Employee1.getGender());
		employee.setStreet(Employee1.getStreet());
		employee.setLocation(Employee1.getLocation());
		employee.setCity(Employee1.getCity());
		employee.setState(Employee1.getState());
		employee.setPincode(Employee1.getPincode());
		employee.setMobNo(Employee1.getMobNo());
		employee.setEmailId(Employee1.getEmailId());
		employee.setPassword(Employee1.getPassword());
		employee.setdesignation(Employee1.getdesignation());
		
		Employee updatedEmployee = Employeerepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}	
	
		@DeleteMapping("/{empId}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int empId)
		{
			Employee employee = Employeerepository.findById((int) empId).orElseThrow(null);
			
			Employeerepository.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	}
