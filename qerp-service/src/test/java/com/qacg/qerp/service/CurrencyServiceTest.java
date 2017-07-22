package com.qacg.qerp.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.persistence.entity.Currency;
import com.qacg.qerp.persistence.entity.JobTitle;
import com.qacg.qerp.persistence.repository.CurrencyRepository;
import com.qacg.qerp.persistence.repository.JobTitleRepository;
import com.qacg.qerp.service.impl.CurrencyServiceImpl;
import com.qacg.qerp.service.impl.JobTitleServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyServiceTest {

	@InjectMocks
	private CurrencyServiceImpl currencyService;
	
	@Mock
	private CurrencyRepository currencyRepository;
	
	@Mock
	private DataAccessException exception;

	@Test
	public void findAllTest() {
		when(currencyRepository.findAll()).thenReturn(Arrays.asList(new Currency()));

		currencyService.findAll();

		verify(currencyRepository, atLeastOnce()).findAll();
	}

	
	@Test
	public void saveTest() throws Exception {
		CurrencyDto currencyDto = new CurrencyDto();
		when(currencyRepository.save(any(Currency.class))).thenReturn(null);

		currencyService.save(currencyDto);

		verify(currencyRepository, atLeastOnce()).save(any(Currency.class));
	}
	
	@Test(expected = ServiceException.class)
	public void failSaveTest() throws Exception {
		doThrow(exception).when(currencyRepository).save(any(Currency.class));
		
		currencyService.save(new CurrencyDto());
	}

	@Test
	public void deleteTest() throws Exception {
		Long idCurrency = 1L;

		currencyService.delete(idCurrency);

		verify(currencyRepository, atLeastOnce()).delete(idCurrency);
	}
	
	@Test(expected = ServiceException.class)
	public void failDeleteTest() throws Exception {
		Long idCurrency = 2L;
		doThrow(exception).when(currencyRepository).delete(idCurrency);
		
		currencyService.delete(idCurrency);
	}
	
}
