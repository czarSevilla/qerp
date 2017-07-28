package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.EmployeeDto;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.service.EmployeeService;
import com.qacg.qerp.service.JobTitleService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name = "employeeMB")
@ViewScoped
public class EmployeeManagedBean {

	private List<EmployeeDto> employees;

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;
	
	@ManagedProperty("#{jobTitleService}")
	private JobTitleService jobTitleService;

	private String actionTitle;
	
	private EmployeeDto employee;
	
	private List<JobTitleDto> jobTitles;

	@PostConstruct
	public void init() {
		employees = employeeService.findAll();
		jobTitles = jobTitleService.findAll();
	}
	
	public void save() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
			employeeService.save(employee);
			employees = employeeService.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		} catch (ServiceException se) {
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
	}
	
	public void create() {
		employee = new EmployeeDto();
		employee.setJobTitle(new JobTitleDto());
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

	public String getActionTitle() {
		return actionTitle;
	}

	public void setActionTitle(String actionTitle) {
		this.actionTitle = actionTitle;
	}

	public EmployeeDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

	public List<JobTitleDto> getJobTitles() {
		return jobTitles;
	}

	public void setJobTitles(List<JobTitleDto> jobTitles) {
		this.jobTitles = jobTitles;
	}

	public JobTitleService getJobTitleService() {
		return jobTitleService;
	}

	public void setJobTitleService(JobTitleService jobTitleService) {
		this.jobTitleService = jobTitleService;
	}

}
