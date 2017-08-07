package com.qacg.qerp.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_course")
public class EmployeeCourse implements Serializable{
   private static final long serialVersionUID = -8873248938651429014L;
   private int idEmployeeCourse;
   private Employee employee;
   private String name;
   private Date date;
   
   @Id
   @Column(name = "id_employee_course")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdEmployeeCourse() {
      return idEmployeeCourse;
   }
   public void setIdEmployeeCourse(int idEmployeeCourse) {
      this.idEmployeeCourse = idEmployeeCourse;
   }
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_employee")
   public Employee getEmployee() {
      return employee;
   }
   public void setEmployee(Employee employee) {
      this.employee = employee;
   }
   @Column(name = "name", nullable = false)
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   @Column(name = "date", nullable = false)
   public Date getDate() {
      return date;
   }
   public void setDate(Date date) {
      this.date = date;
   }
}