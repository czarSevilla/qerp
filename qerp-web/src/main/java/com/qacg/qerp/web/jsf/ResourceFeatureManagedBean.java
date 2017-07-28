package com.qacg.qerp.web.jsf;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;
import com.qacg.qerp.persistence.entity.ResourceFeature;
import com.qacg.qerp.service.PhysicalResourceTypeService;
import com.qacg.qerp.service.ResourceFeatureService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name  = "resourceFeatureMB")
@ViewScoped
public class ResourceFeatureManagedBean {
	
	private List<ResourceFeatureDto> features;
	private List<PhysicalResourceTypeDto> types;
	private ResourceFeatureDto feature;
	private Long idResourceFeature;
	private PhysicalResourceTypeDto type;
	
	@ManagedProperty("#{resourceFeatureService}")
	ResourceFeatureService service;
	
	@ManagedProperty("#{physicalResourceTypeService}")
	PhysicalResourceTypeService typeService;
	
	@PostConstruct
	public void init (){
		types = typeService.findAll();
		features = service.findAll();
		
	}

	public List<ResourceFeatureDto> getFeatures() {
		return features;
	}

	public void setFeatures(List<ResourceFeatureDto> features) {
		this.features = features;
	}

	public ResourceFeatureDto getFeature() {
		return feature;
	}

	public void setFeature(ResourceFeatureDto feature) {
		this.feature = feature;
	}

	public Long getIdResourceFeature() {
		return idResourceFeature;
	}

	public void setIdResourceFeature(Long idResourceFeature) {
		this.idResourceFeature = idResourceFeature;
	}
	
	public List<PhysicalResourceTypeDto> getTypes() {
		return types;
	}

	public void setTypes(List<PhysicalResourceTypeDto> types) {
		this.types = types;
	}

	public PhysicalResourceTypeDto getType() {
		return type;
	}

	public void setType(PhysicalResourceTypeDto type) {
		this.type = type;
	}

	public ResourceFeatureService getService() {
		return service;
	}

	public void setService(ResourceFeatureService service) {
		this.service = service;
	}

	public PhysicalResourceTypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(PhysicalResourceTypeService typeService) {
		this.typeService = typeService;
	}

	public void create(){
		feature = new ResourceFeatureDto();
		type = new PhysicalResourceTypeDto();
		feature.setType(type);

	}
	
	public void save(){

		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			service.save(feature);
			features = service.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
		
	}
	
	
	public void findOne(Long idResourceFeature){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			feature = service.findOne(idResourceFeature);
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));

	}
		
		
	}
	
	public void delete(Long idResourceFeature){
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			service.delete(idResourceFeature);
			features = service.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
	}
	
	public String printFeature(ResourceFeature dto){
    	Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    	String localeIso = String.format("%s_%s", locale.getLanguage(), locale.getCountry());
    	if ("es_MX".equals(localeIso)) {
    		return dto.getFeatureEsMx();
    	} else {
    		return dto.getFeatureEnUs();
    	}

	}
}
