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
import com.qacg.qerp.model.dto.PayrollIncidentTypeDto;
import com.qacg.qerp.persistence.entity.PayrollIncidentType;
import com.qacg.qerp.persistence.repository.PayrollIncidentTypeRepository;
import com.qacg.qerp.service.impl.PayrollIncidentTypeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PayrollIncidentTypeServiceTest {

   @InjectMocks
   private PayrollIncidentTypeServiceImpl payrollService;
   
   @Mock
   private  PayrollIncidentTypeRepository payrollRepository;
   
   @Mock
   private DataAccessException exception;

   @Test
   public void findAllTest() {
        when(payrollRepository.findAll()).thenReturn(Arrays.asList(new  PayrollIncidentType()));

        payrollService.findAll();

        verify(payrollRepository, atLeastOnce()).findAll();
   }

   
   @Test
   public void saveTest() throws Exception {
      PayrollIncidentTypeDto payrollDto = new  PayrollIncidentTypeDto();
        when(payrollRepository.save(any( PayrollIncidentType.class))).thenReturn(null);

        payrollService.save(payrollDto);

        verify(payrollRepository, atLeastOnce()).save(any( PayrollIncidentType.class));
   }
   
   @Test(expected = ServiceException.class)
   public void failSaveTest() throws Exception {
        doThrow(exception).when(payrollRepository).save(any( PayrollIncidentType.class));
        
        payrollService.save(new  PayrollIncidentTypeDto());
   }

   @Test
   public void deleteTest() throws Exception {
        Long idPayroll = 1L;

        payrollService.delete(idPayroll);

        verify(payrollRepository, atLeastOnce()).delete(idPayroll);
   }
   
   @Test(expected = ServiceException.class)
   public void failDeleteTest() throws Exception {
        Long idPayroll = 2L;
        doThrow(exception).when(payrollRepository).delete(idPayroll);
        
        payrollService.delete(idPayroll);
   }
}


