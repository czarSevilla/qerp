package com.qacg.qerp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qacg.qerp.persistence.entity.EmployeeReference;

public interface EmployeeReferenceRepository extends JpaRepository<EmployeeReference, Long> {

}
