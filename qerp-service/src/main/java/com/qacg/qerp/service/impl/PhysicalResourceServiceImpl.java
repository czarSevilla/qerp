package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
         PhysicalResource p = new PhysicalResource();
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
		else{
               physicalDto.setRegisterDate(new Date());

		}
		physicalDto.setIdCompany(1L);
		try {
		   p = PhysicalResourceBuilder.build(physicalDto);
		   physicalResourceRepository.save(p);
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
      List<PhysicalResourceDto> data;
      if (!idType.toString().equals("0")) {
         if (null != value) {
            data = findAllByFeature(idType, value);

         } else {
            data = findAllByType(idType);

         }
         return data;
      } else {
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
      List<PhysicalResource> resources = physicalResourceRepository.findAllByFeature(idType, value);
      Set<PhysicalResource> tmp = new HashSet<>(resources);
      resources = new ArrayList<>(tmp); 
      return resources.stream().map(PhysicalResourceBuilder::build).collect(Collectors.toList());
   }

   @Override
   public PhysicalResourceDto findOne(Long idPhysicalResource) {
      PhysicalResource physicalResource;
      physicalResource = physicalResourceRepository.findOne(idPhysicalResource);
      return PhysicalResourceBuilder.build(physicalResource);
   }

   
}
