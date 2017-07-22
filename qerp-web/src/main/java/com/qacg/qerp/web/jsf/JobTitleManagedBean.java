package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.service.JobTitleService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name = "jobTitleMB")
@ViewScoped
public class JobTitleManagedBean {

	private List<JobTitleDto> jobTitles;
	
	private JobTitleDto jobTitle;
	
	private String actionTitle;
	
	private Long idJobTitle;
	
	@ManagedProperty("#{jobTitleService}")
	private JobTitleService jobTitleService;
	
	@PostConstruct
	public void init() {
		jobTitles = jobTitleService.findAll();
		jobTitle = new JobTitleDto();
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

	public JobTitleDto getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitleDto jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public void save() {
		FacesContext ctx = FacesContext.getCurrentInstance(); 
		try {
			jobTitleService.save(jobTitle);
			jobTitles = jobTitleService.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		} catch (ServiceException se) {
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
	}
	
	public void create() {
		jobTitle = new JobTitleDto();
	}
	
	public void delete(Long idJobTitle) {
		FacesContext ctx = FacesContext.getCurrentInstance(); 
		
		try {
			jobTitleService.delete(idJobTitle);
			jobTitles = jobTitleService.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		} catch (ServiceException se) {
			ctx.addMessage(null, MessageUtils.error(ctx, "delete.error"));
		}
	}

	public String getActionTitle() {
		return actionTitle;
	}

	public void setActionTitle(String actionTitle) {
		this.actionTitle = actionTitle;
	}

	public Long getIdJobTitle() {
		return idJobTitle;
	}

	public void setIdJobTitle(Long idJobTitle) {
		this.idJobTitle = idJobTitle;
	}
}
