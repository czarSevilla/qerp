package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_title")
public class JobTitle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idJobTitle;
	private String titleEsMx;
	private String titleEnUs;
	
	@Id
	@Column(name = "id_job_title")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdJobTitle() {
		return idJobTitle;
	}
	public void setIdJobTitle(Long idJobTitle) {
		this.idJobTitle = idJobTitle;
	}
	@Column(name = "title_es_mx", nullable = false)
	public String getTitleEsMx() {
		return titleEsMx;
	}
	public void setTitleEsMx(String titleEsMx) {
		this.titleEsMx = titleEsMx;
	}
	
	@Column(name = "title_en_us", nullable = false)
	public String getTitleEnUs() {
		return titleEnUs;
	}
	public void setTitleEnUs(String titleEnUs) {
		this.titleEnUs = titleEnUs;
	}
	
	
}
