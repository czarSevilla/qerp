package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.persistence.entity.PhysicalResource;
import com.qacg.qerp.persistence.entity.PhysicalResourceHasFeature;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.entity.ResourceFeature;
import com.qacg.qerp.persistence.repository.PhysicalResourceHasFeatureRepository;
import com.qacg.qerp.persistence.repository.ResourceFeatureRepository;
import com.qacg.qerp.service.PhysicalResourceHasFeatureService;

@Service("hasFeatureService")
public class PhysicalResourceHasFeatureServiceImpl implements PhysicalResourceHasFeatureService {

   private PhysicalResourceHasFeatureRepository featureRepository;
   private ResourceFeatureRepository            resourceFeatureRespository;

   @Autowired
   public void setResourceFeatureRespository(ResourceFeatureRepository resourceFeatureRespository) {
      this.resourceFeatureRespository = resourceFeatureRespository;
   }

   @Autowired
   public void setFeatureRepository(PhysicalResourceHasFeatureRepository featureRepository) {
      this.featureRepository = featureRepository;
   }

   @Override
   public List<PhysicalResourceHasFeatureDto> findAll() {
      List<PhysicalResourceHasFeature> hasFeatures = featureRepository.findAll();
      List<PhysicalResourceHasFeatureDto> hasFeauresDto = new ArrayList<>();

      for (PhysicalResourceHasFeature hasFeature : hasFeatures) {
         PhysicalResourceHasFeatureDto hasFeatureDto = new PhysicalResourceHasFeatureDto();
         ResourceFeatureDto resourceFeatureDto = new ResourceFeatureDto();
         PhysicalResourceDto physicalResourceDto = new PhysicalResourceDto();

         BeanUtils.copyProperties(hasFeature.getPhysicalResource(), physicalResourceDto);
         BeanUtils.copyProperties(hasFeature.getResourceFeature(), resourceFeatureDto);
         hasFeatureDto.setIdPhysicalResourceHasFeature(hasFeature.getIdPhysicalResourceHasFeature());
         hasFeatureDto.setValue(hasFeature.getValue());
         hasFeatureDto.setPhysicalResource(physicalResourceDto);
         hasFeatureDto.setResourceFeature(resourceFeatureDto);
         hasFeauresDto.add(hasFeatureDto);

      }
      return hasFeauresDto;
   }

   @Override
   public void save(PhysicalResourceHasFeatureDto hasFeatureDto) throws ServiceException {
      PhysicalResourceHasFeature hasFeature = new PhysicalResourceHasFeature();
      PhysicalResource physicalResource = new PhysicalResource();
      ResourceFeature resourceFeature = new ResourceFeature();

      BeanUtils.copyProperties(hasFeatureDto.getPhysicalResource(), physicalResource);
      BeanUtils.copyProperties(hasFeatureDto.getResourceFeature(), resourceFeature);
      hasFeature.setIdPhysicalResourceHasFeature(hasFeatureDto.getIdPhysicalResourceHasFeature());
      hasFeature.setValue(hasFeatureDto.getValue());
      hasFeature.setPhysicalResource(physicalResource);
      hasFeature.setResourceFeature(resourceFeature);

      try {
         featureRepository.save(hasFeature);
      } catch (Exception ex) {
         throw new ServiceException(ex.getMessage());
      }

   }

   @Override
   public void delete(Long idHasFeature) throws ServiceException {
      try {
         featureRepository.delete(idHasFeature);
      } catch (Exception ex) {
         throw new ServiceException(ex.getMessage());
      }
   }

   @Override
   public PhysicalResourceHasFeatureDto findOne(Long idHasFeature) throws ServiceException {

      PhysicalResourceHasFeature hasFeature = featureRepository.findOne(idHasFeature);
      PhysicalResourceHasFeatureDto hasFeatureDto = new PhysicalResourceHasFeatureDto();
      PhysicalResourceDto physicalResourceDto = new PhysicalResourceDto();
      ResourceFeatureDto resourceFeatureDto = new ResourceFeatureDto();

      BeanUtils.copyProperties(hasFeature.getPhysicalResource(), physicalResourceDto);
      BeanUtils.copyProperties(hasFeature.getResourceFeature(), resourceFeatureDto);
      hasFeatureDto.setIdPhysicalResourceHasFeature(idHasFeature);
      hasFeatureDto.setValue(hasFeature.getValue());
      hasFeatureDto.setPhysicalResource(physicalResourceDto);
      hasFeatureDto.setResourceFeature(resourceFeatureDto);

      return hasFeatureDto;
   }

   @Override
   public List<ResourceFeatureDto> findByID(Long idItem) {
      List<ResourceFeatureDto> featuresDto = new ArrayList<>();
      if(idItem!=null){
      PhysicalResourceType type = new PhysicalResourceType();
      type.setIdPhysicalResourceType(idItem);

      List<ResourceFeature> features = resourceFeatureRespository.findAllByType(type);
      for(ResourceFeature feature : features){
           ResourceFeatureDto featureDto = new ResourceFeatureDto();
           BeanUtils.copyProperties(feature, featureDto);
           featuresDto.add(featureDto);
      }
      }
      return featuresDto;
   }

   @Override
   public List<PhysicalResourceHasFeatureDto> findByComponent(Long idComponent) {
      List<PhysicalResourceHasFeatureDto> featuresDto = new ArrayList<>();
      if(idComponent!=null){
         ResourceFeature resourceFeature = new ResourceFeature();
         resourceFeature.setIdResourceFeature(idComponent);
         List<PhysicalResourceHasFeature> features = featureRepository.findAllByResourceFeature(resourceFeature);
         for(PhysicalResourceHasFeature a : features){
            PhysicalResourceHasFeatureDto featureDto = new PhysicalResourceHasFeatureDto();
            BeanUtils.copyProperties(a, featureDto);
            featuresDto.add(featureDto);
            
         }
         
      }
      return featuresDto;
   }

   @Override
   public PhysicalResourceDto compare(PhysicalResourceDto resource, PhysicalResourceDto resourceTmp) {
      PhysicalResourceDto toSend = new PhysicalResourceDto();
      List<PhysicalResourceHasFeatureDto> aux =resource.getFeatures();
      List<PhysicalResourceHasFeatureDto> aux2 =resourceTmp.getFeatures();  
      if(aux.size()>aux2.size()){
         toSend=resource;
      }
      
      else if(aux.size()<aux2.size()){
         for(int count = 0 ; count<aux2.size();count++){
            if(count<=aux.size()-1){
               PhysicalResourceDto tmp = new PhysicalResourceDto();
               
               tmp = aux2.get(count).getPhysicalResource();
               aux2.get(count).setValue(aux.get(count).getValue());
               aux2.get(count).setIdPhysicalResourceHasFeature(aux.get(count).getIdPhysicalResourceHasFeature());
               aux2.get(count).setPhysicalResource(tmp);
            }
            else{
               aux2.get(count).setValue("N/A");
               
            }
         }
          
      }
      toSend = resource;
      toSend.setFeatures(aux2);   
      return toSend;
      
      
      
   }

}
