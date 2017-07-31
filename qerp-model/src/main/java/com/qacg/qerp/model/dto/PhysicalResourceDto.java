package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class PhysicalResourceDto implements Serializable {
   /**
    * 
    */
   private static final long       serialVersionUID = 1L;

   private Long                    idPhysicalResource;

   private CompanyDto              company;

   private PhysicalResourceTypeDto pRType;

   public Long getIdPhysicalResource() {
      return idPhysicalResource;
   }

   public void setIdPhysicalResource(Long idPhysicalResource) {
      this.idPhysicalResource = idPhysicalResource;
   }

   public PhysicalResourceTypeDto getpRType() {
      return pRType;
   }

   public void setpRType(PhysicalResourceTypeDto pRType) {
      this.pRType = pRType;
   }

   public CompanyDto getCompany() {
      return company;
   }

   public void setCompany(CompanyDto company) {
      this.company = company;
   }

}
