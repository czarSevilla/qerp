package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sec_roles")
public class SecRole implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idSecRole;
    private String descriptionEsMx;
    private String descriptionEnUs;
    
    @Id
    @Column(name = "id_sec_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdSecRole() {
        return idSecRole;
    }
    public void setIdSecRole(Long idSecRole) {
        this.idSecRole = idSecRole;
    }
    @Column(name = "description_es_mx", nullable = false)
    public String getDescriptionEsMx() {
        return descriptionEsMx;
    }
    public void setDescriptionEsMx(String descriptionEsMx) {
        this.descriptionEsMx = descriptionEsMx;
    }
    @Column(name = "description_en_us", nullable = false)
    public String getDescriptionEnUs() {
        return descriptionEnUs;
    }
    public void setDescriptionEnUs(String descriptionEnUs) {
        this.descriptionEnUs = descriptionEnUs;
    }
}
