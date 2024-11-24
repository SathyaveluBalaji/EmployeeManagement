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
import com.employee.manage.model.Attendance;
import com.employee.manage.repository.AttendanceRepository;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v3")
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@GetMapping("/{aId}")
	public Optional<Attendance> getEmployeeById(@PathVariable long aId)
	{
		
		System.out.println(attendanceRepository.findById(aId));
		return attendanceRepository.findById(aId);
	}
	//get all Employees
	@GetMapping("/attendances")
	public List<Attendance> getAllEmployees(){
		return attendanceRepository.findAll();
	}
     @PostMapping("/attendances")
	public Attendance createAttendance(@RequestBody Attendance attendance) {
		return  attendanceRepository.save(attendance);
		
	}
     
     @DeleteMapping("/attendances/{empId}")
 	 public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long empId){
 		Attendance employee = attendanceRepository.findById(empId)
 				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
 		
 		attendanceRepository.delete(employee);
 		Map<String, Boolean> response = new HashMap<>();
 		response.put("deleted", Boolean.TRUE);
 		return ResponseEntity.ok(response);
 	}
}