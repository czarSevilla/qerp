package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PayrollIncidentTypeDto;

public interface PayrollIncidentTypeService {
   
   List<PayrollIncidentTypeDto> findAll();

   void save(PayrollIncidentTypeDto payrollDto) throws ServiceException;

   void delete(Long idPayroll) throws ServiceException;
}
