package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class PayrollIncidentTypeDto implements Serializable {
   
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   private Long idPayrollIncidentType;
   private String spanishName;
   private String englishName;
   private String spanishEffect;
   private String englishEffect;
   
   
   public Long getIdPayrollIncidentType() {
      return idPayrollIncidentType;
   }
   public void setIdPayrollIncidentType(Long idPayrollIncidentType) {
      this.idPayrollIncidentType = idPayrollIncidentType;
   }
   public String getSpanishName() {
      return spanishName;
   }
   public void setSpanishName(String spanishName) {
      this.spanishName = spanishName;
   }
   public String getEnglishName() {
      return englishName;
   }
   public void setEnglishName(String englishName) {
      this.englishName = englishName;
   }
   public String getSpanishEffect() {
      return spanishEffect;
   }
   public void setSpanishEffect(String spanishEffect) {
      this.spanishEffect = spanishEffect;
   }
   public String getEnglishEffect() {
      return englishEffect;
   }
   public void setEnglishEffect(String englishEffect) {
      this.englishEffect = englishEffect;
   }
   
   
}
