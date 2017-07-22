package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idCurrency;
	private String currencyIso;
	private String nameEsMx;
	private String nameEnUs;
	
	@Id
	@Column(name = "id_currency")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdCurrency() {
		return idCurrency;
	}
	public void setIdCurrency(Long idCurrency) {
		this.idCurrency = idCurrency;
	}
	
	@Column(name = "currency_iso", nullable = false)
	public String getCurrencyIso() {
		return currencyIso;
	}
	public void setCurrencyIso(String currencyIso) {
		this.currencyIso = currencyIso;
	}
	
	@Column(name = "name_es_mx", nullable =  false)
	public String getNameEsMx() {
		return nameEsMx;
	}
	public void setNameEsMx(String nameEsMx) {
		this.nameEsMx = nameEsMx;
	}
	
	@Column(name = "name_en_us", nullable = false)
	public String getNameEnUs() {
		return nameEnUs;
	}
	public void setNameEnUs(String nameEnUs) {
		this.nameEnUs = nameEnUs;
	}
	
	
	
	

}
