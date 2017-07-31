package com.qacg.qerp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qacg.qerp.exception.ServiceException;
import com.qacg.qerp.model.dto.SecPermissionDto;
import com.qacg.qerp.persistence.entity.SecPermission;
import com.qacg.qerp.persistence.repository.SecPermissionRepository;
import com.qacg.qerp.service.SecPermissionService;
import com.qacg.qerp.service.builder.SecPermissionBuilder;

@Service("secPermissionService")
public class SecPermissionServiceImpl implements SecPermissionService {

   private SecPermissionRepository secPermissionRepository;

   @Autowired
   public void setSecPermissionRepository(SecPermissionRepository secPermissionRepo) {
      this.secPermissionRepository = secPermissionRepo;
   }

   @Override
   public List<SecPermissionDto> findAll() {
      List<SecPermission> list = secPermissionRepository.findAll();
      return list.stream().map(SecPermissionBuilder::build).collect(Collectors.toList());
   }

   @Transactional
   @Override
   public void save(SecPermissionDto t) throws ServiceException {
      SecPermission permissionDb = secPermissionRepository.findOne(t.getIdSecPermission());
      try {
         SecPermission permission = SecPermissionBuilder.build(t);
         if (permissionDb == null) {
            secPermissionRepository.customSave(permission);
         } else {
            secPermissionRepository.customUpdate(permission);
         }
      } catch (DataAccessException dae) {
         throw new ServiceException(dae.getMessage());
      }
   }

   @Transactional
   @Override
   public void delete(String id) throws ServiceException {
      try {
         secPermissionRepository.delete(id);
      } catch (DataAccessException dae) {
         throw new ServiceException(dae.getMessage());
      }
   }

}
