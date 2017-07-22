package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class DocumentTypeDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idDocumentType;
	private String nameEsMx;
	private String nameEnUs;
	
	
	public Long getIdDocumentType() {
		return idDocumentType;
	}
	public void setIdDocumentType(Long idDocumentType) {
		this.idDocumentType = idDocumentType;
	}
	public String getNameEsMx() {
		return nameEsMx;
	}
	public void setNameEsMx(String nameEsMx) {
		this.nameEsMx = nameEsMx;
	}
	public String getNameEnUs() {
		return nameEnUs;
	}
	public void setNameEnUs(String nameEnUs) {
		this.nameEnUs = nameEnUs;
	}

	
	
}
