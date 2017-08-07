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
@Table(name = "employee_certification")
public class EmployeeCertification implements Serializable{
   private static final long serialVersionUID = -8104001721156755454L;
   private int idEmployeeCertification;
   private Employee employee;
   private String name;
   private Date date;
   private String certificationNumber;
   
   @Id
   @Column(name = "id_employee_certification")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int getIdEmployeeCertification() {
      return idEmployeeCertification;
   }
   public void setIdEmployeeCertification(int idEmployeeCertification) {
      this.idEmployeeCertification = idEmployeeCertification;
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
   @Column(name = "certification_number")
   public String getCertificationNumber() {
      return certificationNumber;
   }
   public void setCertificationNumber(String certificationNumber) {
      this.certificationNumber = certificationNumber;
   }
}