package com.employee.manage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Table(name="attendance")
@Entity

public class Attendance {
	@Id
	
	private long empId;
	private String Date;
	private String Status;
	
	public Attendance(long aId,long empId, String date, String status) {
		super();
		this.empId = empId;
		Date = date;
		Status = status;
	
	}


	

	public Attendance() {}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	
  
}