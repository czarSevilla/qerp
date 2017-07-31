package com.qacg.qerp.service.builder;

import org.springframework.beans.BeanUtils;

import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.persistence.entity.SecModule;

public class SecModuleBuilder {
    
    private SecModuleBuilder() {
        // private constructor 'couse it's utils builder class
    }

    public static final SecModuleDto build(SecModule module) {
        SecModuleDto dto = new SecModuleDto();
        BeanUtils.copyProperties(module, dto);
        return dto;
    }
    
    public static final SecModule build(SecModuleDto dto) {
        SecModule module = new SecModule();
        BeanUtils.copyProperties(dto, module);
        return module;
    }
}
