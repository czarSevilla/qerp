package com.qacg.qerp.web.jsf;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CompanyDto;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.model.dto.LanguageDto;
import com.qacg.qerp.service.CompanyService;
import com.qacg.qerp.service.CurrencyService;
import com.qacg.qerp.service.LanguageService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name = "companyMB")
@ViewScoped
public class CompanyManagedBean {

   private List<CompanyDto>   companies;
   private CompanyDto         company;
   private Long               idCompany;
   private List<CurrencyDto>  currencies;
   private List<LanguageDto>  languages;
   private Long               idCurrency;
   private CurrencyDto        currency;
   private LanguageDto        language;
   public static final String SUCCESS = "success.detail";

   @ManagedProperty("#{companyService}")
   private CompanyService     companyService;

   @ManagedProperty("#{currencyService}")
   private CurrencyService    currencyService;

   @ManagedProperty("#{languageService}")
   private LanguageService    languageService;

   @PostConstruct
   public void init() {
      languages = languageService.findAll();
      currencies = currencyService.findAll();
      companies = companyService.findAll();
   }

   public List<LanguageDto> getLanguages() {
      return languages;
   }

   public void setLanguages(List<LanguageDto> languages) {
      this.languages = languages;
   }

   public LanguageService getLanguageService() {
      return languageService;
   }

   public void setLanguageService(LanguageService languageService) {
      this.languageService = languageService;
   }

   public LanguageDto getLanguage() {
      return language;
   }

   public void setLanguage(LanguageDto language) {
      this.language = language;
   }

   public CurrencyService getCurrencyService() {
      return currencyService;
   }

   public void setCurrencyService(CurrencyService currencyService) {
      this.currencyService = currencyService;
   }

   public CompanyService getCompanyService() {
      return companyService;
   }

   public void setCompanyService(CompanyService companyService) {
      this.companyService = companyService;
   }

   public List<CompanyDto> getCompanies() {
      return companies;
   }

   public void setCompanies(List<CompanyDto> companies) {
      this.companies = companies;
   }

   public CompanyDto getCompany() {
      return company;
   }

   public void setCompany(CompanyDto company) {
      this.company = company;
   }

   public Long getIdCompany() {
      return idCompany;
   }

   public void setIdCompany(Long idCompany) {
      this.idCompany = idCompany;
   }

   public List<CurrencyDto> getCurrencies() {
      return currencies;
   }

   public void setCurrencies(List<CurrencyDto> currencies) {
      this.currencies = currencies;
   }

   public Long getIdCurrency() {
      return idCurrency;
   }

   public void setIdCurrency(Long idCurrency) {
      this.idCurrency = idCurrency;
   }

   public CurrencyDto getCurrency() {
      return currency;
   }

   public void setCurrency(CurrencyDto currency) {
      this.currency = currency;
   }

   public void create() {
      company = new CompanyDto();
      currency = new CurrencyDto();
      language = new LanguageDto();
      company.setCurrencyDto(currency);
      company.setLanguageDto(language);
   }

   public void save() {

      FacesContext ctx = FacesContext.getCurrentInstance();
      try {
         companyService.save(company);
         companies = companyService.findAll();
         ctx.addMessage(null, MessageUtils.success(ctx, SUCCESS));
      } catch (ServiceException se) {
         ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
      }

   }

   public void findOne(Long idCompany) {
      FacesContext ctx = FacesContext.getCurrentInstance();
      try {
         company = companyService.findOne(idCompany);
         ctx.addMessage(null, MessageUtils.success(ctx, SUCCESS));
      } catch (ServiceException se) {
         ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));

      }

   }

   public void delete(Long idCompany) {

      FacesContext ctx = FacesContext.getCurrentInstance();
      try {
         companyService.delete(idCompany);
         companies = companyService.findAll();
         ctx.addMessage(null, MessageUtils.success(ctx, SUCCESS));
      } catch (ServiceException se) {
         ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
      }
   }

   public String printCurrency(CompanyDto dto) {
      Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
      String localeIso = String.format("%s_%s", locale.getLanguage(), locale.getCountry());
      if ("es_MX".equals(localeIso)) {
         return dto.getCurrencyDto().getNameEsMx();
      } else {
         return dto.getCurrencyDto().getNameEnUs();
      }

   }

   public String printLanguage(CompanyDto dto) {
      Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
      String localeIso = String.format("%s_%s", locale.getLanguage(), locale.getCountry());
      if ("es_MX".equals(localeIso)) {
         return dto.getLanguageDto().getNameEsMx();
      } else {
         return dto.getLanguageDto().getNameEnUs();
      }

   }

}
