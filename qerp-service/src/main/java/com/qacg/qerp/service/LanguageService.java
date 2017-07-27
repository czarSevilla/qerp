package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.LanguageDto;

public interface LanguageService {
	
	
	List<LanguageDto> findAll();
	
	void save(LanguageDto LanguageDto) throws ServiceException;
	
	void delete(Long idLanguage) throws ServiceException;
}


