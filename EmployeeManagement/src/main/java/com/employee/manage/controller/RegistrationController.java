package com.employee.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.manage.model.Employee;
import com.employee.manage.service.RegistrationService;



@RestController
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/employees")
	@CrossOrigin(origins = "*")
	public Employee registerEmployee(@RequestBody Employee emp) throws Exception{
		String tempEmailId = emp.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId))
		{
			Employee empobj = service.fetchEmpByEmailId(tempEmailId);
			if(empobj != null)
			{
				throw new Exception("Employee with "+tempEmailId+" is already exists");
			}
			
		}
		Employee empObj=null;
		empObj = service.saveUser(emp);
		return empObj;
	}
	
	@PostMapping("/employees/login")
	@CrossOrigin(origins = "*")
	public Employee loginEmp(@RequestBody Employee emp) throws Exception {
		String tempEmailId = emp.getEmailId();
		String tempPass=emp.getPassword();
		Employee empObj = null;
		if(tempEmailId != null && tempPass != null ) {
			empObj = service.fetchEmpByEmailIdandPassword(tempEmailId, tempPass);
			
		}
		if(empObj ==null) {
			throw new Exception("Bad  Credentials");
		}
			//System.out.println(empObj.getEmailId());
			
			
		return empObj;
	
	}
	
	@PutMapping("/forgotpassword")
	@CrossOrigin(origins = "*")
	public Employee forgotpasswordemp(@RequestBody Employee emp) throws Exception {
		String tempEmailId = emp.getEmailId();
		String tempMobNo = emp.getMobNo();
		Employee empObj = null;
		if(tempEmailId != null && tempMobNo != null ) {
			empObj = service.fetchEmpByEmailIdandmobNo(tempEmailId, tempMobNo);		
		}
		if(empObj ==null) {
			throw new Exception("No Employee found with these credentials!");
		}
			
		return empObj;
	
	}

}