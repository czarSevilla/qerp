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
        //PhysicalResourceDto pRDto =  new PhysicalResourceDto();//
        BeanUtils.copyProperties(a.getResourceFeature(), resourceFeatureDto);
        BeanUtils.copyProperties(a, featureDto);
        //BeanUtils.copyProperties(a.getPhysicalResource(), pRDto);//
        //featureDto.setPhysicalResource(pRDto);//
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
     resource.setpRType(type);
     BeanUtils.copyProperties(resourceDto, resource);
     for(PhysicalResourceHasFeatureDto a : resourceDto.getFeatures()){
        PhysicalResourceHasFeature feature = new PhysicalResourceHasFeature();
        //PhysicalResource pResource =  new PhysicalResource();//
        ResourceFeature resourceFeature = new ResourceFeature();
        BeanUtils.copyProperties(a.getResourceFeature(), resourceFeature);
        BeanUtils.copyProperties(a, feature);
        //BeanUtils.copyProperties(a.getPhysicalResource(), pResource);//
        //feature.setPhysicalResource(pResource);//
        feature.setResourceFeature(resourceFeature);
        feature.setPhysicalResource(resource);
        features.add(feature);
     }

     resource.setFeatures(features);
 
     return resource;
  }
}
