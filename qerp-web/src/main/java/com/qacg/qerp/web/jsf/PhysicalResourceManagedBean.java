package com.qacg.qerp.web.jsf;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.service.PhysicalResourceService;

@ManagedBean(name = "physicalRMB")
@ViewScoped
public class PhysicalResourceManagedBean {

   private List<PhysicalResourceDto> resources;
   private PhysicalResourceDto       resource;
   private Long                      idResource;

   @ManagedProperty("#{physicalRService}")
   private PhysicalResourceService   pService;

   @PostConstruct
   public void init() {
      resources = pService.findAll();
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

}
