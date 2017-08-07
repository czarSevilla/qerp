package com.qacg.qerp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PayrollIncidentTypeDto;
import com.qacg.qerp.persistence.entity.PayrollIncidentType;
import com.qacg.qerp.persistence.repository.PayrollIncidentTypeRepository;
import com.qacg.qerp.service.PayrollIncidentTypeService;
import com.qacg.qerp.service.builder.PayrollIncidentTypeBuilder;

@Service("payrollService")
public class PayrollIncidentTypeServiceImpl implements PayrollIncidentTypeService {

   PayrollIncidentTypeRepository payrollIncidentTypeRepository;
   
   
   
   @Autowired
   public void setPayrollIncidentTypeRepository(PayrollIncidentTypeRepository payrollIncidentTypeRepository) {
      this.payrollIncidentTypeRepository = payrollIncidentTypeRepository;
   }




   @Override
   public List<PayrollIncidentTypeDto> findAll() {
      List<PayrollIncidentType> incidents = payrollIncidentTypeRepository.findAll();
      return incidents.stream().map(PayrollIncidentTypeBuilder::build).collect(Collectors.toList());
   }




   @Override
   public void save(PayrollIncidentTypeDto payrollDto) throws ServiceException {
      try {
        payrollIncidentTypeRepository.save(PayrollIncidentTypeBuilder.build(payrollDto));
      } catch (Exception ex) {
         throw new ServiceException(ex.getMessage());
      }

   }




   @Override
   public void delete(Long idPayroll) throws ServiceException {
      try {
         payrollIncidentTypeRepository.delete(idPayroll);
       } catch (Exception ex) {
          throw new ServiceException(ex.getMessage());
       }

    }

      
   
      
   

}
