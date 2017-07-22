package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class PhysicalResourceTypeDto implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPhysicalResourceType;
	private String nameEsMx;
	private String nameEnUs;
	private String picture;
	
	
	public Long getIdPhysicalResourceType() {
		return idPhysicalResourceType;
	}
	public void setIdPhysicalResourceType(Long idPhysicalResourceType) {
		this.idPhysicalResourceType = idPhysicalResourceType;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}
