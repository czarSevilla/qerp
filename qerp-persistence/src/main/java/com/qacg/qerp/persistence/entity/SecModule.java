package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sec_modules")
public class SecModule implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long idSecModule;
    private String descriptionEsMx;
    private String descriptionEnUs;

    @Id
    @Column(name = "id_sec_module")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdSecModule() {
        return idSecModule;
    }

    public void setIdSecModule(Long idSecModule) {
        this.idSecModule = idSecModule;
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
