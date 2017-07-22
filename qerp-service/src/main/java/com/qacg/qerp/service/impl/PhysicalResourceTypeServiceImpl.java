package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.repository.PhysicalResourceTypeRepository;
import com.qacg.qerp.service.PhysicalResourceTypeService;

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
		List<PhysicalResourceTypeDto> dtos = new ArrayList<>() ;
		for(PhysicalResourceType type : physicalResources){
			PhysicalResourceTypeDto dto = new PhysicalResourceTypeDto();
			BeanUtils.copyProperties(type, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void save(PhysicalResourceTypeDto physicalResourceTypeDto) throws ServiceException {
		PhysicalResourceType type = new PhysicalResourceType();
		BeanUtils.copyProperties(physicalResourceTypeDto, type);
		try{
			physicalResourceTypeRepository.save(type);
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
