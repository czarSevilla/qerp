package com.qacg.qerp.web.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import com.qacg.qerp.model.dto.SecUserDto;
import com.qacg.qerp.service.CrudService;

@ManagedBean(name = "secUserMB")
@ViewScoped
public class SecUserManagedBean extends CrudManagedBean<SecUserDto, Long> {

    @ManagedProperty("#{secUserService}")
    private CrudService<SecUserDto, Long> service;
    
    @PostConstruct
    public void init() {
        super.setList(service.findAll());
        super.setDto(new SecUserDto());
    }
    
    public void create() {
        super.setDto(new SecUserDto());
    }


    public CrudService<SecUserDto, Long> getService() {
        return service;
    }

    public void setService(CrudService<SecUserDto, Long> service) {
        this.service = service;
    }
    
    
}
