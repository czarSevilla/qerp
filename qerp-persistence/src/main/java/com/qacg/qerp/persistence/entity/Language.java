package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idLanguage;
	private String countryIso;
	private String langIso;
	private String nameEnUs;
	private String nameEsMx;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_language")
	public Long getIdLanguage() {
		return idLanguage;
	}
	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}
	
	@Column(name = "country_iso", nullable = false)
	public String getCountryIso() {
		return countryIso;
	}
	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}
	
	@Column(name = "lang_iso" , nullable = false)
	public String getLangIso() {
		return langIso;
	}
	public void setLangIso(String langIso) {
		this.langIso = langIso;
	}
	
	@Column(name =  "name_en_us", nullable = false)
	public String getNameEnUs() {
		return nameEnUs;
	}
	public void setNameEnUs(String nameEnUs) {
		this.nameEnUs = nameEnUs;
	}
	
	@Column(name = "name_es_mx", nullable = false)
	public String getNameEsMx() {
		return nameEsMx;
	}
	public void setNameEsMx(String nameEsMx) {
		this.nameEsMx = nameEsMx;
	}

}
