package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource_feature")
public class ResourceFeature implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idResourceFeature;
	private PhysicalResourceType type;
	private String feature;
	
	@Id
	@Column(name = "id_resource_feature")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdResourceFeature() {
		return idResourceFeature;
	}
	public void setIdResourceFeature(Long idResourceFeature) {
		this.idResourceFeature = idResourceFeature;
	}
	/*
	@Ma
	@JoinColumn
	public PhysicalResourceType getType() {
		return type;
	}
	public void setType(PhysicalResourceType type) {
		this.type = type;
	}*/
	
	@Column(name = "feature", nullable = false	)
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	
	
	

}
