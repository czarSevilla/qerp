package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qacg.qerp.model.dto.EmployeeDto;

@Entity
@Table(name = "employee_education")
public class EmployeeEducation implements Serializable{

   private static final long serialVersionUID = 7997011755584170236L;
   private int idEmployeeEducation;
   private Employee employee;
   private String schoolong;
   private String academy;
   private String profession;
   private int yearsExperience;
   
   @Id
   @Column(name = "id_employee_education")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdEmployeeEducation() {
      return idEmployeeEducation;
   }
   public void setIdEmployeeEducation(int idEmployeeEducation) {
      this.idEmployeeEducation = idEmployeeEducation;
   }
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_employee")
   public Employee getEmployee() {
      return employee;
   }
   public void setEmployee(Employee employee) {
      this.employee = employee;
   }
   @Column(name = "schooling", nullable = false)
   public String getSchoolong() {
      return schoolong;
   }
   public void setSchoolong(String schoolong) {
      this.schoolong = schoolong;
   }
   @Column(name = "academic", nullable = false)
   public String getAcademy() {
      return academy;
   }
   public void setAcademy(String academy) {
      this.academy = academy;
   }
   @Column(name = "profession", nullable = false)
   public String getProfession() {
      return profession;
   }
   public void setProfession(String profession) {
      this.profession = profession;
   }
   @Column(name = "years_experience", nullable = false)
   public int getYearsExperience() {
      return yearsExperience;
   }
   public void setYearsExperience(int yearsExperience) {
      this.yearsExperience = yearsExperience;
   }   
}