package com.qacg.qerp.service.builder;

import org.springframework.beans.BeanUtils;

import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.persistence.entity.PhysicalResource;
import com.qacg.qerp.persistence.entity.PhysicalResourceHasFeature;
import com.qacg.qerp.persistence.entity.ResourceFeature;

public class PhysicalResourceHasFeatureBuilder {

   private PhysicalResourceHasFeatureBuilder(){
      
      /*The method has the attribute private because it's an util class*/
   }

   
   
   public static final PhysicalResourceHasFeatureDto build(PhysicalResourceHasFeature resource){
      PhysicalResourceHasFeatureDto resourceDto = new PhysicalResourceHasFeatureDto();
      ResourceFeatureDto resourceFeatureDto = new ResourceFeatureDto();
      PhysicalResourceDto physicalResourceDto = new PhysicalResourceDto();
      BeanUtils.copyProperties(resource, physicalResourceDto);
      BeanUtils.copyProperties(resource.getResourceFeature(),resourceFeatureDto);
      BeanUtils.copyProperties(resource, resourceDto);
      resourceDto.setPhysicalResource(physicalResourceDto);
      resourceDto.setResourceFeature(resourceFeatureDto);
      return resourceDto;
   }
   
   public static final PhysicalResourceHasFeature build(PhysicalResourceHasFeatureDto resourceDto){
      PhysicalResourceHasFeature resource = new PhysicalResourceHasFeature();
      ResourceFeature resourceFeature = new ResourceFeature();
      PhysicalResource physicalResource = new PhysicalResource();
      BeanUtils.copyProperties(resourceDto.getPhysicalResource(),physicalResource);
      BeanUtils.copyProperties(resource.getResourceFeature(),resourceFeature);
      BeanUtils.copyProperties(resource, resource);
      resource.setPhysicalResource(physicalResource);
      resource.setResourceFeature(resourceFeature);
      return resource;
   }
 
   
   
   
}
