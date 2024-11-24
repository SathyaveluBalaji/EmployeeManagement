package com.employee.manage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.manage.model.Timesheet;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet, Integer> {

}