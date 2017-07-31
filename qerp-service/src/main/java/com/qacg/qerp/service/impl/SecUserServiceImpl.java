package com.qacg.qerp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.SecUserDto;
import com.qacg.qerp.persistence.repository.SecUserRepository;
import com.qacg.qerp.service.SecUserService;
import com.qacg.qerp.service.builder.SecUserBuilder;

@Service("secUserService")
public class SecUserServiceImpl implements SecUserService {

    private SecUserRepository secUserRepository;
    
    @Autowired
    public void setSecUserRepository(SecUserRepository secUserRepository) {
        this.secUserRepository = secUserRepository;
    }
    
    @Override
    public List<SecUserDto> findAll() {
        return secUserRepository.findAll().stream()
                .map(d -> SecUserBuilder.build(d))
                .collect(Collectors.toList());
    }

    @Override
    public void save(SecUserDto t) throws ServiceException {
        try {
            secUserRepository.save(SecUserBuilder.build(t));
        } catch (DataAccessException dae) {
            throw new ServiceException(dae.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            secUserRepository.delete(id);
        } catch (DataAccessException dae) {
            throw new ServiceException(dae.getMessage());
        }
    }

}
