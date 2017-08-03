package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;


public interface PhysicalResourceService {

	List<PhysicalResourceDto> findAll();
	
	List<PhysicalResourceDto> search(Long idType, String value);
	
	void save(PhysicalResourceDto physicalDto) throws ServiceException;
	
	void delete(Long idResource) throws ServiceException;

	List<PhysicalResourceDto> findAllByType(Long idType);
	
	List<PhysicalResourceDto> findAllByFeature(Long idType, String value);
}
