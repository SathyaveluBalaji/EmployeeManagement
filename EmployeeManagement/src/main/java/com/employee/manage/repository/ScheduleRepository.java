package com.employee.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.manage.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

}