package com.qacg.qerp.model.dto;

import java.io.Serializable;
import java.util.Date;

public class EmployeeCertificationDto implements Serializable{
   private static final long serialVersionUID = 2995868250174158619L;
   private int idEmployeeCertification;
   private EmployeeDto employee;
   private String name;
   private Date date;
   private String certificationNumber;
   
   public int getIdEmployeeCertification() {
      return idEmployeeCertification;
   }
   public void setIdEmployeeCertification(int idEmployeeCertification) {
      this.idEmployeeCertification = idEmployeeCertification;
   }
   public EmployeeDto getEmployee() {
      return employee;
   }
   public void setEmployee(EmployeeDto employee) {
      this.employee = employee;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public Date getDate() {
      return date;
   }
   public void setDate(Date date) {
      this.date = date;
   }
   public String getCertificationNumber() {
      return certificationNumber;
   }
   public void setCertificationNumber(String certificationNumber) {
      this.certificationNumber = certificationNumber;
   }
}