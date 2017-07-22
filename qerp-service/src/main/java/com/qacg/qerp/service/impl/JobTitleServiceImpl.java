package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.JobTitleDto;
import com.qacg.qerp.persistence.entity.JobTitle;
import com.qacg.qerp.persistence.repository.JobTitleRepository;
import com.qacg.qerp.service.JobTitleService;

@Service("jobTitleService")
public class JobTitleServiceImpl implements JobTitleService {
	
	private JobTitleRepository jobTitleRepository;
	
	@Autowired
	public void setJobTitleRepository(JobTitleRepository jobTitleRepo) {
		this.jobTitleRepository = jobTitleRepo;
	}

	@Override
	public List<JobTitleDto> findAll() {
		List<JobTitle> entities = jobTitleRepository.findAll();
		List<JobTitleDto> dtos = new ArrayList<>(); 
		for (JobTitle entity : entities) {
			JobTitleDto dto = new JobTitleDto();
			BeanUtils.copyProperties(entity, dto);
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override
	public void save(JobTitleDto jobTitleDto) throws ServiceException {
		JobTitle jobTitle = new JobTitle();
		BeanUtils.copyProperties(jobTitleDto, jobTitle);
		try {
			jobTitleRepository.save(jobTitle);
		} catch (DataAccessException ex) {
			throw new ServiceException(ex.getMessage());
		}
		
	}

	@Override
	public void delete(Long idJobTitle) throws ServiceException {
		try {
			jobTitleRepository.delete(idJobTitle);
		} catch (DataAccessException ex) {
			throw new ServiceException(ex.getMessage());
		}
		
	}

}
