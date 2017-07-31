package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CompanyDto;
import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.persistence.entity.PhysicalResource;
import com.qacg.qerp.persistence.repository.PhysicalResourceRepository;
import com.qacg.qerp.service.PhysicalResourceService;

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
      List<PhysicalResourceDto> dtos = new ArrayList<>();
      for (PhysicalResource resource : resources) {
         PhysicalResourceDto dto = new PhysicalResourceDto();
         PhysicalResourceTypeDto pRType = new PhysicalResourceTypeDto();
         CompanyDto company = new CompanyDto();
         company.setPrefix(resource.getCompany().getPrefix());
         company.setName(resource.getCompany().getName());
         pRType.setNameEnUs(resource.getpRType().getNameEnUs());
         pRType.setNameEsMx(resource.getpRType().getNameEsMx());
         pRType.setPicture(resource.getpRType().getPicture());
         dto.setCompany(company);
         dto.setIdPhysicalResource(resource.getIdPhysicalResource());
         dto.setpRType(pRType);
         dtos.add(dto);
      }
      return dtos;
   }

   @Override
   public void save(PhysicalResourceDto physicalDto) throws ServiceException {
      PhysicalResource physicalResource = new PhysicalResource();
      BeanUtils.copyProperties(physicalDto, physicalResource);
      try {
         physicalResourceRepository.save(physicalResource);
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

}
