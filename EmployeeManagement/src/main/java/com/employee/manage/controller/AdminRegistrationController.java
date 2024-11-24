package com.employee.manage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.manage.model.Admin;
import com.employee.manage.repository.AdminRegistrationRepository;
import com.employee.manage.service.AdminRegistrationService;
@RequestMapping("/api/v1/")
@RestController
public class AdminRegistrationController {
	@Autowired
	private AdminRegistrationService service;
	@GetMapping("/admins")
	public List<Admin> getAllAdmin()
	{
		System.out.println(service.findall());
		return service.findall();
	
	}
	@PostMapping("/register")
	@CrossOrigin(origins ="*")
	public Admin registerAdmin(@RequestBody Admin adm) throws Exception{
		String tempEmailId = adm.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId))
		{
			Admin empobj = service.fetchAdmByEmailId(tempEmailId);
			if(empobj != null)
			{
				throw new Exception("Admin with "+tempEmailId+" is already exists");
			}
			
		}
		Admin admObj=null;
		admObj = service.saveUser(adm);
		return admObj;
	}
	@PostMapping("/login")
	@CrossOrigin(origins ="*")
	public Admin loginadm(@RequestBody Admin adm) throws Exception {
		String tempEmailId = adm.getEmailId();
		String tempPass=adm.getPassword();
		System.out.println(tempEmailId+","+tempPass);
		Admin admObj = null;
		if(tempEmailId != null && tempPass != null ) {
			admObj = service.fetchAdmByEmailIdandPassword(tempEmailId, tempPass);
			
		}
		if(admObj ==null) {
			throw new Exception("Bad  Credentials");
		}
			
		return admObj;

	}
	}
//	@DeleteMapping("/{emailId}")
//	public ResponseEntity<Map<String,Boolean>>deleteAdmin(@PathVariable String emailId){
//		Admin admin=repo.findByEmailId(emailId);
//		repo.deleteByEmailId(emailId);
//		Map<String,Boolean> response =new HashMap<>();
//		response.put("deleted",Boolean.TRUE);
//		return ResponseEntity.ok(response);
//	}
//}