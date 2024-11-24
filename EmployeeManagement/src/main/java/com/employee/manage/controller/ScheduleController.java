package com.employee.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.ResourceNotFoundException;
import com.employee.manage.model.Schedule;
import com.employee.manage.repository.ScheduleRepository;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v6")
public class ScheduleController {
	
	@Autowired
	private ScheduleRepository attendanceRepository;
	
	//get all Employees
	@GetMapping("/schedules") 
	public List<Schedule> getAllEmployees(){
		return attendanceRepository.findAll();
	}
     @PostMapping("/schedules")
	public Schedule createAttendance(@RequestBody Schedule attendance) {
		return  attendanceRepository.save(attendance);
		
	}
     
     
     @GetMapping("/schedules/{empId}")
 	public ResponseEntity<Schedule> getEmployeeById(@PathVariable Long empId) {
 		Schedule employee = attendanceRepository.findById(empId)
 				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
 		return ResponseEntity.ok(employee);
 	}
 	
     @PutMapping("/schedules/{empId}")
 	public ResponseEntity<Schedule> updateEmployee(@PathVariable Long empId, @RequestBody Schedule employeeDetails){
 		Schedule employee = attendanceRepository.findById(empId)
 				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
 		
 		employee.setDate(employeeDetails.getDate());
 		employee.setShift(employeeDetails.getShift());
 		employee.setStartingTime(employeeDetails.getStartingTime());
 		employee.setEndTime(employeeDetails.getEndTime());
 		employee.setDuration(employeeDetails.getDuration());
 		employee.setEdate(employeeDetails.getEdate());
 	
 		
 		Schedule updatedEmployee = attendanceRepository.save(employee);
 		return ResponseEntity.ok(updatedEmployee);
     }
     @DeleteMapping("/schedules/{empId}")
 	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long empId){
 		Schedule employee = attendanceRepository.findById(empId)
 				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
 		
 		attendanceRepository.delete(employee);
 		Map<String, Boolean> response = new HashMap<>();
 		response.put("deleted", Boolean.TRUE);
 		return ResponseEntity.ok(response);
 	}
}