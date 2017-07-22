package com.qacg.qerp.web.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class MessageUtils {
	
	private MessageUtils() {
		// Constructor privado por ser un util class
	}
	
	private static final String MESSAGES = "messages";
	
	private static final String ERROR = "error";
	
	private static final String SUCCESS = "success";

	public static String message(FacesContext ctx, String key, Object... params) {
		Locale locale = ctx.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES, locale);
		try {
			String msg = bundle.getString(key);
			return MessageFormat.format(msg, params);
		} catch (MissingResourceException mre) {
			return key;
		}
	}
	
	public static FacesMessage error(FacesContext ctx, String keyDetail) {
		return facesMessage(ctx, FacesMessage.SEVERITY_ERROR, ERROR, keyDetail);
	}
	
	public static FacesMessage success(FacesContext ctx, String keyDetail) {
		return facesMessage(ctx, FacesMessage.SEVERITY_INFO, SUCCESS, keyDetail);
	}
	
	public static FacesMessage facesMessage(FacesContext ctx, Severity severity, String keySummary, String keyDetail) {
		String summary = message(ctx, keySummary);
		String detail = message(ctx, keyDetail);
		return new FacesMessage(severity, summary, detail);
	}
}
