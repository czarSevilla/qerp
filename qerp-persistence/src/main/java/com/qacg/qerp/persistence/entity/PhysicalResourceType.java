package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "physical_resource_type")
public class PhysicalResourceType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPhysicalResourceType;
	private String nameEsMx;
	private String nameEnUs;
	private String picture;
	
	
	@Id
	@Column(name = "id_physical_resource_type")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdPhysicalResourceType() {
		return idPhysicalResourceType;
	}
	public void setIdPhysicalResourceType(Long idPhysicalResourceType) {
		this.idPhysicalResourceType = idPhysicalResourceType;
	}
	
	@Column(name = "name_es_mx", nullable = false)
	public String getNameEsMx() {
		return nameEsMx;
	}
	public void setNameEsMx(String nameEsMx) {
		this.nameEsMx = nameEsMx;
	}
	
	@Column(name = "name_en_us", nullable =  false)
	public String getNameEnUs() {
		return nameEnUs;
	}
	public void setNameEnUs(String nameEnUs) {
		this.nameEnUs = nameEnUs;
	}
	
	@Column(name = "picture", nullable = false)
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
	

}
