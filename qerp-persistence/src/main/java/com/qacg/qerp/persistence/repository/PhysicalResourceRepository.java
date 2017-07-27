package com.qacg.qerp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qacg.qerp.persistence.entity.PhysicalResource;

public interface PhysicalResourceRepository extends JpaRepository<PhysicalResource, Long> {

}
