package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.EmployeeDto;
import com.qacg.qerp.model.dto.GenderDto;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.model.dto.MaritalStatusDto;
import com.qacg.qerp.model.dto.NationalityDto;
import com.qacg.qerp.service.EmployeeService;
import com.qacg.qerp.service.GenderService;
import com.qacg.qerp.service.JobTitleService;
import com.qacg.qerp.service.MaritalStatusService;
import com.qacg.qerp.service.NationalityService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name = "employeeMB")
@ViewScoped
public class EmployeeManagedBean{
     private List<JobTitleDto> jobTitles;
	private List<EmployeeDto> employees;
	private List<MaritalStatusDto> maritalStatus;
	private List<GenderDto> genders;
	private List<NationalityDto> nationalities;
	private JobTitleDto jobTitle;
	private NationalityDto nationality;
	private GenderDto gender;
	private MaritalStatusDto maritalStatu; 
	private String actionTitle;
     private EmployeeDto employee;

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;
	@ManagedProperty("#{jobTitleService}")
	private JobTitleService jobTitleService;
	@ManagedProperty("#{maritalStatusService}")
	private MaritalStatusService maritalStatusService;
	@ManagedProperty("#{genderService}")
	private GenderService genderService;
	@ManagedProperty("#{nationalityService}")
	private NationalityService nationalityService;
	

	@PostConstruct
	public void init() {
		employees = employeeService.findAll();
		jobTitles = jobTitleService.findAll();
		//genders = genderService.findAll();
		//maritalStatus = maritalStatusService.findAll();
		//nationalities = nationalityService.findAll();
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
		jobTitle = new JobTitleDto();
		gender = new GenderDto();
		nationality = new NationalityDto();
		maritalStatu =new MaritalStatusDto();
		employee.setJobTitleDto(jobTitle);
		employee.setMaritalStatus(maritalStatu);
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

     public JobTitleDto getJobTitleDto() {
        return jobTitle;
     }

     public void setJobTitleDto(JobTitleDto jobTitle) {
        this.jobTitle = jobTitle;
     }

     public final List<MaritalStatusDto> getMaritalStatus() {
         return maritalStatus;
     }
   
     public final void setMaritalStatus(List<MaritalStatusDto> maritalStatus) {
         this.maritalStatus = maritalStatus;
     }
   
     public final List<GenderDto> getGenders() {
         return genders;
     }
   
     public final void setGenders(List<GenderDto> genders) {
         this.genders = genders;
     }

     public final List<NationalityDto> getNationalities() {
         return nationalities;
     }

     public final void setNationalities(List<NationalityDto> nationalities) {
         this.nationalities = nationalities;
     }

     public final JobTitleDto getJobTitle() {
         return jobTitle;
     }

     public final void setJobTitle(JobTitleDto jobTitle) {
         this.jobTitle = jobTitle;
     }

     public final NationalityDto getNationality() {
         return nationality;
     }

     public final void setNationality(NationalityDto nationality) {
         this.nationality = nationality;
     }

     public final GenderDto getGender() {
         return gender;
     }

     public final void setGender(GenderDto gender) {
         this.gender = gender;
     }

     public final MaritalStatusDto getMaritalStatu() {
         return maritalStatu;
     }

     public final void setMaritalStatu(MaritalStatusDto maritalStatu) {
         this.maritalStatu = maritalStatu;
     }

     public final MaritalStatusService getMaritalStatusService() {
         return maritalStatusService;
     }

     public final void setMaritalStatusService(MaritalStatusService maritalStatusService) {
         this.maritalStatusService = maritalStatusService;
     }

     public final GenderService getGenderService() {
         return genderService;
     }

     public final void setGenderService(GenderService genderService) {
         this.genderService = genderService;
     }

     public final NationalityService getNationalityService() {
         return nationalityService;
     }

     public final void setNationalityService(NationalityService nationalityService) {
         this.nationalityService = nationalityService;
     }
}