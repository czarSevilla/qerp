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
import com.qacg.qerp.model.dto.LanguageDto;
import com.qacg.qerp.persistence.entity.Language;
import com.qacg.qerp.persistence.repository.LanguageRepository;
import com.qacg.qerp.service.impl.LanguageServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LanguagesServiceTest {
   
   @InjectMocks
   private LanguageServiceImpl languageService;
   
   @Mock
   private LanguageRepository languageRepository;
   
   @Mock
   private DataAccessException exception;

   @Test
   public void findAllTest() {
        when(languageRepository.findAll()).thenReturn(Arrays.asList(new Language()));

        languageService.findAll();

        verify(languageRepository, atLeastOnce()).findAll();
   }

   
   @Test
   public void saveTest() throws Exception {
        LanguageDto languageDto = new LanguageDto();
        when(languageRepository.save(any(Language.class))).thenReturn(null);

        languageService.save(languageDto);

        verify(languageRepository, atLeastOnce()).save(any(Language.class));
   }
   
   @Test(expected = ServiceException.class)
   public void failSaveTest() throws Exception {
        doThrow(exception).when(languageRepository).save(any(Language.class));
        
        languageService.save(new LanguageDto());
   }

   @Test
   public void deleteTest() throws Exception {
        Long idLanguage = 1L;

        languageService.delete(idLanguage);

        verify(languageRepository, atLeastOnce()).delete(idLanguage);
   }
   
   @Test(expected = ServiceException.class)
   public void failDeleteTest() throws Exception {
        Long idLanguage = 2L;
        doThrow(exception).when(languageRepository).delete(idLanguage);
        
        languageService.delete(idLanguage);
   }

}
