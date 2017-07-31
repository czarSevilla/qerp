package com.qacg.qerp.web.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.model.dto.SecPermissionDto;
import com.qacg.qerp.service.CrudService;
import com.qacg.qerp.service.SecModuleService;

@ManagedBean(name = "secPermissionMB")
@ViewScoped
public class SecPermissionManagedBean extends CrudManagedBean<SecPermissionDto, String> {
    
    @ManagedProperty("#{secPermissionService}")
    private CrudService<SecPermissionDto, String> service;
    
    @ManagedProperty("#{secModuleService}")
    private SecModuleService secModuleService;
    
    private List<SecModuleDto> listModules;
    
    @PostConstruct
    public void init() {
        super.setList(service.findAll());
        SecPermissionDto dto = new SecPermissionDto();
        dto.setSecModule(new SecModuleDto());
        super.setDto(dto);
        listModules = secModuleService.findAll();
    }
    
    public void create() {
        SecPermissionDto dto = new SecPermissionDto();
        dto.setSecModule(new SecModuleDto());
        super.setDto(dto);
    }

    public CrudService<SecPermissionDto, String> getService() {
        return service;
    }

    public void setService(CrudService<SecPermissionDto, String> service) {
        this.service = service;
    }

    public SecModuleService getSecModuleService() {
        return secModuleService;
    }

    public void setSecModuleService(SecModuleService secModuleService) {
        this.secModuleService = secModuleService;
    }

    public List<SecModuleDto> getListModules() {
        return listModules;
    }

    public void setListModules(List<SecModuleDto> listModules) {
        this.listModules = listModules;
    }

   

}
