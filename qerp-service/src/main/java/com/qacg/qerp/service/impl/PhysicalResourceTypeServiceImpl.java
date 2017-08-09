package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.repository.PhysicalResourceTypeRepository;
import com.qacg.qerp.service.PhysicalResourceTypeService;
import com.qacg.qerp.service.builder.PhysicalResourceTypeBuilder;

@Service("physicalResourceTypeService")
public class PhysicalResourceTypeServiceImpl implements PhysicalResourceTypeService {

	private PhysicalResourceTypeRepository physicalResourceTypeRepository;
	
	

	@Autowired
	public void setPhysicalResourceTypeRepository(PhysicalResourceTypeRepository physicalResourceTypeRepository) {
		this.physicalResourceTypeRepository = physicalResourceTypeRepository;
	}

	@Override
	public List<PhysicalResourceTypeDto> findAll() {
		List<PhysicalResourceType> physicalResources = physicalResourceTypeRepository.findAll();
		return physicalResources.stream().map(PhysicalResourceTypeBuilder::build).collect(Collectors.toList());
	}

	@Override
	public void save(PhysicalResourceTypeDto physicalResourceTypeDto) throws ServiceException {
		try{
			physicalResourceTypeRepository.save(PhysicalResourceTypeBuilder.build(physicalResourceTypeDto));
		}catch(Exception se){
			throw new ServiceException(se.getMessage());
		}
		

	}

	@Override
	public void delete(Long idPhysicalResourceTypeDto) throws ServiceException {
		try{
			physicalResourceTypeRepository.delete(idPhysicalResourceTypeDto);
		}catch(Exception se){
			throw new ServiceException(se.getMessage());
		}

	}




}
