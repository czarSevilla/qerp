package com.qacg.qerp.persistence.entity;

import java.io.Serializable;
import java.util.Locale;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qacg.qerp.model.dto.CompanyDto;

@Entity
@Table(name = "resource_feature")
public class ResourceFeature implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idResourceFeature;
	private PhysicalResourceType type;
	private String featureEnUs;
	private String featureEsMx;
	
	@Id
	@Column(name = "id_resource_feature")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdResourceFeature() {
		return idResourceFeature;
	}
	public void setIdResourceFeature(Long idResourceFeature) {
		this.idResourceFeature = idResourceFeature;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_physical_resource_type", referencedColumnName = "id_physical_resource_type")
	public PhysicalResourceType getType() {
		return type;
	}
	public void setType(PhysicalResourceType type) {
		this.type = type;
	}
	
	@Column (name = "feature_en_us", nullable = false)
	public String getFeatureEnUs() {
		return featureEnUs;
	}
	public void setFeatureEnUs(String featureEnUs) {
		this.featureEnUs = featureEnUs;
	}
	
	@Column (name = "feature_es_mx", nullable = false)
	public String getFeatureEsMx() {
		return featureEsMx;
	}
	public void setFeatureEsMx(String featureEsMx) {
		this.featureEsMx = featureEsMx;
	}
	


	
	
	
	

}
