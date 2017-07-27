package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.LanguageDto;
import com.qacg.qerp.service.LanguageService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name = "languageMB")
@ViewScoped
public class LanguageManagedBean {
	private List<LanguageDto> languages;
	private LanguageDto language;
	private Long idLanguage;
	
	@ManagedProperty("#{languageService}")
	private LanguageService service;

	public LanguageService getService() {
		return service;
	}

	public void setService(LanguageService service) {
		this.service = service;
	}

	
	@PostConstruct
	public void init(){
		languages = service.findAll();
		language = new LanguageDto();
	}
	
	public void create(){
		language = new LanguageDto();
		
	}
	public List<LanguageDto> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageDto> languages) {
		this.languages = languages;
	}

	public LanguageDto getLanguage() {
		return language;
	}

	public void setLanguage(LanguageDto language) {
		this.language = language;
	}

	public Long getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}

	public void save(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			service.save(language);
			languages = service.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
		
	}
	
	public void delete(Long idLanguage){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			service.delete(idLanguage);
			languages = service.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
	}

}


