package com.employee.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.manage.model.Admin;
import com.employee.manage.repository.AdminRegistrationRepository;

@Service
public class AdminRegistrationService {
	

	@Autowired
	private AdminRegistrationRepository repo;
	
	public Admin saveUser(Admin adm){
		return repo.save(adm);
		}
	public Admin fetchAdmByEmailId(String email)
	{
		return repo.findByEmailId(email);
	}

	public Admin fetchAdmByEmailIdandPassword(String email, String password)
	{
		return repo.findByEmailIdAndPassword(email, password);
	}

	public List<Admin> findall()
	{
		return repo.findAll();
	}
	public String deleteAdmByEmailId(String emailId) 
	{
	 String result;
	 try {
		 repo.deleteByEmailId(emailId);
	     result="admindeleted";
	 }
	 catch(Exception e) {
		 result="adminnotdeleted";
	 }
	 return result;
	
	}
}
