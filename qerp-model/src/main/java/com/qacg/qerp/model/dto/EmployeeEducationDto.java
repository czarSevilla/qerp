package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class EmployeeEducationDto implements Serializable{
   private static final long serialVersionUID = 2167884061166873822L;
   private int idEmployeeEducation;
   private EmployeeDto employee;
   private String schoolong;
   private String academy;
   private String profession;
   private int yearsExperience;
   
   public int getIdEmployeeEducation() {
      return idEmployeeEducation;
   }
   public void setIdEmployeeEducation(int idEmployeeEducation) {
      this.idEmployeeEducation = idEmployeeEducation;
   }
   public EmployeeDto getEmployee() {
      return employee;
   }
   public void setEmployee(EmployeeDto employee) {
      this.employee = employee;
   }
   public String getSchoolong() {
      return schoolong;
   }
   public void setSchoolong(String schoolong) {
      this.schoolong = schoolong;
   }
   public String getAcademy() {
      return academy;
   }
   public void setAcademy(String academy) {
      this.academy = academy;
   }
   public String getProfession() {
      return profession;
   }
   public void setProfession(String profession) {
      this.profession = profession;
   }
   public int getYearsExperience() {
      return yearsExperience;
   }
   public void setYearsExperience(int yearsExperience) {
      this.yearsExperience = yearsExperience;
   }
}