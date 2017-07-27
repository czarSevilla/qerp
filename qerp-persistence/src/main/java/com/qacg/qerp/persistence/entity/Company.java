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
@Table(name = "company")
public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long idCompany;
	//private Long idCurrency;
	private Currency currency;
	private Language language;
	//private Long idLanguage;
	private String name;
	private String prefix;
	
	@Id
	@Column(name = "id_company")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_currency", referencedColumnName = "id_currency")
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	
	
	
	
	/*@Column(name = "id_language", nullable =  false)
	public Long getIdLanguage() {
		return idLanguage;
	}
	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}*/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_language", referencedColumnName = "id_language" )
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "prefix", nullable = false)
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	

}
