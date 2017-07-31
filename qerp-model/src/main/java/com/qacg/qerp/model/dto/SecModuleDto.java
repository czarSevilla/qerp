package com.qacg.qerp.model.dto;

import java.io.Serializable;
import java.util.List;

public class SecModuleDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Long idSecModule;
    private String descriptionEsMx;
    private String descriptionEnUs;
    private List<SecPermissionDto> permissions;
    private List<String> selected;
    
    public Long getIdSecModule() {
        return idSecModule;
    }
    public void setIdSecModule(Long idSecModule) {
        this.idSecModule = idSecModule;
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
    public List<SecPermissionDto> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<SecPermissionDto> permissions) {
        this.permissions = permissions;
    }
    public List<String> getSelected() {
        return selected;
    }
    public void setSelected(List<String> selected) {
        this.selected = selected;
    }
}
