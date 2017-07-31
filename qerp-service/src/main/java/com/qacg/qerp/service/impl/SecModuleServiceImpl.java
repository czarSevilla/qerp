package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.persistence.entity.SecModule;
import com.qacg.qerp.persistence.repository.SecModuleRepository;
import com.qacg.qerp.service.SecModuleService;
import com.qacg.qerp.service.builder.SecModuleBuilder;

@Service("secModuleService")
public class SecModuleServiceImpl implements SecModuleService {

    private SecModuleRepository secModuleRepository;
    
    @Autowired
    public void setSecModuleRepository(SecModuleRepository rep) {
        this.secModuleRepository = rep;
    }
    
    @Override
    public List<SecModuleDto> findAll() {
        List<SecModule> modules = secModuleRepository.findAll();
        List<SecModuleDto> dtos = new ArrayList<>();
        for (SecModule module : modules) {
            dtos.add(SecModuleBuilder.build(module));
        }
        return dtos;
    }

    @Override
    public void save(SecModuleDto secModuleDto) throws ServiceException {
        try {
            secModuleRepository.save(SecModuleBuilder.build(secModuleDto));
        } catch (DataAccessException dae) {
            throw new ServiceException(dae.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            secModuleRepository.delete(id);
        } catch (DataAccessException dae) {
            throw new ServiceException(dae.getMessage());
        }
    }

}
