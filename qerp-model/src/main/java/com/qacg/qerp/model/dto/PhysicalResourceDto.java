package com.qacg.qerp.model.dto;

import java.io.Serializable;
import java.util.List;

public class PhysicalResourceDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPhysicalResource;

	private CompanyDto company;

	private PhysicalResourceTypeDto pRType;
	private List<PhysicalResourceHasFeatureDto> features;
	
	
	public Long getIdPhysicalResource() {
		return idPhysicalResource;
	}
	public void setIdPhysicalResource(Long idPhysicalResource) {
		this.idPhysicalResource = idPhysicalResource;
	}

	
	public PhysicalResourceTypeDto getpRType() {
		return pRType;
	}
	public void setpRType(PhysicalResourceTypeDto pRType) {
		this.pRType = pRType;
	}
	public CompanyDto getCompany() {
		return company;
	}
	public void setCompany(CompanyDto company) {
		this.company = company;
	}
	public List<PhysicalResourceHasFeatureDto> getFeatures() {
		return features;
	}
	public void setFeatures(List<PhysicalResourceHasFeatureDto> features) {
		this.features = features;
	}
	
	
	
	

}
