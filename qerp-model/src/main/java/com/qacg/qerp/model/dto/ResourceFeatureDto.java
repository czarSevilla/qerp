package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class ResourceFeatureDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idResourceFeature;
	private PhysicalResourceTypeDto type;
	private String featureEnUs;
	private String featureEsMx;
	
	
	public Long getIdResourceFeature() {
		return idResourceFeature;
	}
	public void setIdResourceFeature(Long idResourceFeature) {
		this.idResourceFeature = idResourceFeature;
	}
	public PhysicalResourceTypeDto getType() {
		return type;
	}
	public void setType(PhysicalResourceTypeDto type) {
		this.type = type;
	}
	public String getFeatureEnUs() {
		return featureEnUs;
	}
	public void setFeatureEnUs(String featureEnUs) {
		this.featureEnUs = featureEnUs;
	}
	public String getFeatureEsMx() {
		return featureEsMx;
	}
	public void setFeatureEsMx(String featureEsMx) {
		this.featureEsMx = featureEsMx;
	}

	
	
	

	
	
}
