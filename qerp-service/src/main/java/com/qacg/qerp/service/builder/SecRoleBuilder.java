package com.qacg.qerp.service.builder;

import org.springframework.beans.BeanUtils;

import com.qacg.qerp.model.dto.SecRoleDto;
import com.qacg.qerp.persistence.entity.SecRole;

public class SecRoleBuilder {

    private SecRoleBuilder() {
        // private default constructor
    }
    
    public static final SecRoleDto build(SecRole secRole) {
        SecRoleDto dto = new SecRoleDto();
        BeanUtils.copyProperties(secRole, dto);
        return dto;
    }
    
    public static final SecRole build(SecRoleDto dto) {
        SecRole secRole = new SecRole();
        BeanUtils.copyProperties(dto, secRole);
        return secRole;
    }
}
