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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.ResourceNotFoundException;
import com.employee.manage.model.Timesheet;
import com.employee.manage.repository.TimesheetRepository;

@CrossOrigin(origins="*")

@RestController
@RequestMapping("/api/v5")
public class TimesheetController {
	
	@Autowired
	private TimesheetRepository timesheetRepository;
	
	@GetMapping("/{empId}")
	public Optional<Timesheet> getEmployeeById(@PathVariable int empId)
	{
		
		System.out.println(timesheetRepository.findById(empId));
		return timesheetRepository.findById(empId);
	}
	
	//get all timesheets
	@GetMapping("/timesheets")
	public List<Timesheet> getAllTimesheets(){
		return (List<Timesheet>) timesheetRepository.findAll();
		
	}
	
	//create timesheet rest api
	@PostMapping("/timesheets")
	public Timesheet createTimesheet(@RequestBody Timesheet timesheet) {
		return timesheetRepository.save(timesheet);
	}
	
	//get timesheet by id rest api
	@GetMapping("/timesheets/{empId}")
	public ResponseEntity<Timesheet> getTimesheetById(@PathVariable Integer empId) {
		
	Timesheet timesheet = timesheetRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Timesheet not exit with id:"+empId));
		return ResponseEntity.ok(timesheet);
	}
	
	//update timesheet rest api
	@PutMapping("/timesheets/{empId}")
	public ResponseEntity<Timesheet> updateTimesheet(@PathVariable Integer empId, @RequestBody Timesheet timesheetDetails) {
		
	Timesheet timesheet = timesheetRepository.findById(empId)
		.orElseThrow(() -> new ResourceNotFoundException("Timesheet not exit with id :"+ empId));
		
		timesheet.setEmpId(timesheetDetails.getEmpId());
		timesheet.setDate(timesheetDetails.getDate());
		timesheet.setInTime(timesheetDetails.getInTime());
		timesheet.setOutTime(timesheetDetails.getOutTime());
		timesheet.setRegularTime(timesheetDetails.getRegularTime());
		timesheet.setBreakTime(timesheetDetails.getBreakTime());
		timesheet.setOvertimeHours(timesheetDetails.getOvertimeHours());
		timesheet.setTotalHours(timesheetDetails.getTotalHours());
		
		Timesheet updatedTimesheet =timesheetRepository.save(timesheet);
		return ResponseEntity.ok(updatedTimesheet);
	}
	
	//delete timsheet rest api
	
	@DeleteMapping("/timesheets/{empId}")
	public ResponseEntity<Map<String, Boolean>> deleteTimesheet(@PathVariable Integer empId) {
		Timesheet timesheet = timesheetRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Timesheet not exit with id :"+ empId));
		
		timesheetRepository.delete(timesheet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
}