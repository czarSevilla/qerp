package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class EmployeeLanguageDto implements Serializable{
   private static final long serialVersionUID = -375428672443552493L;
   private int idEmployeLanguge;
   private EmployeeDto employee;
   private String name;
   private int porcSpeak;
   private int porWrite;
   public int getIdEmployeLanguge() {
      return idEmployeLanguge;
   }
   public void setIdEmployeLanguge(int idEmployeLanguge) {
      this.idEmployeLanguge = idEmployeLanguge;
   }
   public EmployeeDto getEmpleado() {
      return employee;
   }
   public void setEmpleado(EmployeeDto empleado) {
      this.employee = empleado;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getPorcSpeak() {
      return porcSpeak;
   }
   public void setPorcSpeak(int porcSpeak) {
      this.porcSpeak = porcSpeak;
   }
   public int getPorWrite() {
      return porWrite;
   }
   public void setPorWrite(int porWrite) {
      this.porWrite = porWrite;
   }
}