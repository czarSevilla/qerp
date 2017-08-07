package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.model.dto.MaritalStatusDto;
import com.qacg.qerp.persistence.entity.JobTitle;
import com.qacg.qerp.persistence.entity.MaritalStatus;
import com.qacg.qerp.persistence.repository.JobTitleRepository;
import com.qacg.qerp.persistence.repository.MaritalStatusRepository;
import com.qacg.qerp.service.MaritalStatusService;

public class MaritalStatusServiceImpl implements MaritalStatusService {

   MaritalStatusRepository maritalRepository;
   
   @Autowired
   public void setMaritalRepository(MaritalStatusRepository maritalRepository) {
        this.maritalRepository = maritalRepository;
   }
   
   @Override
   public List<MaritalStatusDto> findAll() {
      List<MaritalStatus> status = maritalRepository.findAll();
      List<MaritalStatusDto> dtos = new ArrayList<>(); 
      for (MaritalStatus statu : status) {
           MaritalStatusDto dto = new MaritalStatusDto();
           BeanUtils.copyProperties(statu, dto);
           dtos.add(dto);
      }
      return dtos;
   }

   @Override
   public void save(MaritalStatusDto t) throws ServiceException {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void delete(Long id) throws ServiceException {
      // TODO Auto-generated method stub
      
   }

}
