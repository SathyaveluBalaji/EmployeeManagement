package com.employee.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.manage.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

}