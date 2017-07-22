package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document_type")
public class DocumentType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idDocumentType;
	private String nameEsMx;
	private String nameEnUs;
	
	@Id
	@Column(name = "id_document_type")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdDocumentType() {
		return idDocumentType;
	}
	public void setIdDocumentType(Long idDocumentType) {
		this.idDocumentType = idDocumentType;
	}
	
	@Column(name = "name_es_mx", nullable = false)
	public String getNameEsMx() {
		return nameEsMx;
	}
	public void setNameEsMx(String nameEsMx) {
		this.nameEsMx = nameEsMx;
	}
	
	@Column(name = "name_en_us", nullable = false)
	public String getNameEnUs() {
		return nameEnUs;
	}
	public void setNameEnUs(String nameEnUs) {
		this.nameEnUs = nameEnUs;
	}
	
	
}
