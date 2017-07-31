package com.qacg.qerp.web.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.service.CrudService;

@ManagedBean(name = "secModuleMB")
@ViewScoped
public class SecModuleManagedBean extends CrudManagedBean<SecModuleDto, Long> {

    
    @ManagedProperty("#{secModuleService}")
    private CrudService<SecModuleDto, Long> service;
    
    @PostConstruct
    public void init() {
        super.setList(service.findAll());
        super.setDto(new SecModuleDto());
    }
    
    public void create() {
        super.setDto(new SecModuleDto());
    }

    public CrudService<SecModuleDto, Long> getService() {
        return this.service;
    }

    public void setService(CrudService<SecModuleDto, Long> service) {
        this.service = service;
    }
}
