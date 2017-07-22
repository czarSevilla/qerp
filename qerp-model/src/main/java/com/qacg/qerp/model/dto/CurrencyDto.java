package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class CurrencyDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idCurrency;
	private String currencyIso;
	private String nameEsMx;
	private String nameEnUs;
	
	public Long getIdCurrency() {
		return idCurrency;
	}
	public void setIdCurrency(Long idCurrency) {
		this.idCurrency = idCurrency;
	}
	public String getCurrencyIso() {
		return currencyIso;
	}
	public void setCurrencyIso(String currencyIso) {
		this.currencyIso = currencyIso;
	}
	public String getNameEsMx() {
		return nameEsMx;
	}
	public void setNameEsMx(String nameEsMx) {
		this.nameEsMx = nameEsMx;
	}
	public String getNameEnUs() {
		return nameEnUs;
	}
	public void setNameEnUs(String nameEnUs) {
		this.nameEnUs = nameEnUs;
	}
	
	

}
