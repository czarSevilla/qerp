package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class PhysicalResourceHasFeatureDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPhysicalResourceHasFeature;
	private PhysicalResourceDto physicalResource;
	private ResourceFeatureDto resourceFeature;
	private String value;
	
	
	public Long getIdPhysicalResourceHasFeature() {
		return idPhysicalResourceHasFeature;
	}
	public void setIdPhysicalResourceHasFeature(Long idPhysicalResourceHasFeature) {
		this.idPhysicalResourceHasFeature = idPhysicalResourceHasFeature;
	}
	public PhysicalResourceDto getPhysicalResource() {
		return physicalResource;
	}
	public void setPhysicalResource(PhysicalResourceDto physicalResource) {
		this.physicalResource = physicalResource;
	}
	public ResourceFeatureDto getResourceFeature() {
		return resourceFeature;
	}
	public void setResourceFeature(ResourceFeatureDto resourceFeature) {
		this.resourceFeature = resourceFeature;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
