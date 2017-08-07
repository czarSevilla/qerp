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

@Entity
@Table(name = "employee_address")
public class EmployeeAddress implements Serializable{
   
   private static final long serialVersionUID = 1L;
   private int idEmployeeAddress;
   private Employee employee;
   private String state;
   private int zipCode;
   private String city;
   private String surbub;
   private String street;
   private String  stNumber;
   private String aptNumber;
   
   @Id
   @Column(name = "id_employee_address")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdEmployeeAddress() {
      return idEmployeeAddress;
   }
   public void setIdEmployeeAddress(int idEmployeeAddress) {
      this.idEmployeeAddress = idEmployeeAddress;
   }
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_employee")
   public Employee getEmployee() {
      return employee;
   }
   public void setEmployee(Employee employee) {
      this.employee = employee;
   }
   @Column(name = "state", nullable = false)
   public String getState() {
      return state;
   }
   public void setState(String state) {
      this.state = state;
   }
   @Column(name = "zip_code", nullable = false)
   public int getZipCode() {
      return zipCode;
   }
   public void setZipCode(int zipCode) {
      this.zipCode = zipCode;
   }
   @Column(name = "city", nullable = false)
   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }
   @Column(name = "surbub", nullable = false)
   public String getSurbub() {
      return surbub;
   }
   public void setSurbub(String surbub) {
      this.surbub = surbub;
   }
   @Column(name = "street", nullable = false)
   public String getStreet() {
      return street;
   }
   public void setStreet(String street) {
      this.street = street;
   }
   @Column(name = "st_number")
   public String getStNumber() {
      return stNumber;
   }
   public void setStNumber(String stNumber) {
      this.stNumber = stNumber;
   }
   @Column(name = "apt_number", nullable = false)
   public String getAptNumber() {
      return aptNumber;
   }
   public void setAptNumber(String aptNumber) {
      this.aptNumber = aptNumber;
   }
}