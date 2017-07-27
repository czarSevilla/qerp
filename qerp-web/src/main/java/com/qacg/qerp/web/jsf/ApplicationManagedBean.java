package com.qacg.qerp.web.jsf;

import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.qacg.qerp.web.util.LocaleUtils;

@ManagedBean(name = "appMB")
@ApplicationScoped
public class ApplicationManagedBean {

	public String localize(Object obj, String attr) {
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		return LocaleUtils.localize(attr, obj, locale);
	}
}
