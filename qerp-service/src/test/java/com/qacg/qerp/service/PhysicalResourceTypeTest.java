package com.qacg.qerp.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.hibernate.annotations.Check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.CurrencyDto;
import com.qacg.qerp.model.dto.PhysicalResourceTypeDto;
import com.qacg.qerp.persistence.entity.Currency;
import com.qacg.qerp.persistence.entity.PhysicalResourceType;
import com.qacg.qerp.persistence.repository.PhysicalResourceTypeRepository;
import com.qacg.qerp.service.impl.PhysicalResourceTypeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PhysicalResourceTypeTest {

	@InjectMocks
	private PhysicalResourceTypeServiceImpl pRTService;
	
	@Mock
	private PhysicalResourceTypeRepository pRTRepository;
	
	@Mock
	private DataAccessException exception;

	@Test
	public void findAllTest() {
		when(pRTRepository.findAll()).thenReturn(Arrays.asList(new PhysicalResourceType()));

		pRTService.findAll();

		verify(pRTRepository, atLeastOnce()).findAll();
	}

	
	@Test
	public void saveTest() throws Exception {
		PhysicalResourceTypeDto physicalResourceTypeDto = new PhysicalResourceTypeDto();
		when(pRTRepository.save(any(PhysicalResourceType.class))).thenReturn(null);

		pRTService.save(physicalResourceTypeDto);

		verify(pRTRepository, atLeastOnce()).save(any(PhysicalResourceType.class));
	}
	
	@Test(expected = ServiceException.class)
	public void failSaveTest() throws Exception {
		doThrow(exception).when(pRTRepository).save(any(PhysicalResourceType.class));
		
		pRTService.save(new PhysicalResourceTypeDto());
	}

	@Test
	public void deleteTest() throws Exception {
		Long idPRT = 1L;

		pRTService.delete(idPRT);

		verify(pRTRepository, atLeastOnce()).delete(idPRT);
	}
	
	@Test(expected = ServiceException.class)
	public void failDeleteTest() throws Exception {
		Long idPRT = 2L;
		doThrow(exception).when(pRTRepository).delete(idPRT);
		
		pRTService.delete(idPRT);
	}
}
