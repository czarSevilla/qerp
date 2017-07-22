package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.DocumentTypeDto;

public interface DocumentTypeService {

	List<DocumentTypeDto> findAll();
	
	void save(DocumentTypeDto documentTypeDto) throws ServiceException;
	
	void delete(Long idDocumentType) throws ServiceException;
}
