package com.qacg.qerp.web.jsf;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.qacg.qerp.model.dto.EmployeeDto;
import com.qacg.qerp.service.EmployeeService;

@ManagedBean(name = "employeeMB")
@ViewScoped
public class EmployeeManagedBean {

    private List<EmployeeDto> employees;
    
    @ManagedProperty("#{employeeService}")
    private EmployeeService employeeService;
    
    @PostConstruct
    public void init() {
        employees = employeeService.findAll();
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    public String printJobTitle(EmployeeDto dto) {
    	Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    	String localeIso = String.format("%s_%s", locale.getLanguage(), locale.getCountry());
    	if ("es_MX".equals(localeIso)) {
    		return dto.getJobTitle().getTitleEsMx();
    	} else {
    		return dto.getJobTitle().getTitleEnUs();
    	}
    }
    
}
