package com.qacg.qerp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qacg.qerp.persistence.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}
