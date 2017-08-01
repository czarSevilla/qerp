package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "physical_resource_has_feature")
public class PhysicalResourceHasFeature implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPhysicalResourceHasFeature;
	private PhysicalResource physicalResource;
	private ResourceFeature resourceFeature;
	private String value;
	
	
	@Id
	@Column(name = "id_physical_resource_has_feature")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdPhysicalResourceHasFeature() {
		return idPhysicalResourceHasFeature;
	}
	public void setIdPhysicalResourceHasFeature(Long idPhysicalResourceHasFeature) {
		this.idPhysicalResourceHasFeature = idPhysicalResourceHasFeature;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_physical_resource", referencedColumnName = "id_physical_resource")
	public PhysicalResource getPhysicalResource() {
		return physicalResource;
	}
	public void setPhysicalResource(PhysicalResource physicalResource) {
		this.physicalResource = physicalResource;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="id_resource_feature", referencedColumnName = "id_resource_feature")	
	public ResourceFeature getResourceFeature() {
		return resourceFeature;
	}
	public void setResourceFeature(ResourceFeature resourceFeature) {
		this.resourceFeature = resourceFeature;
	}
	
	@Column(name = "value", nullable = false)
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
