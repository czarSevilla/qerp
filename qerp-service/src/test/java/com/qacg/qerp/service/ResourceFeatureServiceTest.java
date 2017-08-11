package com.qacg.qerp.service;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;

import com.qacg.qerp.persistence.entity.ResourceFeature;
import com.qacg.qerp.persistence.repository.ResourceFeatureRepository;
import com.qacg.qerp.service.impl.ResourceFeatureServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ResourceFeatureServiceTest {

   @InjectMocks
   private ResourceFeatureServiceImpl resourceService;
   
   @Mock
   private ResourceFeatureRepository resourceRepository;
   
   @Mock
   private DataAccessException exception;
   
   @Test
   public void findAllTest(){
      when(resourceRepository.findAll()).thenReturn(Arrays.asList(new ResourceFeature()));
      resourceService.findAll();
      verify(resourceRepository,atLeastOnce()).findAll();      
   }
}
