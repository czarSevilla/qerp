package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.DocumentTypeDto;
import com.qacg.qerp.persistence.entity.DocumentType;
import com.qacg.qerp.persistence.repository.DocumentTypeRepository;
import com.qacg.qerp.service.DocumentTypeService;

@Service("documentTypeService")
public class DocumentTypeServiceImpl implements DocumentTypeService {

	private DocumentTypeRepository documentTypeRepository;
	
	@Autowired
	public void setDocumentTypeRepository(DocumentTypeRepository documentTypeRepository) {
		this.documentTypeRepository = documentTypeRepository;
	}

	@Override
	public List<DocumentTypeDto> findAll() {
		List<DocumentTypeDto> documentsDto = new ArrayList<>();
		List<DocumentType> documents = documentTypeRepository.findAll();
		for(DocumentType document : documents){
			DocumentTypeDto documentDto = new DocumentTypeDto();
			BeanUtils.copyProperties(document, documentDto);
			documentsDto.add(documentDto);

		}
		
		return documentsDto;
	}

	@Override
	public void save(DocumentTypeDto documentTypeDto) throws ServiceException{
		DocumentType documentType= new DocumentType();
		BeanUtils.copyProperties(documentTypeDto, documentType);
		try{
			documentTypeRepository.save(documentType);
		}catch(Exception ex){
			throw new ServiceException(ex.getMessage());
		}

	}

	@Override
	public void delete(Long idDocumentType) throws ServiceException{
		try{
			documentTypeRepository.delete(idDocumentType);
		}catch(Exception ex){
			throw new ServiceException(ex.getMessage());
		}
	}

}
