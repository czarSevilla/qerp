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
import com.qacg.qerp.model.dto.DocumentTypeDto;
import com.qacg.qerp.model.dto.DocumentTypeDto;
import com.qacg.qerp.persistence.entity.DocumentType;
import com.qacg.qerp.persistence.entity.DocumentType;
import com.qacg.qerp.persistence.repository.DocumentTypeRepository;
import com.qacg.qerp.persistence.repository.DocumentTypeRepository;
import com.qacg.qerp.service.impl.DocumentTypeServiceImpl;
import com.qacg.qerp.service.impl.DocumentTypeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DocumentTypeTest {
	
	
	

		@InjectMocks
		private DocumentTypeServiceImpl documentService;
		
		@Mock
		private DocumentTypeRepository documentRepository;
		
		@Mock
		private DataAccessException exception;

		@Test
		public void findAllTest() {
			when(documentRepository.findAll()).thenReturn(Arrays.asList(new DocumentType()));

			documentService.findAll();

			verify(documentRepository, atLeastOnce()).findAll();
		}

		
		@Test
		public void saveTest() throws Exception {
			DocumentTypeDto documentDto = new DocumentTypeDto();
			when(documentRepository.save(any(DocumentType.class))).thenReturn(null);

			documentService.save(documentDto);

			verify(documentRepository, atLeastOnce()).save(any(DocumentType.class));
		}
		
		@Test(expected = ServiceException.class)
		public void failSaveTest() throws Exception {
			doThrow(exception).when(documentRepository).save(any(DocumentType.class));
			
			documentService.save(new DocumentTypeDto());
		}

		@Test
		public void deleteTest() throws Exception {
			Long iddocument = 1L;

			documentService.delete(iddocument);

			verify(documentRepository, atLeastOnce()).delete(iddocument);
		}
		
		@Test(expected = ServiceException.class)
		public void failDeleteTest() throws Exception {
			Long iddocument = 2L;
			doThrow(exception).when(documentRepository).delete(iddocument);
			
			documentService.delete(iddocument);
		}
	}



