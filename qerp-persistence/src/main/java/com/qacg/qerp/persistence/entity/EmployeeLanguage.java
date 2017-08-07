package com.qacg.qerp.persistence.entity;

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
@Table(name = "employee_language")
public class EmployeeLanguage {

   private int idEmployeLanguge;
   private Employee employee;
   private String name;
   private int porcSpeak;
   private int porWrite;
   
   @Id
   @Column(name = "id_employee_language")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdEmployeLanguge() {
      return idEmployeLanguge;
   }
   public void setIdEmployeLanguge(int idEmployeLanguge) {
      this.idEmployeLanguge = idEmployeLanguge;
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
   @Column(name = "porc_speak", nullable = false)
   public int getPorcSpeak() {
      return porcSpeak;
   }
   public void setPorcSpeak(int porcSpeak) {
      this.porcSpeak = porcSpeak;
   }
   @Column(name = "porc_write", nullable = false)
   public int getPorWrite() {
      return porWrite;
   }
   public void setPorWrite(int porWrite) {
      this.porWrite = porWrite;
   }
}
