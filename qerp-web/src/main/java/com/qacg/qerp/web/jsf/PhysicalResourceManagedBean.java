package com.qacg.qerp.web.jsf;

import java.util.ArrayList;
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
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.service.PhysicalResourceHasFeatureService;
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
   private List<ResourceFeatureDto>            features;
   private Long                                typeItem;
   private List<PhysicalResourceHasFeatureDto> values;
   private Long                                typeComponent;
   private String                               value;
   private static final Logger                 LOG = LoggerFactory.getLogger(PhysicalResourceManagedBean.class);

   @ManagedProperty("#{physicalRService}")
   private PhysicalResourceService             pService;

   @ManagedProperty("#{physicalResourceTypeService}")
   private PhysicalResourceTypeService         tService;

   @ManagedProperty("#{resourceFeatureService}")
   private ResourceFeatureService              resourceFeatureService;

   @ManagedProperty("#{hasFeatureService}")
   private PhysicalResourceHasFeatureService   featureService;

   @PostConstruct
   public void init() {
      resources = pService.findAll();
      types = tService.findAll();
   }

   
   


   public String getValue() {
      return value;
   }





   public void setValue(String value) {
      this.value = value;
   }





   public Long getTypeComponent() {
      return typeComponent;
   }

   public void setTypeComponent(Long typeComponent) {
      this.typeComponent = typeComponent;
   }

   public List<PhysicalResourceHasFeatureDto> getValues() {
      return values;
   }

   public void setValues(List<PhysicalResourceHasFeatureDto> values) {
      this.values = values;
   }

   public PhysicalResourceHasFeatureService getFeatureService() {
      return featureService;
   }

   public void setFeatureService(PhysicalResourceHasFeatureService featureService) {
      this.featureService = featureService;
   }

   public ResourceFeatureService getResourceFeatureService() {
      return resourceFeatureService;
   }

   public void setResourceFeatureService(ResourceFeatureService resourceFeatureService) {
      this.resourceFeatureService = resourceFeatureService;
   }

   public List<ResourceFeatureDto> getFeatures() {
      return features;
   }

   public void setFeatures(List<ResourceFeatureDto> features) {
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

   public Long getTypeItem() {
      return typeItem;
   }

   public void setTypeItem(Long typeItem) {
      this.typeItem = typeItem;
   }

   
   
   public void getTypeResource() {
      if(!typeItem.toString().equals("0")){
      typeComponent = null;
      value = null;
      features = featureService.findByID(typeItem);
      }
      else{

         features = new ArrayList<>();
         values = new ArrayList<>();
      }
   }

   public void getComponentValue() {

      values = featureService.findByComponent(typeComponent);
   }

   public void search(){
      resources = pService.search(typeItem, value);
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
