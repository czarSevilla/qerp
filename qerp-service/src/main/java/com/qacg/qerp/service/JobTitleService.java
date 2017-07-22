package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.JobTitleDto;

public interface JobTitleService {
	List<JobTitleDto> findAll();
	
	void save(JobTitleDto jobTitleDto) throws ServiceException;
	
	void delete(Long idJobTitle) throws ServiceException;
}
