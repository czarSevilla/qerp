package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class EmployeeAddressDto implements Serializable{
   private static final long serialVersionUID = -5678156682800676170L;
   private int idEmployeeAddress;
   private EmployeeDto employee;
   private String state;
   private int zipCode;
   private String city;
   private String surbub;
   private String street;
   private String  stNumber;
   private String aptNumber;
   
   public int getIdEmployeeAddress() {
      return idEmployeeAddress;
   }
   public void setIdEmployeeAddress(int idEmployeeAddress) {
      this.idEmployeeAddress = idEmployeeAddress;
   }
   public EmployeeDto getEmployee() {
      return employee;
   }
   public void setEmployee(EmployeeDto employee) {
      this.employee = employee;
   }
   public String getState() {
      return state;
   }
   public void setState(String state) {
      this.state = state;
   }
   public int getZipCode() {
      return zipCode;
   }
   public void setZipCode(int zipCode) {
      this.zipCode = zipCode;
   }
   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }
   public String getSurbub() {
      return surbub;
   }
   public void setSurbub(String surbub) {
      this.surbub = surbub;
   }
   public String getStreet() {
      return street;
   }
   public void setStreet(String street) {
      this.street = street;
   }
   public String getStNumber() {
      return stNumber;
   }
   public void setStNumber(String stNumber) {
      this.stNumber = stNumber;
   }
   public String getAptNumber() {
      return aptNumber;
   }
   public void setAptNumber(String aptNumber) {
      this.aptNumber = aptNumber;
   }
}