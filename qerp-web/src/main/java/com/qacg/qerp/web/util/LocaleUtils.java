package com.qacg.qerp.web.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class LocaleUtils {
	
   
     private LocaleUtils(){
        /*Default Constructor*/
     }
   
	public static String localize(String attr, Object obj, Locale locale) {
		String name = String.format("get%s%s", attr.substring(0, 1).toUpperCase(), attr.substring(1));
		String lang = locale.getLanguage();
		String methodName = null;
		if ("es".equals(lang)) {
			methodName = String.format("%sEsMx", name);
		} else {
			methodName = String.format("%sEnUs", name);
		}
		
		String value = "";
		
		try {
			Method method = obj.getClass().getDeclaredMethod(methodName);
			value = (String) method.invoke(obj);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return value;
	}
}
