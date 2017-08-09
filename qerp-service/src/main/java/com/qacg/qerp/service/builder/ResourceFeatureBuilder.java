package com.qacg.qerp.service.builder;

import org.springframework.beans.BeanUtils;

import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.entity.ResourceFeature;

public class ResourceFeatureBuilder {
   
   private ResourceFeatureBuilder(){
      /*The Method is private because it uses Util package*/
   }
   
   public static final ResourceFeatureDto build(ResourceFeature resource){
      ResourceFeatureDto resourceDto = new ResourceFeatureDto();
      PhysicalResourceTypeDto typeDto = new PhysicalResourceTypeDto();
      BeanUtils.copyProperties(resource.getType(), typeDto);
      BeanUtils.copyProperties(resource, resourceDto);
      resourceDto.setType(typeDto);
      
      return resourceDto;
   }

   
   public static final ResourceFeature build(ResourceFeatureDto resourceDto){
      ResourceFeature resource = new ResourceFeature();
      PhysicalResourceType type = new PhysicalResourceType();
      BeanUtils.copyProperties(resourceDto.getType(), type);
      BeanUtils.copyProperties(resourceDto, resource);
      resource.setType(type);
      
      return resource;
   }

   
}
