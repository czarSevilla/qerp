package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.persistence.entity.Currency;
import com.qacg.qerp.persistence.repository.CurrencyRepository;
import com.qacg.qerp.service.CurrencyService;

@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService {
	
	private CurrencyRepository currencyRepository;

	@Autowired
	public void setCurrencyRepository(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}

	@Override
	public List<CurrencyDto> findAll() {
		List<Currency> entities = currencyRepository.findAll();
		List<CurrencyDto> dtos =  new ArrayList<>();
		for (Currency entity : entities){
			CurrencyDto dto = new CurrencyDto();
			BeanUtils.copyProperties(entity, dto);
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public void save(CurrencyDto currencyDto) throws ServiceException {
		Currency currency = new Currency();
		BeanUtils.copyProperties(currencyDto, currency);
		try{
			currencyRepository.save(currency);
		}catch(Exception ex){
			throw new ServiceException(ex.getMessage());
		}
		
	}

	@Override
	public void delete(Long idCurrency) throws ServiceException{
		try{
			currencyRepository.delete(idCurrency);
		}catch(Exception ex){
			throw new ServiceException(ex.getMessage());
		}
		
	}
	
	
	
	


}
