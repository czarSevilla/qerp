package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.persistence.entity.PhysicalResource;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.repository.PhysicalResourceRepository;
import com.qacg.qerp.service.PhysicalResourceService;
import com.qacg.qerp.service.builder.PhysicalResourceBuilder;

@Service("physicalRService")
public class PhysicalResourceServiceImpl implements PhysicalResourceService {

	private PhysicalResourceRepository physicalResourceRepository;

	


	@Autowired
	public void setPhysicalResourceRepository(PhysicalResourceRepository physicalResourceRepository) {
		this.physicalResourceRepository = physicalResourceRepository;
	}
	
	
	@Override
	public List<PhysicalResourceDto> findAll() {
		List<PhysicalResource> resources = physicalResourceRepository.findAll();
		return resources.stream().map(PhysicalResourceBuilder::build).collect(Collectors.toList());
	}

	@Override
	public void save(PhysicalResourceDto physicalDto) throws ServiceException {
		PhysicalResource physicalResource = new PhysicalResource();
		PhysicalResourceType type = new PhysicalResourceType();
		PhysicalResourceTypeDto typeDto = new PhysicalResourceTypeDto();
		BeanUtils.copyProperties(physicalDto.getpRType(), type);
		Long idType= physicalDto.getIdPhysicalResource();
		if(null==physicalDto.getpRType().getIdPhysicalResourceType()){
		   physicalResource = physicalResourceRepository.findOne(idType);
		   typeDto.setIdPhysicalResourceType(physicalResource.getpRType().getIdPhysicalResourceType());
	        physicalDto.setpRType(typeDto);
		}
		physicalDto.setIdCompany(1L);
		try {
		   physicalResourceRepository.save(PhysicalResourceBuilder.build(physicalDto));
		} catch (DataAccessException ex) {
			throw new ServiceException(ex.getMessage());
		}

	}

	@Override
	public void delete(Long idResource) throws ServiceException {
		try {
			physicalResourceRepository.delete(idResource);
		} catch (DataAccessException ex) {
			throw new ServiceException(ex.getMessage());
			
		}
		
	}


   @Override
   public List<PhysicalResourceDto> search(Long idType, String value) {
      List<PhysicalResourceDto> data = new ArrayList<>();
      if(!idType.toString().equals("0")){
          if(!"0".equals(value)){
             data = findAllByFeature(idType , value);

          }
          else{
             data = findAllByType(idType);

          }
          return data;
       }
       else{
          return findAll();
       }
      
   }


   @Override
   public List<PhysicalResourceDto> findAllByType(Long idType) {

      PhysicalResourceType type = new PhysicalResourceType();
      type.setIdPhysicalResourceType(idType);
      List<PhysicalResource> resources = physicalResourceRepository.findAllByPRType(type);
  
      return resources.stream().map(PhysicalResourceBuilder::build).collect(Collectors.toList());
   }


   @Override
   public List<PhysicalResourceDto> findAllByFeature(Long idType, String value) {
      List<PhysicalResource> resources =  physicalResourceRepository.findAllByFeature(idType, value);
      return resources.stream().map(PhysicalResourceBuilder::build).collect(Collectors.toList());
   }

	
}
