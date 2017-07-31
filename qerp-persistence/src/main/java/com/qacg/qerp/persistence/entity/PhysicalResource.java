package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "physical_resource")
public class PhysicalResource implements Serializable {
   /**
    * 
    */
   private static final long    serialVersionUID = 1L;

   private Long                 idPhysicalResource;
   private PhysicalResourceType pRType;
   private Company              company;

   @Id
   @Column(name = "id_physical_resource")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long getIdPhysicalResource() {
      return idPhysicalResource;
   }

   public void setIdPhysicalResource(Long idPhysicalResource) {
      this.idPhysicalResource = idPhysicalResource;
   }

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_physical_resource_type")
   public PhysicalResourceType getpRType() {
      return pRType;
   }

   public void setpRType(PhysicalResourceType pRType) {
      this.pRType = pRType;
   }

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_company")
   public Company getCompany() {
      return company;
   }

   public void setCompany(Company company) {
      this.company = company;
   }

}
