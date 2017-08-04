package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;

public interface PhysicalResourceHasFeatureService {
	
	List<PhysicalResourceHasFeatureDto> findAll();
	
	void save(PhysicalResourceHasFeatureDto physicalResourceHasFeatureDto) throws ServiceException;
	
	void delete(Long idPhysicalResourceHasFeature) throws ServiceException;
	
	PhysicalResourceHasFeatureDto findOne(Long idPhysicalResourceHasFeature) throws ServiceException;

	List<ResourceFeatureDto> findByID(Long idItem);
	
	List<PhysicalResourceHasFeatureDto> findByComponent(Long idComponent);

   PhysicalResourceDto compare(PhysicalResourceDto resource, PhysicalResourceDto resourceTmp);
}
 