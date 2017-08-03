package com.qacg.qerp.model.dto;

import java.io.Serializable;
import java.util.Date;

public class EmployeeDto implements Serializable {
    private static final long serialVersionUID = 1L;
	
	private Long idEmployee;
	private String name;
	private String lastName;
	private Date birthday;
	private String placeBirth;
	private String gender;
	private String nationality;
	private String tin;
	private String numberEmployee;
	private Date startDate;
	private String profilePicture;
	private JobTitleDto jobTitle;
	private boolean active;
	
	
	public Long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNumberEmployee() {
		return numberEmployee;
	}
	public void setNumberEmployee(String numberEmployee) {
		this.numberEmployee = numberEmployee;
	}
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public JobTitleDto getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(JobTitleDto jobTitle) {
        this.jobTitle = jobTitle;
    }

}
