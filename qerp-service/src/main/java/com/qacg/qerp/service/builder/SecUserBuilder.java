package com.qacg.qerp.service.builder;

import org.springframework.beans.BeanUtils;

import com.qacg.qerp.model.dto.SecUserDto;
import com.qacg.qerp.persistence.entity.SecUser;

public class SecUserBuilder {

    private SecUserBuilder() {
        // private constructor
    }
    
    public static final SecUserDto build(SecUser secUser) {
        SecUserDto dto = new SecUserDto();
        BeanUtils.copyProperties(secUser, dto);
        return dto;
    }
    
    public static final SecUser build(SecUserDto dto) {
        SecUser secUser = new SecUser();
        BeanUtils.copyProperties(dto, secUser);
        return secUser;
    }
}
