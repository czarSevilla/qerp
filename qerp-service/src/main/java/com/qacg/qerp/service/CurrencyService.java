package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CurrencyDto;

public interface CurrencyService {
	
	List<CurrencyDto> findAll();
	
	void save(CurrencyDto currencyDto) throws ServiceException;
	
	void delete(Long idCurrency) throws ServiceException;

}
