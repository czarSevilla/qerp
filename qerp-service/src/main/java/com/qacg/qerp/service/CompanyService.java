package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CompanyDto;
import com.qacg.qerp.model.dto.CurrencyDto;

public interface CompanyService {
	
	List<CompanyDto> findAll();
	
	void save(CompanyDto currencyDto) throws ServiceException;
	
	void delete(Long idCompany) throws ServiceException;
	
	CompanyDto findOne(Long idCompany) throws ServiceException;

}
