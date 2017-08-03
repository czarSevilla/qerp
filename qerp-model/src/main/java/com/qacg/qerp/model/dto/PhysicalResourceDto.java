package com.qacg.qerp.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhysicalResourceDto implements Serializable {
   /**
    * 
    */
   private static final long                   serialVersionUID = 1L;

   private Long                                idPhysicalResource;

   private Long                                idCompany;

   private PhysicalResourceTypeDto             pRType;
   private List<PhysicalResourceHasFeatureDto> features;

   public PhysicalResourceDto() {
      pRType = new PhysicalResourceTypeDto();
      features = new ArrayList<>();

   }

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

   public Long getIdCompany() {
      return idCompany;
   }

   public void setIdCompany(Long idCompany) {
      this.idCompany = idCompany;
   }

   public List<PhysicalResourceHasFeatureDto> getFeatures() {
      return features;
   }

   public void setFeatures(List<PhysicalResourceHasFeatureDto> features) {
      this.features = features;
   }

}
