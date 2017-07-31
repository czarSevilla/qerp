package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class CompanyDto implements Serializable {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private Long              idCompany;

   private CurrencyDto       currencyDto;
   private LanguageDto       languageDto;
   private String            name;
   private String            prefix;

   public Long getIdCompany() {
      return idCompany;
   }

   public void setIdCompany(Long idCompany) {
      this.idCompany = idCompany;
   }

   public LanguageDto getLanguageDto() {
      return languageDto;
   }

   public void setLanguageDto(LanguageDto languageDto) {
      this.languageDto = languageDto;
   }

   public CurrencyDto getCurrencyDto() {
      return currencyDto;
   }

   public void setCurrencyDto(CurrencyDto currencyDto) {
      this.currencyDto = currencyDto;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPrefix() {
      return prefix;
   }

   public void setPrefix(String prefix) {
      this.prefix = prefix;
   }

}
