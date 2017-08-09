package com.qacg.qerp.service.builder;

import org.springframework.beans.BeanUtils;

import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;

public class PhysicalResourceTypeBuilder {

   public static final PhysicalResourceTypeDto build(PhysicalResourceType type){
      PhysicalResourceTypeDto typeDto = new PhysicalResourceTypeDto();
      BeanUtils.copyProperties(type, typeDto);
      return typeDto;
   }
   
   public static final PhysicalResourceType build(PhysicalResourceTypeDto typeDto){
      PhysicalResourceType type = new PhysicalResourceType();
      BeanUtils.copyProperties(typeDto, type);
      return type;
   }
}

