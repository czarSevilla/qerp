package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CompanyDto;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.model.dto.LanguageDto;
import com.qacg.qerp.persistence.entity.Company;
import com.qacg.qerp.persistence.entity.Currency;
import com.qacg.qerp.persistence.entity.Language;
import com.qacg.qerp.persistence.repository.CompanyRepository;
import com.qacg.qerp.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

   private CompanyRepository companyRepository;

   @Autowired
   public void setCompanyRepository(CompanyRepository companyRepository) {
      this.companyRepository = companyRepository;
   }

   @Override
   public List<CompanyDto> findAll() {
      List<Company> companies = companyRepository.findAll();
      List<CompanyDto> dtos = new ArrayList<>();
      for (Company entity : companies) {
         CurrencyDto currencyDto = new CurrencyDto();
         CompanyDto dto = new CompanyDto();
         LanguageDto languageDto = new LanguageDto();

         BeanUtils.copyProperties(entity.getCurrency(), currencyDto);
         BeanUtils.copyProperties(entity.getLanguage(), languageDto);
         dto.setIdCompany(entity.getIdCompany());
         dto.setName(entity.getName());
         dto.setPrefix(entity.getPrefix());

         dto.setCurrencyDto(currencyDto);
         dto.setLanguageDto(languageDto);

         dtos.add(dto);

      }
      return dtos;
   }

   @Override
   public void save(CompanyDto companyDto) throws ServiceException {
      Company company = new Company();
      Currency currency = new Currency();
      Language language = new Language();
      company.setName(companyDto.getName());
      company.setPrefix(companyDto.getPrefix());

      company.setIdCompany(companyDto.getIdCompany());
      BeanUtils.copyProperties(companyDto.getLanguageDto(), language);
      BeanUtils.copyProperties(companyDto.getCurrencyDto(), currency);
      company.setCurrency(currency);
      company.setLanguage(language);

      try {
         companyRepository.save(company);
      } catch (Exception ex) {
         throw new ServiceException(ex.getMessage());
      }

   }

   @Override
   public void delete(Long idCompany) throws ServiceException {
      try {
         companyRepository.delete(idCompany);
      } catch (Exception ex) {
         throw new ServiceException(ex.getMessage());
      }

   }

   @Override
   public CompanyDto findOne(Long idCompany) throws ServiceException {

      CompanyDto companyDto = new CompanyDto();
      CurrencyDto currencyDto = new CurrencyDto();
      LanguageDto languageDto = new LanguageDto();

      Company company = companyRepository.findOne(idCompany);
      BeanUtils.copyProperties(company.getCurrency(), currencyDto);
      BeanUtils.copyProperties(company.getLanguage(), languageDto);
      companyDto.setIdCompany(idCompany);

      companyDto.setName(company.getName());
      companyDto.setPrefix(company.getPrefix());
      companyDto.setCurrencyDto(currencyDto);
      companyDto.setLanguageDto(languageDto);

      return companyDto;

   }

}
