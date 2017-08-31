package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.persistence.entity.PhysicalResourceHasFeature;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.entity.ResourceFeature;
import com.qacg.qerp.persistence.repository.PhysicalResourceHasFeatureRepository;
import com.qacg.qerp.persistence.repository.ResourceFeatureRepository;
import com.qacg.qerp.service.PhysicalResourceHasFeatureService;
import com.qacg.qerp.service.builder.PhysicalResourceHasFeatureBuilder;
import com.qacg.qerp.service.builder.ResourceFeatureBuilder;

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
      return hasFeatures.stream().map(PhysicalResourceHasFeatureBuilder::build).collect(Collectors.toList());
   }

   @Override
   public void save(PhysicalResourceHasFeatureDto hasFeatureDto) throws ServiceException {
      try {
         featureRepository.save(PhysicalResourceHasFeatureBuilder.build(hasFeatureDto));
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
      return PhysicalResourceHasFeatureBuilder.build(hasFeature);
   }

   @Override
   public List<ResourceFeatureDto> findByID(Long idItem) {
      List<ResourceFeatureDto> featuresDto = new ArrayList<>();
      if (idItem != null) {
         PhysicalResourceType type = new PhysicalResourceType();
         type.setIdPhysicalResourceType(idItem);

         List<ResourceFeature> features = resourceFeatureRespository.findAllByType(type);
         featuresDto = features.stream().map(ResourceFeatureBuilder::build).collect(Collectors.toList());
      }
      return featuresDto;

   }

   @Override
   public List<PhysicalResourceHasFeatureDto> findByComponent(Long idComponent) {
      System.out.println("SERVICIO DE BUSQUEDA");
      
      List<PhysicalResourceHasFeatureDto> featuresDto = new ArrayList<>();
      if (idComponent != null) {
         ResourceFeature resourceFeature = new ResourceFeature();
         resourceFeature.setIdResourceFeature(idComponent);
         List<PhysicalResourceHasFeature> features = featureRepository.findAllByResourceFeature(resourceFeature);
         int size = features.size();
         for(int count = 0; count<size;count++){
            PhysicalResourceHasFeatureDto featureDto = new PhysicalResourceHasFeatureDto();
            featureDto.setValue(features.get(count).getValue());
            featuresDto.add(featureDto);         
         }
         System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+featuresDto.size());
      }
      return featuresDto;
   }

   
   @Override
   public PhysicalResourceDto compare(PhysicalResourceDto resource, PhysicalResourceDto resourceTmp) {
      PhysicalResourceDto toSend = new PhysicalResourceDto();
      List<PhysicalResourceHasFeatureDto> aux = resource.getFeatures();
      List<PhysicalResourceHasFeatureDto> aux2 = resourceTmp.getFeatures();
      if (aux.size() >= aux2.size()) {
         toSend = resource;
      }

      else if (aux.size() < aux2.size()) {
         for (int count = 0; count < aux2.size(); count++) {
            if (count <= aux.size() - 1) {
               PhysicalResourceDto tmp = aux2.get(count).getPhysicalResource();

               aux2.get(count).setValue(aux.get(count).getValue());
               aux2.get(count).setIdPhysicalResourceHasFeature(aux.get(count).getIdPhysicalResourceHasFeature());
               aux2.get(count).setPhysicalResource(tmp);
            } else {
               aux2.get(count).setValue("N/A");

            }
         }
         toSend = resource;
         toSend.setFeatures(aux2);
      }

      return toSend;

   }

}
