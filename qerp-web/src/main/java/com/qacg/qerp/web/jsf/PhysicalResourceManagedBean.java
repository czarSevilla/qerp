package com.qacg.qerp.web.jsf;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceHasFeatureDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.service.PhysicalResourceService;
import com.qacg.qerp.service.PhysicalResourceTypeService;
import com.qacg.qerp.service.ResourceFeatureService;

@ManagedBean(name = "physicalRMB")
@ViewScoped
public class PhysicalResourceManagedBean {

   private List<PhysicalResourceDto>           resources;
   private PhysicalResourceDto                 resource;
   private Long                                idResource;
   private List<PhysicalResourceTypeDto>       types;
   private Long                                idType;
   private PhysicalResourceTypeDto             physicalType;
   private List<PhysicalResourceHasFeatureDto> features;
   private static final Logger                 LOG = LoggerFactory.getLogger(PhysicalResourceManagedBean.class);

   @ManagedProperty("#{physicalRService}")
   private PhysicalResourceService             pService;

   @ManagedProperty("#{physicalResourceTypeService}")
   private PhysicalResourceTypeService         tService;

   @ManagedProperty("#{resourceFeatureService}")
   private ResourceFeatureService              resourceFeatureService;

   @PostConstruct
   public void init() {
      resources = pService.findAll();
      types = tService.findAll();
   }

   public ResourceFeatureService getResourceFeatureService() {
      return resourceFeatureService;
   }

   public void setResourceFeatureService(ResourceFeatureService resourceFeatureService) {
      this.resourceFeatureService = resourceFeatureService;
   }

   public List<PhysicalResourceHasFeatureDto> getFeatures() {
      return features;
   }

   public void setFeatures(List<PhysicalResourceHasFeatureDto> features) {
      this.features = features;
   }

   public PhysicalResourceTypeDto getPhysicalType() {
      return physicalType;
   }

   public void setPhysicalType(PhysicalResourceTypeDto physicalType) {
      this.physicalType = physicalType;
   }

   public PhysicalResourceService getpService() {
      return pService;
   }

   public void setpService(PhysicalResourceService pService) {
      this.pService = pService;
   }

   public List<PhysicalResourceDto> getResources() {
      return resources;
   }

   public void setResources(List<PhysicalResourceDto> resources) {
      this.resources = resources;
   }

   public PhysicalResourceDto getResource() {
      return resource;
   }

   public void setResource(PhysicalResourceDto resource) {
      this.resource = resource;
   }

   public Long getIdResource() {
      return idResource;
   }

   public void setIdResource(Long idResource) {
      this.idResource = idResource;
   }

   public List<PhysicalResourceTypeDto> getTypes() {
      return types;
   }

   public void setTypes(List<PhysicalResourceTypeDto> types) {
      this.types = types;
   }

   public PhysicalResourceTypeService gettService() {
      return tService;
   }

   public void settService(PhysicalResourceTypeService tService) {
      this.tService = tService;
   }

   public Long getIdType() {
      return idType;
   }

   public void setIdType(Long idType) {
      this.idType = idType;
   }

   public void create() {
      try {
         resource = resourceFeatureService.findAllById(idType);
      } catch (ServiceException e) {
         LOG.error("Error at Create Method", e);
      }

   }

   public String printType(PhysicalResourceTypeDto dto) {
      Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
      String localeIso = String.format("%s_%s", locale.getLanguage(), locale.getCountry());
      String resultado;
      if ("es_MX".equals(localeIso)) {
         resultado = dto.getNameEsMx();
         return resultado;
      } else {
         resultado = dto.getNameEnUs();
         return resultado;
      }

   }

   public void save() {
      try {
         pService.save(resource);
         resources = pService.findAll();

      } catch (ServiceException se) {

      }

   }

   public void delete(Long idResource) {
      try {
         pService.delete(idResource);
         resources = pService.findAll();

      } catch (ServiceException se) {

      }

   }

}
