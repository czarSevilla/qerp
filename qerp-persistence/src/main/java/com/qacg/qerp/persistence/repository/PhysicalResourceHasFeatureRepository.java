package com.qacg.qerp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qacg.qerp.persistence.entity.PhysicalResourceHasFeature;
import com.qacg.qerp.persistence.entity.ResourceFeature;

public interface PhysicalResourceHasFeatureRepository extends JpaRepository<PhysicalResourceHasFeature, Long> {
   List<PhysicalResourceHasFeature> findAllByResourceFeature(ResourceFeature resourceFeature); 
}
