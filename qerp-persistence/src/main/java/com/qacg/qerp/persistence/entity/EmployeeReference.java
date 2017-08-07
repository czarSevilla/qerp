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
@Table(name = "employee_reference")
public class EmployeeReference implements Serializable{
   private static final long serialVersionUID = -5057885138264522653L;
   private int idReferenceEmployee;
   private Employee employee;
   private String name;
   private int phone;
   private String type;
   private String relationship;
   
   @Id
   @Column(name = "id_employee_reference")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdReferenceEmployee() {
      return idReferenceEmployee;
   }
   public void setIdReferenceEmployee(int idReferenceEmployee) {
      this.idReferenceEmployee = idReferenceEmployee;
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
   @Column(name = "phone", nullable = false)
   public int getPhone() {
      return phone;
   }
   public void setPhone(int phone) {
      this.phone = phone;
   }
   @Column(name = "type", nullable = false)
   public String getType() {
      return type;
   }
   public void setType(String type) {
      this.type = type;
   }
   @Column(name = "reliationship", nullable = false)
   public String getRelationship() {
      return relationship;
   }
   public void setRelationship(String relationship) {
      this.relationship = relationship;
   }
}