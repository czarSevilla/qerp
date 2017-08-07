package com.qacg.qerp.model.dto;

import java.io.Serializable;
import java.util.Date;

public class EmployeeDto implements Serializable {
    private static final long serialVersionUID = 1L;
	
	private Long idEmployee;
	private String numberEmployee;
	private Date startDate;
	private String profilePicture;
	private String name;
	private String lastName;
	private Date birthday;
	private String placeBirth;
	private GenderDto gender;
	private NationalityDto nationality;
	private String tin;
	private String curp;
	private String ssn;
	private MaritalStatusDto maritalStatus;
	private Integer homephone;
	private Integer cellphone;
	private Integer emergyphone;
	private String corporateEmail;
	private String personalEmail;
	private JobTitleDto jobTitleDto;
	private boolean active;
	
   public Long getIdEmployee() {
      return idEmployee;
   }
   public void setIdEmployee(Long idEmployee) {
      this.idEmployee = idEmployee;
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
   public void setStartDate(Date starDate) {
      this.startDate = starDate;
   }
   public String getProfilePicture() {
      return profilePicture;
   }
   public void setProfilePicture(String profilePicture) {
      this.profilePicture = profilePicture;
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
   public Date getBirthday() {
      return birthday;
   }
   public void setBirthday(Date birthday) {
      this.birthday = birthday;
   }
   public String getPlaceBirth() {
      return placeBirth;
   }
   public void setPlaceBirth(String placeBirth) {
      this.placeBirth = placeBirth;
   }
   public GenderDto getGender() {
      return gender;
   }
   public void setGender(GenderDto gender) {
      this.gender = gender;
   }
   public NationalityDto getNationality() {
      return nationality;
   }
   public void setNationality(NationalityDto nationality) {
      this.nationality = nationality;
   }
   public String getTin() {
      return tin;
   }
   public void setTin(String tin) {
      this.tin = tin;
   }
   public String getCurp() {
      return curp;
   }
   public void setCurp(String curp) {
      this.curp = curp;
   }
   public String getSsn() {
      return ssn;
   }
   public void setSsn(String ssn) {
      this.ssn = ssn;
   }
   public MaritalStatusDto getMaritalStatus() {
      return maritalStatus;
   }
   public void setMaritalStatus(MaritalStatusDto maritalStatus) {
      this.maritalStatus = maritalStatus;
   }
   public Integer getHomephone() {
      return homephone;
   }
   public void setHomephone(Integer homephone) {
      this.homephone = homephone;
   }
   public Integer getCellphone() {
      return cellphone;
   }
   public void setCellphone(Integer cellphone) {
      this.cellphone = cellphone;
   }
   public Integer getEmergyphone() {
      return emergyphone;
   }
   public void setEmergyphone(Integer emergyphone) {
      this.emergyphone = emergyphone;
   }
   
   public JobTitleDto getJobTitleDto() {
      return jobTitleDto;
   }
   public void setJobTitleDto(JobTitleDto jobTitleDto) {
      this.jobTitleDto = jobTitleDto;
   }
   public String getCorporateEmail() {
      return corporateEmail;
   }
   public void setCorporateEmail(String corporateEmail) {
      this.corporateEmail = corporateEmail;
   }
   public String getPersonalEmail() {
      return personalEmail;
   }
   public void setPersonalEmail(String personalEmail) {
      this.personalEmail = personalEmail;
   }
   public boolean isActive() {
      return active;
   }
   public void setActive(boolean active) {
      this.active = active;
   }
}