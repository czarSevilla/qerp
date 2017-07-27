package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceDto;


public interface PhysicalResourceService {

	List<PhysicalResourceDto> findAll();
	
	void save(PhysicalResourceDto physicalDto) throws ServiceException;
	
	void delete(Long idResource) throws ServiceException;
	
	
}
