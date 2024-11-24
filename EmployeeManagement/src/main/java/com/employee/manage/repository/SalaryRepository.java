package com.employee.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.manage.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

	public Salary findByEmpId(int empId);

}