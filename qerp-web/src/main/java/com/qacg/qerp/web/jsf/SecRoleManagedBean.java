package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.model.dto.SecRoleDto;
import com.qacg.qerp.service.CrudService;
import com.qacg.qerp.service.SecRoleService;

@ManagedBean(name = "secRoleMB")
@ViewScoped
public class SecRoleManagedBean extends CrudManagedBean<SecRoleDto, Long> {

    
    @ManagedProperty("#{secRoleService}")
    private SecRoleService service;
    
    private List<SecModuleDto> modules;
    
    @PostConstruct
    public void init() {
        super.setList(service.findAll());
        super.setDto(new SecRoleDto());
        modules = service.findAllModules();
    }
    
    public void create() {
        super.setDto(new SecRoleDto());
    }

    public CrudService<SecRoleDto, Long> getService() {
        return this.service;
    }

    public void setService(CrudService<SecRoleDto, Long> service) {
        this.service = (SecRoleService) service;
    }

    public List<SecModuleDto> getModules() {
        return modules;
    }

    public void setModules(List<SecModuleDto> modules) {
        this.modules = modules;
    }
}
