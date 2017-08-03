package com.qacg.qerp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qacg.qerp.persistence.entity.PhysicalResource;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;

public interface PhysicalResourceRepository extends JpaRepository<PhysicalResource, Long> {
   List<PhysicalResource> findAllByPRType(PhysicalResourceType type);
   
   @Query("SELECT a FROM PhysicalResourceHasFeature b join b.physicalResource a where a.pRType.idPhysicalResourceType=? and  b.value=?")
   List<PhysicalResource> findAllByFeature(Long idType, String value);
}
