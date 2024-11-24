package com.employee.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.ResourceNotFoundException;
import com.employee.manage.model.Leave;
import com.employee.manage.repository.LeaveRepository;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v4")
public class LeaveController {
	

	@Autowired
	private LeaveRepository leaveRepository;
		
	@GetMapping("/{empId}")
	public Optional<Leave> getEmployeeById(@PathVariable Long empId)
	{
		
		System.out.println(leaveRepository.findById(empId));
		return leaveRepository.findById(empId);
	}
	//get all Employees
	@GetMapping("/leaves")
	public List<Leave> getAllEmployees(){
		return leaveRepository.findAll();
	}
     @PostMapping("/leaves")
	public Leave createL(@RequestBody Leave leave) {
		return  leaveRepository.save(leave);
		
	}
     
     @DeleteMapping("/leaves/{empId}")
 	public ResponseEntity<Map<String, Boolean>> deleteLeave(@PathVariable Long empId){
 		Leave leave = leaveRepository.findById(empId)
 				.orElseThrow(() -> new ResourceNotFoundException("Leave not exist with id :" + empId));
 		
 		leaveRepository.delete(leave);
 		Map<String, Boolean> response = new HashMap<String, Boolean>();
 		response.put("deleted", Boolean.TRUE);
 		return ResponseEntity.ok(response);
 	}
}

