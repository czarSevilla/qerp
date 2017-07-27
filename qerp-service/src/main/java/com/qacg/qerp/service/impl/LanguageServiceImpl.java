package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.LanguageDto;
import com.qacg.qerp.model.dto.LanguageDto;
import com.qacg.qerp.persistence.entity.Language;
import com.qacg.qerp.persistence.entity.Language;
import com.qacg.qerp.persistence.repository.LanguageRepository;
import com.qacg.qerp.service.LanguageService;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService {

	private LanguageRepository languageRepository;
	
	
	@Autowired
	public void setLanguageRepository(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<LanguageDto> findAll() {
		List<Language> entities = languageRepository.findAll();
		List<LanguageDto> dtos =  new ArrayList<>();
		for (Language entity : entities){
			LanguageDto dto = new LanguageDto();
			BeanUtils.copyProperties(entity, dto);
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public void save(LanguageDto languageDto) throws ServiceException {
		Language language = new Language();
		BeanUtils.copyProperties(languageDto, language);
		try{
			languageRepository.save(language);
		}catch(Exception ex){
			throw new ServiceException(ex.getMessage());
		}

	}

	@Override
	public void delete(Long idLanguage) throws ServiceException {
		try{
			languageRepository.delete(idLanguage);
		}catch(Exception ex){
			throw new ServiceException(ex.getMessage());
		}

	}

}
