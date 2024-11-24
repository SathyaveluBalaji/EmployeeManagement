package com.employee.manage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.manage.model.Attendance;
import com.employee.manage.repository.AttendanceRepository;

//import com.Attendance .spring.model.Schedule;
//import com.emp.leave.model.Leave;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AttendanceApplicationTests {

	@Autowired
	AttendanceRepository aRepo;
		@Test
		@Order(1)
			public void testCreate ()
			{
			Attendance a=new Attendance();
		a.setEmpId(108L);
		a.setDate("2022-03-09");
		a.setStatus("present");
		aRepo.save(a);
		assertNotNull(aRepo.findById(108L).get());
			
			}
		@Test
		@Order(2)
		public void testRead () {
			Attendance attendance = aRepo.findById(10005L).get();
			assertEquals("present", attendance.getStatus());
		}
		private void assertEquals(String string, String duration) {
			// TODO Auto-generated method stub
			
		}
		@Test
		@Order(3)
		public void testReadAll () {
			List list = aRepo.findAll();
			assertThat(list).size().isGreaterThan(0);
		}
		
		@Test
		@Order(4)
		public void testUpdate () {
			Attendance  a = aRepo.findById(10005L).get();
			a.setDate("2022-02-24");
			aRepo.save(a);
			assertNotEquals(4/3/2022, aRepo.findById(10005L).get().getDate());
		}

		
		@Test
		@Order(5)
		public void testDelete () {
			aRepo.deleteById(108L);
			assertThat(aRepo.existsById(108L)).isFalse();
		}


		private void assertNotNull(Attendance attendance) {
			// TODO Auto-generated method stub
			
		}
}