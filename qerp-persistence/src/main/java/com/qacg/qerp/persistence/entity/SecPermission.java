package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sec_permissions")
public class SecPermission implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idSecPermission;
    private SecModule secModule;
    private String descriptionEsMx;
    private String descriptionEnUs;
    private Integer order;
    
    @Id
    @Column(name = "id_sec_permission")
    public String getIdSecPermission() {
        return idSecPermission;
    }
    public void setIdSecPermission(String idSecPermission) {
        this.idSecPermission = idSecPermission;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sec_module")
    public SecModule getSecModule() {
        return secModule;
    }
    public void setSecModule(SecModule secModule) {
        this.secModule = secModule;
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
    @Column(name = "order_num", nullable = false)
    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }
}
