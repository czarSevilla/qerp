package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class EmployeeReferenceDto implements Serializable{
   private static final long serialVersionUID = -8421360794133650394L;
   private int idReferenceEmployee;
   private EmployeeDto employee;
   private String name;
   private int phone;
   private String type;
   private String relationship;
   
   public int getIdReferenceEmployee() {
      return idReferenceEmployee;
   }
   public void setIdReferenceEmployee(int idReferenceEmployee) {
      this.idReferenceEmployee = idReferenceEmployee;
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
   public int getPhone() {
      return phone;
   }
   public void setPhone(int phone) {
      this.phone = phone;
   }
   public String getType() {
      return type;
   }
   public void setType(String type) {
      this.type = type;
   }
   public String getRelationship() {
      return relationship;
   }
   public void setRelationship(String relationship) {
      this.relationship = relationship;
   }
}