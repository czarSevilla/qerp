package com.qacg.qerp.model.dto;

import java.io.Serializable;


public class SecPermissionDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idSecPermission;
    private SecModuleDto secModule;
    private String descriptionEsMx;
    private String descriptionEnUs;
    private Integer order;
    
    public String getIdSecPermission() {
        return idSecPermission;
    }
    public void setIdSecPermission(String idSecPermission) {
        this.idSecPermission = idSecPermission;
    }
    public SecModuleDto getSecModule() {
        return secModule;
    }
    public void setSecModule(SecModuleDto secModule) {
        this.secModule = secModule;
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
    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }
}
