package com.qacg.qerp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qacg.qerp.persistence.entity.PhysicalResourceType;

public interface PhysicalResourceTypeRepository extends JpaRepository<PhysicalResourceType, Long> {

}
