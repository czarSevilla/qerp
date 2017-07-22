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
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.persistence.entity.JobTitle;
import com.qacg.qerp.persistence.repository.JobTitleRepository;
import com.qacg.qerp.service.impl.JobTitleServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class JobTitleServiceTest {

	@InjectMocks
	private JobTitleServiceImpl jobTitleService;

	@Mock
	private JobTitleRepository jobTitleRepository;
	
	@Mock
	private DataAccessException exception;

	@Test
	public void findAllTest() {
		when(jobTitleRepository.findAll()).thenReturn(Arrays.asList(new JobTitle()));

		jobTitleService.findAll();

		verify(jobTitleRepository, atLeastOnce()).findAll();
	}

	@Test
	public void saveTest() throws Exception {
		JobTitleDto jobTitleDto = new JobTitleDto();
		when(jobTitleRepository.save(any(JobTitle.class))).thenReturn(null);

		jobTitleService.save(jobTitleDto);

		verify(jobTitleRepository, atLeastOnce()).save(any(JobTitle.class));
	}
	
	@Test(expected = ServiceException.class)
	public void failSaveTest() throws Exception {
		doThrow(exception).when(jobTitleRepository).save(any(JobTitle.class));
		
		jobTitleService.save(new JobTitleDto());
	}

	@Test
	public void deleteTest() throws Exception {
		Long idJobTitle = 1L;

		jobTitleService.delete(idJobTitle);

		verify(jobTitleRepository, atLeastOnce()).delete(idJobTitle);
	}
	
	@Test(expected = ServiceException.class)
	public void failDeleteTest() throws Exception {
		Long idJobTitle = 2L;
		doThrow(exception).when(jobTitleRepository).delete(idJobTitle);
		
		jobTitleService.delete(idJobTitle);
	}
}
