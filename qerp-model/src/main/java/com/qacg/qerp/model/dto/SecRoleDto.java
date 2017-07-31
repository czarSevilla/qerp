package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class SecRoleDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Long idSecRole;
    private String descriptionEsMx;
    private String descriptionEnUs;
    
    public Long getIdSecRole() {
        return idSecRole;
    }
    public void setIdSecRole(Long idSecRole) {
        this.idSecRole = idSecRole;
    }
    public String getDescriptionEsMx() {
        return descriptionEsMx;
    }
    public void setDescriptionEsMx(String descriptionEsMx) {
        this.descriptionEsMx = descriptionEsMx;
    }
    public String getDescriptionEnUs() {
        return descriptionEnUs;
    }
    public void setDescriptionEnUs(String descriptionEnUs) {
        this.descriptionEnUs = descriptionEnUs;
    }
}
