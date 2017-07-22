package com.qacg.qerp.persistence.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.qacg.qerp.persistence.entity.Employee;

public interface EmployeeRepository extends Repository<Employee, Long>  {

	List<Employee> findAll();
}
