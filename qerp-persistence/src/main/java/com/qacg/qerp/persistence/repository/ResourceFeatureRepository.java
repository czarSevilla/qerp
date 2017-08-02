package com.qacg.qerp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.entity.ResourceFeature;

public interface ResourceFeatureRepository extends JpaRepository<ResourceFeature, Long> {

   List<ResourceFeature> findAllByType(PhysicalResourceType type);
}
