package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.DocumentTypeDto;
import com.qacg.qerp.service.DocumentTypeService;
import com.qacg.qerp.web.util.MessageUtils;

@ManagedBean(name = "documentMB")
@ViewScoped
public class DocumentTypeManagedBean {

	@ManagedProperty("#{documentTypeService}")
	private DocumentTypeService documentService;
	
	private List<DocumentTypeDto> documentsDto;
	private DocumentTypeDto document;
	private Long idDocument;
	
	
	public DocumentTypeService getDocumentService() {
		return documentService;
	}
	public void setDocumentService(DocumentTypeService documentService) {
		this.documentService = documentService;
	}
	public List<DocumentTypeDto> getDocumentsDto() {
		return documentsDto;
	}
	public void setDocumentsDto(List<DocumentTypeDto> documentsDto) {
		this.documentsDto = documentsDto;
	}
	public DocumentTypeDto getDocument() {
		return document;
	}
	public void setDocument(DocumentTypeDto document) {
		this.document = document;
	}
	public Long getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}
	
	public void create(){
		document = new DocumentTypeDto();
	}
	
	public void save(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			documentService.save(document);
			documentsDto = documentService.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
		
	}
	
	public void delete(Long idDocument){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			documentService.delete(idDocument);
			documentsDto = documentService.findAll();
			ctx.addMessage(null, MessageUtils.success(ctx, "success.detail"));
		}catch(ServiceException se){
			ctx.addMessage(null, MessageUtils.error(ctx, se.getMessage()));
		}
	}
	
}
