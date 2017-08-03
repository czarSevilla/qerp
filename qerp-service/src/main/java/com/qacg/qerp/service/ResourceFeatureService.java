package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.PhysicalResourceDto;
import com.qacg.qerp.model.dto.ResourceFeatureDto;

public interface ResourceFeatureService {

   List<ResourceFeatureDto> findAll();

   void save(ResourceFeatureDto resourceFeatureDto) throws ServiceException;

   void delete(Long idResourceFeature) throws ServiceException;

   ResourceFeatureDto findOne(Long idResourceFeature) throws ServiceException;
   
   PhysicalResourceDto findAllById(Long idType) throws ServiceException;
}
