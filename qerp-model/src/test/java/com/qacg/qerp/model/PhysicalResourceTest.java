package com.qacg.qerp.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;

public class PhysicalResourceTest {
   
   @Test
   public void setters(){
      PhysicalResourceDto physicalResourceDto = new PhysicalResourceDto();
      PhysicalResourceTypeDto pRType = new PhysicalResourceTypeDto();
      List<PhysicalResourceHasFeatureDto> list = new ArrayList<>();
      Date registerDate = new Date();
      
      physicalResourceDto.setpRType(pRType);
      physicalResourceDto.setFeatures(list);
      physicalResourceDto.setRegisterDate(registerDate);
      
      assertTrue(physicalResourceDto.getpRType().equals(pRType));
      assertTrue(physicalResourceDto.getFeatures().equals(list));
      assertTrue(physicalResourceDto.getRegisterDate().equals(registerDate));
   }
}
