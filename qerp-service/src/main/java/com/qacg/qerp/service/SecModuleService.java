package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.SecModuleDto;

public interface SecModuleService extends CrudService<SecModuleDto, Long> {

    List<SecModuleDto> findAll();
    
    void save(SecModuleDto secModuleDto) throws ServiceException;
    
    void delete(Long id) throws ServiceException;
}
