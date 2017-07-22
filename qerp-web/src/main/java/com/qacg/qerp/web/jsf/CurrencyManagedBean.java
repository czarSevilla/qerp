package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.service.CurrencyService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name = "currencyMB")
@ViewScoped
public class CurrencyManagedBean {
	
	private List<CurrencyDto> currencies;
	private CurrencyDto currency;
	private Long idCurrency;
	
	@ManagedProperty("#{currencyService}")
	private CurrencyService currencyService;
	
	@PostConstruct
	public void init(){
		currencies = currencyService.findAll();
		currency = new CurrencyDto();
	}
	
	public CurrencyService getCurrencyService() {
		return currencyService;
	}
	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}
	
	public List<CurrencyDto> getCurrencies() {
		return currencies;
	}
	public void setCurrencies(List<CurrencyDto> currencies) {
		this.currencies = currencies;
	}
	
	public CurrencyDto getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyDto currency) {
		this.currency = currency;
	}
	
	public void create(){
		currency = new CurrencyDto();
		
	}
	
	public Long getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(Long idCurrency) {
		this.idCurrency = idCurrency;
	}

	public void save(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			currencyService.save(currency);
			currencies = currencyService.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
		
	}
	
	public void delete(Long idCurrency){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			currencyService.delete(idCurrency);
			currencies = currencyService.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
	}
	

	
	
	

}
