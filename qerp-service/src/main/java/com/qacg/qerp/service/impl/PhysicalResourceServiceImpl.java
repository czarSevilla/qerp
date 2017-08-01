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
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.persistence.entity.PhysicalResource;
import com.qacg.qerp.persistence.entity.PhysicalResourceHasFeature;
import com.qacg.qerp.persistence.entity.ResourceFeature;
import com.qacg.qerp.persistence.repository.PhysicalResourceRepository;
import com.qacg.qerp.persistence.repository.PhysicalResourceTypeRepository;
import com.qacg.qerp.service.PhysicalResourceService;

@Service("physicalRService")
public class PhysicalResourceServiceImpl implements PhysicalResourceService {

	private PhysicalResourceRepository physicalResourceRepository;
	private PhysicalResourceTypeRepository physicalResourceTypeRepository;
	

	
	
	@Autowired
	public void setPhysicalResourceTypeRepository(PhysicalResourceTypeRepository physicalResourceTypeRepository) {
		this.physicalResourceTypeRepository = physicalResourceTypeRepository;
	}



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
			dto.setFeatures(new ArrayList<>());
			for(PhysicalResourceHasFeature feature : resource.getFeatures()){
				PhysicalResourceHasFeatureDto featureDto = new PhysicalResourceHasFeatureDto();
				ResourceFeatureDto resourceFeatureDto = new ResourceFeatureDto();
				BeanUtils.copyProperties(feature, featureDto);
				BeanUtils.copyProperties(feature.getResourceFeature(),resourceFeatureDto);
				featureDto.setResourceFeature(resourceFeatureDto);
				dto.getFeatures().add(featureDto);
				
			}
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
		List<PhysicalResourceHasFeature> features = new ArrayList<>();
		for(PhysicalResourceHasFeatureDto featureItem : physicalDto.getFeatures()){
			PhysicalResourceHasFeature item = new  PhysicalResourceHasFeature();
			ResourceFeature resourceFeature = new ResourceFeature();
			BeanUtils.copyProperties(featureItem.getResourceFeature(), resourceFeature);
			BeanUtils.copyProperties(featureItem, item);
			item.setResourceFeature(resourceFeature);
			features.add(item);
		}
		physicalResource.setFeatures(features);
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


/*
	@Override
	public List<PhysicalResourceHasFeatureDto> findAllFeatures(Long idPhysicalResource) {
		List<PhysicalResourceHasFeatureDto> featuresDto = new ArrayList<>();
		List<PhysicalResourceHasFeature> features = new ArrayList<>();
		for(PhysicalResourceHasFeature feature : features){
			PhysicalResourceHasFeatureDto featureDto = new PhysicalResourceHasFeatureDto();
			ResourceFeatureDto resourceFeatureDTo = new ResourceFeatureDto();
			
		}
		return null;
	}*/


	
	
}
