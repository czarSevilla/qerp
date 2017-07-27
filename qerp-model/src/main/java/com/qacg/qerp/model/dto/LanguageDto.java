package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class LanguageDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idLanguage;
	private String countryIso;
	private String langIso;
	private String nameEnUs;
	private String nameEsMx;
	
	
	public Long getIdLanguage() {
		return idLanguage;
	}
	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}
	public String getCountryIso() {
		return countryIso;
	}
	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}
	public String getLangIso() {
		return langIso;
	}
	public void setLangIso(String langIso) {
		this.langIso = langIso;
	}
	public String getNameEnUs() {
		return nameEnUs;
	}
	public void setNameEnUs(String nameEnUs) {
		this.nameEnUs = nameEnUs;
	}
	public String getNameEsMx() {
		return nameEsMx;
	}
	public void setNameEsMx(String nameEsMx) {
		this.nameEsMx = nameEsMx;
	}
	
	
}
