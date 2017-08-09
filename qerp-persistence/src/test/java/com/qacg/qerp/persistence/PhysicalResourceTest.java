package com.qacg.qerp.persistence;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.qacg.qerp.persistence.entity.PhysicalResource;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;

public class PhysicalResourceTest {

   @Test
   public void setters(){
      PhysicalResource physicalResource = new PhysicalResource();
      PhysicalResourceType type = new PhysicalResourceType();
      Long idCompany = 1L;
      Date registerDate = new Date();
      
      physicalResource.setpRType(type);
      physicalResource.setIdCompany(idCompany);
      physicalResource.setRegisterDate(registerDate);
      
      assertTrue(physicalResource.getpRType().equals(type));
      assertTrue(physicalResource.getIdCompany().equals(idCompany));
      assertTrue(physicalResource.getRegisterDate().equals(registerDate));
   } 
}
