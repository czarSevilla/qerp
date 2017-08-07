package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "payroll_incident_type")
public class PayrollIncidentType implements Serializable {

   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private Long idPayrollIncidentType;
   private String spanishName;
   private String englishName;
   private String spanishEffect;
   private String englishEffect;
   
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY  )
   @Column(name = "id_payroll_incident_type")
   public Long getIdPayrollIncidentType() {
      return idPayrollIncidentType;
   }
   public void setIdPayrollIncidentType(Long idPayrollIncidentType) {
      this.idPayrollIncidentType = idPayrollIncidentType;
   }
   
   @Column(name ="spanish_name",nullable = false)
   public String getSpanishName() {
      return spanishName;
   }
   public void setSpanishName(String spanishName) {
      this.spanishName = spanishName;
   }
   
   @Column(name = "english_name",nullable = false)
   public String getEnglishName() {
      return englishName;
   }
   public void setEnglishName(String englishName) {
      this.englishName = englishName;
   }
   
   @Column(name = "spanish_effect", nullable = false)
   public String getSpanishEffect() {
      return spanishEffect;
   }
   public void setSpanishEffect(String spanishEffect) {
      this.spanishEffect = spanishEffect;
   }
   
   @Column(name = "english_effect", nullable = false)
   public String getEnglishEffect() {
      return englishEffect;
   }
   public void setEnglishEffect(String englishEffect) {
      this.englishEffect = englishEffect;
   }
   
   
}
