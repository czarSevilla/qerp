package com.qacg.qerp.service.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.persistence.entity.PhysicalResource;
import com.qacg.qerp.persistence.entity.PhysicalResourceHasFeature;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.entity.ResourceFeature;

public class PhysicalResourceBuilder {
   
   private PhysicalResourceBuilder(){
     /*The method has the attribute private 'cause it´s an util Class*/
   }
  

  public static final PhysicalResourceDto build(PhysicalResource resource){
     PhysicalResourceDto  resourceDto = new PhysicalResourceDto();
     PhysicalResourceTypeDto typeDto = new PhysicalResourceTypeDto();
     List<PhysicalResourceHasFeatureDto> featuresDto = new ArrayList<>();
     BeanUtils.copyProperties(resource.getpRType(), typeDto);
     BeanUtils.copyProperties(resource, resourceDto);
     
     for(PhysicalResourceHasFeature a : resource.getFeatures()){
        PhysicalResourceHasFeatureDto featureDto = new PhysicalResourceHasFeatureDto();
        ResourceFeatureDto resourceFeatureDto = new ResourceFeatureDto();
        BeanUtils.copyProperties(a.getResourceFeature(), resourceFeatureDto);
        BeanUtils.copyProperties(a, featureDto);
        featureDto.setPhysicalResource(resourceDto);
        featureDto.setResourceFeature(resourceFeatureDto);
        featuresDto.add(featureDto);
     }
     resourceDto.setFeatures(featuresDto);
     resourceDto.setpRType(typeDto);
     return resourceDto;
  }
  
  public static final PhysicalResource build(PhysicalResourceDto resourceDto){
     PhysicalResource  resource = new PhysicalResource();
     PhysicalResourceType type = new PhysicalResourceType();
     List<PhysicalResourceHasFeature> features = new ArrayList<>();
     BeanUtils.copyProperties(resourceDto.getpRType(), type);
     BeanUtils.copyProperties(resourceDto, resource);
     
     for(PhysicalResourceHasFeatureDto a : resourceDto.getFeatures()){
        PhysicalResourceHasFeature feature = new PhysicalResourceHasFeature();
        ResourceFeature resourceFeature = new ResourceFeature();
        BeanUtils.copyProperties(a.getResourceFeature(), resourceFeature);
        System.out.println("valor "+ a.getResourceFeature().getIdResourceFeature());
        BeanUtils.copyProperties(a, feature);
        feature.setResourceFeature(resourceFeature);
        feature.setPhysicalResource(resource);
        features.add(feature);
     }
     resource.setFeatures(features);
     resource.setpRType(type);
     return resource;
  }
}
