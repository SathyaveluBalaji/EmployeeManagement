package com.employee.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.manage.model.Admin;

public interface AdminRegistrationRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findByEmailId(String emailId);
	public Admin findByEmailIdAndPassword(String emailId, String password);
	public Admin deleteByEmailId(String emailId);
}