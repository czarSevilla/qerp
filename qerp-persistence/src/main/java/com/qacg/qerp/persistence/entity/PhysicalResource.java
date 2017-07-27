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
@Table(name = "physical_resource")
public class PhysicalResource  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPhysicalResource;
	//private Long idCompany;
	private PhysicalResourceType pRType;
	private Company company;
	//private Long idPhysicalResourceType;
	
	@Id
	@Column(name ="id_physical_resource")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdPhysicalResource() {
		return idPhysicalResource;
	}
	public void setIdPhysicalResource(Long idPhysicalResource) {
		this.idPhysicalResource = idPhysicalResource;
	}
	/*
	@Column(name = "id_company", nullable = false)
	public Long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}*/
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_physical_resource_type")
	public PhysicalResourceType getpRType() {
		return pRType;
	}
	public void setpRType(PhysicalResourceType pRType) {
		this.pRType = pRType;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_company")
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
	
	
	/*@Column(name = "id_physical_resource_type", nullable = false)
	public Long getIdPhysicalResourceType() {
		return idPhysicalResourceType;
	}
	public void setIdPhysicalResourceType(Long idPhysicalResourceType) {
		this.idPhysicalResourceType = idPhysicalResourceType;
	}*/
	
	

}
