package com.employee.manage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.manage.model.Admin;
import com.employee.manage.repository.AdminRegistrationRepository;
import com.employee.manage.service.AdminRegistrationService;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AdminTest {

	@Autowired
	AdminRegistrationRepository adrRepo;
	@Autowired
	AdminRegistrationService adrse;
	@Test
	@Order(1)
	public void testcreate() {
		Admin a = new Admin();
		
		a.setEmailId("noor@gmail.com");
		a.setPassword("noor");
		a.setUserName("murad");
		adrRepo.save(a);
		assertNotNull(adrRepo.findByEmailId("noor@gmail.com"));

	}
	@Test
	@Order(2)
	public void testReadAll() {
		List<Admin> list = adrRepo.findAll();
		assertThat(list).size().isGreaterThan(0);

	}
	
	@Test
	@Order(3)
	public void testSingleProduct() {
		Admin admin=adrRepo.findByEmailId("noor@gmail.com");
		assertEquals("noor",admin.getPassword());
	}
	
	@Test
	@Order(4)
	public void testUpdate() {
		Admin a=adrRepo.findByEmailId("test@gmail.com");
		a.setPassword("noor1");
		adrRepo.save(a);
		assertNotEquals("noor",adrRepo.findByEmailId("test@gmail.com"));
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		adrse.deleteAdmByEmailId("noor@gmail.com");
		//adrRepo.deleteByEmailId("noor@gmail.com");
		assertThat(adrRepo.findByEmailId("noor@gmail.com"));
		}
}