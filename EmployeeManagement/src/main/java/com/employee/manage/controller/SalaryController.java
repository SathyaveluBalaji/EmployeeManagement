package com.employee.manage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.manage.model.Salary;
import com.employee.manage.repository.SalaryRepository;
import com.employee.manage.service.SalaryServices;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v7/")
@RestController
public class SalaryController {
	@Autowired
	private SalaryServices service;
	private SalaryRepository salaryrepo;
	
	@GetMapping("/{id}")
	public Optional<Salary> getEmployeeById(@PathVariable int id)
	{
		
		//System.out.println(salaryrepo.findById(empId));
		return service.fetchSalarybyId(id);
	}
	
	
	@GetMapping("/salaries")
	public List<Salary> fetchSalaryList()
	{
		List<Salary> salary = new ArrayList<Salary>();
		//fetch salary
		salary = service.fetchSalaryList();
		return salary;
	}
	
	@PostMapping("/salaries")
	public Salary saveSalary(@RequestBody Salary salary){
		return service.saveSalaryDb(salary);
		
		
	}
	
	@PostMapping("/editsalaries")
	@CrossOrigin(origins = "*")
	public Salary editSalary(@RequestBody Salary salary){
		return service.saveSalaryDb(salary);
		
		
	}
	
	@GetMapping("/salaries/{id}")
	@CrossOrigin(origins = "*")
	public Salary fetchSalaryById(@PathVariable int id)
	{
		return service.fetchSalarybyId(id).get();
		
	}
	
	@DeleteMapping("/salaries/{id}")
	@CrossOrigin(origins = "*")
	public String deleteSalById(@PathVariable int id){
		return service.deleteSalById(id);
		
		
	}
	
	@GetMapping("/empid/{empId}")
	public Optional<Salary> getEmployeeByempId(@PathVariable int empId)
	{
		
		//System.out.println(salaryrepo.findById(empId));
		return service.fetchSalarybyempId(empId);
	}
	
}