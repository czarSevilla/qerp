package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;

public interface PhysicalResourceTypeService {
	
	List<PhysicalResourceTypeDto> findAll();
	
	void save(PhysicalResourceTypeDto physicalResourceTypeDto ) throws ServiceException;
	
	void delete(Long idPhysicalResourceTypeDto) throws ServiceException;
	

}
