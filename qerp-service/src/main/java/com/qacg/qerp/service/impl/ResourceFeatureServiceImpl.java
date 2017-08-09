package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.entity.ResourceFeature;
import com.qacg.qerp.persistence.repository.ResourceFeatureRepository;
import com.qacg.qerp.service.ResourceFeatureService;
import com.qacg.qerp.service.builder.ResourceFeatureBuilder;

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

      return features.stream().map(ResourceFeatureBuilder::build).collect(Collectors.toList());
   }

   @Override
   public void save(ResourceFeatureDto resourceFeatureDto) throws ServiceException {

      try {
         resourceFeatureRepository.save(ResourceFeatureBuilder.build(resourceFeatureDto));
      } catch (Exception ex) {
         throw new ServiceException(ex.getMessage());
      }
   }

   @Override
   public void delete(Long idResourceFeature) throws ServiceException {
      try {
         resourceFeatureRepository.delete(idResourceFeature);
      } catch (Exception ex) {
         throw new ServiceException(ex.getMessage());
      }
   }

   @Override
   public ResourceFeatureDto findOne(Long idResourceFeature) throws ServiceException {
      ResourceFeature feature = resourceFeatureRepository.findOne(idResourceFeature);
      return ResourceFeatureBuilder.build(feature);
   }

   @Override
   public PhysicalResourceDto findAllById(Long idType) throws ServiceException {
      PhysicalResourceDto physicalResource = new PhysicalResourceDto();
      PhysicalResourceType type = new PhysicalResourceType();
      PhysicalResourceTypeDto typeDto = new PhysicalResourceTypeDto();
      type.setIdPhysicalResourceType(idType);
      List<PhysicalResourceHasFeatureDto> featuresDto = new ArrayList<>();
      List<ResourceFeature> features = resourceFeatureRepository.findAllByType(type);
      
      BeanUtils.copyProperties(type, typeDto);
      for(ResourceFeature feature : features){
         ResourceFeatureDto featureDTo = new ResourceFeatureDto();
         PhysicalResourceHasFeatureDto hasFeatureDto= new PhysicalResourceHasFeatureDto();
         BeanUtils.copyProperties(feature, featureDTo);
         hasFeatureDto.setResourceFeature(featureDTo);
         featuresDto.add(hasFeatureDto);
      }
      physicalResource.setpRType(typeDto);
      physicalResource.setFeatures(featuresDto);
      return physicalResource;
   }

}
