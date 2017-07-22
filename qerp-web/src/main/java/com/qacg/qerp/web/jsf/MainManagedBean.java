package com.qacg.qerp.web.jsf;

import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mainMB")
@SessionScoped
public class MainManagedBean {

	private String brandTitle;
	private Locale locale;
	private Date currentDate;
	
	@PostConstruct
	public void init() {
		brandTitle = "qERP";
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		currentDate = new Date();
	}

	public String getBrandTitle() {
		return brandTitle;
	}

	public void setBrandTitle(String brandTitle) {
		this.brandTitle = brandTitle;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public void changeToEsMx() {
		changeLocale("es", "MX");
	}
	
	public void changeToEnUs() {
		changeLocale("en", "US");
	}
	
	public void changeLocale(String localeStr, String countryStr) {
		this.locale = new Locale(localeStr, countryStr);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
}



