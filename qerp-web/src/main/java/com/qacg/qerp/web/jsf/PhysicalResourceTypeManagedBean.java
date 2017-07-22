package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.service.PhysicalResourceTypeService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name = "pRTMB")
@ViewScoped
public class PhysicalResourceTypeManagedBean {
	
	private List<PhysicalResourceTypeDto> physicals;
	private PhysicalResourceTypeDto pResource;
	private Long idPResource;
	
	
	@ManagedProperty("#{physicalResourceTypeService}")
	private PhysicalResourceTypeService pResourceTypeService;
	
	@PostConstruct
	public void init(){
		physicals = pResourceTypeService.findAll();
		pResource = new PhysicalResourceTypeDto();
		
	}

	public List<PhysicalResourceTypeDto> getPhysicals() {
		return physicals;
	}

	public void setPhysicals(List<PhysicalResourceTypeDto> physicals) {
		this.physicals = physicals;
	}

	public PhysicalResourceTypeDto getpResource() {
		return pResource;
	}

	public void setpResource(PhysicalResourceTypeDto pResource) {
		this.pResource = pResource;
	}

	public PhysicalResourceTypeService getpResourceTypeService() {
		return pResourceTypeService;
	}

	public void setpResourceTypeService(PhysicalResourceTypeService pResourceTypeService) {
		this.pResourceTypeService = pResourceTypeService;
	} 
	
	
	public Long getIdPResource() {
		return idPResource;
	}

	public void setIdPResource(Long idPResource) {
		this.idPResource = idPResource;
	}

	public void create(){
		pResource = new PhysicalResourceTypeDto();
	}
	
	public void save(){
		FacesContext ctx = FacesContext.getCurrentInstance(); 
		try {
			pResourceTypeService.save(pResource);
			physicals = pResourceTypeService.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, "delete.error"));
		}
		
	}
	
	public void delete(Long idPhysicalResource){
		FacesContext ctx = FacesContext.getCurrentInstance(); 
		try{
			pResourceTypeService.delete(idPhysicalResource);
			physicals = pResourceTypeService.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, "delete.error"));
		}
	}
	
	
}
