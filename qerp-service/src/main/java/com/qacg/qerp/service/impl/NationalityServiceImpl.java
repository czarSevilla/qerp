package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.GenderDto;
import com.qacg.qerp.model.dto.NationalityDto;
import com.qacg.qerp.persistence.entity.Gender;
import com.qacg.qerp.persistence.entity.Nationality;
import com.qacg.qerp.persistence.repository.NationalityRepository;
import com.qacg.qerp.service.NationalityService;

public class NationalityServiceImpl implements NationalityService{

   private NationalityRepository nationalityRepository;
   
   @Autowired
   public final void setNationalityRepository(NationalityRepository nationalityRepository) {
      this.nationalityRepository = nationalityRepository;
   }

   @Override
   public List<NationalityDto> findAll() {
      List<Nationality> entities = nationalityRepository.findAll();
      List<NationalityDto> dtos = new ArrayList<>(); 
      for (Nationality entity : entities) {
           NationalityDto dto = new NationalityDto();
           BeanUtils.copyProperties(entity, dto);
           dtos.add(dto);
      }
      return dtos;
   }

   @Override
   public void save(NationalityDto t) throws ServiceException {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void delete(Long id) throws ServiceException {
      // TODO Auto-generated method stub
      
   }

}