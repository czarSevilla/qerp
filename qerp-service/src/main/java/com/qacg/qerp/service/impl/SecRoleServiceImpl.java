package com.qacg.qerp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.model.dto.SecPermissionDto;
import com.qacg.qerp.model.dto.SecRoleDto;
import com.qacg.qerp.persistence.entity.SecModule;
import com.qacg.qerp.persistence.entity.SecPermission;
import com.qacg.qerp.persistence.repository.SecModuleRepository;
import com.qacg.qerp.persistence.repository.SecPermissionRepository;
import com.qacg.qerp.persistence.repository.SecRoleRepository;
import com.qacg.qerp.service.SecRoleService;
import com.qacg.qerp.service.builder.SecModuleBuilder;
import com.qacg.qerp.service.builder.SecPermissionBuilder;
import com.qacg.qerp.service.builder.SecRoleBuilder;

@Service("secRoleService")
public class SecRoleServiceImpl implements SecRoleService {
    
    private SecRoleRepository secRoleRepository;
    
    private SecModuleRepository secModuleRepository;
    
    private SecPermissionRepository secPermissionRepository;
    
    @Autowired
    public void setSecRoleRepository(SecRoleRepository secRoleRepo) {
        this.secRoleRepository = secRoleRepo;
    }

    @Autowired
    public void setSecModuleRepository(SecModuleRepository secModuleRep) {
        this.secModuleRepository = secModuleRep;
    }
    
    @Autowired
    public void setSecPermissionRepository(SecPermissionRepository secPermissionRepository) {
        this.secPermissionRepository = secPermissionRepository;
    }
    
    @Override
    public List<SecRoleDto> findAll() {
        return secRoleRepository.findAll().stream()
                .map(SecRoleBuilder::build)
                .collect(Collectors.toList());
    }

    @Override
    public void save(SecRoleDto t) throws ServiceException {
        try {
            secRoleRepository.save(SecRoleBuilder.build(t));
        } catch (DataAccessException dae) {
            throw new ServiceException(dae.getMessage());
        }

    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            secRoleRepository.delete(id);
        } catch (DataAccessException dae) {
            throw new ServiceException(dae.getMessage());
        }
    }

    @Override
    public List<SecModuleDto> findAllModules() {
        List<SecModule> modules = secModuleRepository.findAll();
        List<SecModuleDto> dtos = new ArrayList<>();
        for (SecModule  module: modules) {
            List<SecPermission> permissions = secPermissionRepository.findAllByIdSecModule(module.getIdSecModule());
            SecModuleDto dto = SecModuleBuilder.build(module);
            List<SecPermissionDto> permissionsDtos = permissions.stream()
                    .map(SecPermissionBuilder::build).collect(Collectors.toList());
            dto.setPermissions(permissionsDtos);
            dto.setSelected(new ArrayList<>());
            dtos.add(dto);
        }
        return dtos;
    }

}
