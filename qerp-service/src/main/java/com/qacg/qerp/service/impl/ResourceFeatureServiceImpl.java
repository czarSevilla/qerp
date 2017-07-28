package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CompanyDto;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.model.dto.LanguageDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.persistence.entity.Company;
import com.qacg.qerp.persistence.entity.Currency;
import com.qacg.qerp.persistence.entity.Language;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.entity.ResourceFeature;
import com.qacg.qerp.persistence.repository.ResourceFeatureRepository;
import com.qacg.qerp.service.ResourceFeatureService;

@Service("resourceFeatureService")
public class ResourceFeatureServiceImpl implements ResourceFeatureService {

	private ResourceFeatureRepository resourceFeatureRepository;
	
	
	@Autowired
	public void setResourceFeatureRepository(ResourceFeatureRepository resourceFeatureRepository) {
		this.resourceFeatureRepository = resourceFeatureRepository;
	}

	
	@Override
	public List<ResourceFeatureDto> findAll() {
		List<ResourceFeature> features = resourceFeatureRepository.findAll();
		List<ResourceFeatureDto> featuresDto =  new ArrayList<>();
		for(ResourceFeature feature : features){
			ResourceFeatureDto featureDto = new ResourceFeatureDto();
			PhysicalResourceTypeDto typeDto = new PhysicalResourceTypeDto();
			BeanUtils.copyProperties(feature.getType(),typeDto);
			featureDto.setIdResourceFeature(feature.getIdResourceFeature());
			featureDto.setFeatureEnUs(feature.getFeatureEnUs());
			featureDto.setFeatureEsMx(feature.getFeatureEsMx());
			featureDto.setType(typeDto);
			featuresDto.add(featureDto);
		}
		return featuresDto;
	}


	
	@Override
	public void save(ResourceFeatureDto resourceFeatureDto) throws ServiceException {
		ResourceFeature feature = new ResourceFeature();
		PhysicalResourceType type = new PhysicalResourceType();
		feature.setIdResourceFeature(resourceFeatureDto.getIdResourceFeature());
		feature.setFeatureEnUs(resourceFeatureDto.getFeatureEnUs());
		feature.setFeatureEsMx(resourceFeatureDto.getFeatureEsMx());
		BeanUtils.copyProperties(resourceFeatureDto.getType(), type);
		feature.setType(type);
		try{
			resourceFeatureRepository.save(feature);
		}catch(Exception ex){
			throw new ServiceException(ex.getMessage());
		}
	}

	@Override
	public void delete(Long idResourceFeature) throws ServiceException {
		try{
			resourceFeatureRepository.delete(idResourceFeature);
		}catch(Exception ex){
			throw new ServiceException(ex.getMessage());
		}
	}


	@Override
	public ResourceFeatureDto findOne(Long idResourceFeature) throws ServiceException {
		ResourceFeature feature = resourceFeatureRepository.findOne(idResourceFeature);
		ResourceFeatureDto featureDto = new ResourceFeatureDto();
		PhysicalResourceTypeDto typeDto = new PhysicalResourceTypeDto();
		
		BeanUtils.copyProperties(feature.getType(), typeDto);
		featureDto.setType(typeDto);
		featureDto.setIdResourceFeature(idResourceFeature);
		featureDto.setFeatureEnUs(feature.getFeatureEnUs());
		featureDto.setFeatureEsMx(feature.getFeatureEsMx());
		
		return featureDto;
	}

	

}
