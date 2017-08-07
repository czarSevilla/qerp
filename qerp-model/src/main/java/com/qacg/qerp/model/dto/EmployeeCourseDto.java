package com.qacg.qerp.model.dto;

import java.io.Serializable;
import java.util.Date;

public class EmployeeCourseDto implements Serializable{
   private static final long serialVersionUID = -727953057207559256L;
   private int idEmployeeCourse;
   private EmployeeDto employee;
   private String name;
   private Date date;
   
   public int getIdEmployeeCourse() {
      return idEmployeeCourse;
   }
   public void setIdEmployeeCourse(int idEmployeeCourse) {
      this.idEmployeeCourse = idEmployeeCourse;
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
}