package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.GenderDto;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.persistence.entity.Gender;
import com.qacg.qerp.persistence.entity.JobTitle;
import com.qacg.qerp.persistence.repository.GenderRepository;
import com.qacg.qerp.service.GenderService;

public class GenderServiceImpl implements GenderService{

   GenderRepository genderRepository;
   
   @Autowired
   public final void setGenderRepository(GenderRepository genderRepository) {
      this.genderRepository = genderRepository;
   }
   
   @Override
   public List<GenderDto> findAll() {
      List<Gender> entities = genderRepository.findAll();
      List<GenderDto> dtos = new ArrayList<>(); 
      for (Gender entity : entities) {
           GenderDto dto = new GenderDto();
           BeanUtils.copyProperties(entity, dto);
           dtos.add(dto);
      }
      return dtos;
   }

   @Override
   public void save(GenderDto t) throws ServiceException {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void delete(Long id) throws ServiceException {
      // TODO Auto-generated method stub
      
   }

}
