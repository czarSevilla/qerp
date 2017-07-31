package com.qacg.qerp.service.builder;

import org.springframework.beans.BeanUtils;

import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.model.dto.SecPermissionDto;
import com.qacg.qerp.persistence.entity.SecModule;
import com.qacg.qerp.persistence.entity.SecPermission;

public class SecPermissionBuilder {

    private SecPermissionBuilder() {
        // private Utils Builder class Constructor
    }
    
    public static final SecPermissionDto build(SecPermission secPermission) {
        SecPermissionDto dto = new SecPermissionDto();
        SecModuleDto moduleDto = new SecModuleDto();
        BeanUtils.copyProperties(secPermission, dto);
        BeanUtils.copyProperties(secPermission.getSecModule(), moduleDto);
        dto.setSecModule(moduleDto);
        return dto;               
    }
    
    public static final SecPermission build(SecPermissionDto dto) {
        SecPermission secPermission = new SecPermission();
        SecModule secModule = new SecModule();
        BeanUtils.copyProperties(dto, secPermission);
        BeanUtils.copyProperties(dto.getSecModule(), secModule);
        secPermission.setSecModule(secModule);
        return secPermission;
    }
}
