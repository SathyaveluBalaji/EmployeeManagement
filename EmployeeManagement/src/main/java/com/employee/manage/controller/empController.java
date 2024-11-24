package com.employee.manage.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.manage.model.Employee;
import com.employee.manage.repository.EmployeeRepository;

@Repository
	@CrossOrigin(origins="*")
	@RestController
	@RequestMapping("/api/v2/")
	public class empController {

		@Autowired
		private EmployeeRepository emprepository;
		
		@GetMapping("/{empId}")
		public Optional<Employee> getEmployeeById(@PathVariable int empId)
		{
			//Employee employee = emprepository.findById(empId);
			
//			System.out.println(employee);
//			System.out.println(emprepository);

			//return (ResponseEntity<Employee>) emprepository.findByEmailId(empId);
			System.out.println(emprepository.findById(empId));
			return emprepository.findById(empId);
			
			//return "redirect:/admin/{empId}"; 
		}
}
