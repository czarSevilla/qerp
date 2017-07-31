package com.qacg.qerp.persistence.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.qacg.qerp.persistence.entity.SecPermission;
import com.qacg.qerp.persistence.repository.SecPermissionCustomRepository;

public class SecPermissionRepositoryImpl implements SecPermissionCustomRepository {

   private EntityManager em;

   @PersistenceContext
   public void setEntityManager(EntityManager em) {
      this.em = em;
   }

   @Transactional
   @Override
   public void customSave(SecPermission secPermission) {
      StringBuilder sql = new StringBuilder();
      sql.append("insert into sec_permissions(id_sec_permission, id_sec_module, ");
      sql.append("description_es_mx, description_en_us, order_num) values(?, ?, ?, ?, ?)");
      Query query = em.createNativeQuery(sql.toString());
      int idx = 1;
      query.setParameter(idx++, secPermission.getIdSecPermission());
      query.setParameter(idx++, secPermission.getSecModule().getIdSecModule());
      query.setParameter(idx++, secPermission.getDescriptionEsMx());
      query.setParameter(idx++, secPermission.getDescriptionEnUs());
      query.setParameter(idx, secPermission.getOrder());
      query.executeUpdate();
   }

   @Transactional
   @Override
   public void customUpdate(SecPermission secPermission) {
      StringBuilder sql = new StringBuilder();
      sql.append("update sec_permissions set id_sec_module = ?, ");
      sql.append("description_es_mx = ?, description_en_us = ?, order_num = ? ");
      sql.append("where id_sec_permission = ?");
      Query query = em.createNativeQuery(sql.toString());
      int idx = 1;
      query.setParameter(idx++, secPermission.getSecModule().getIdSecModule());
      query.setParameter(idx++, secPermission.getDescriptionEsMx());
      query.setParameter(idx++, secPermission.getDescriptionEnUs());
      query.setParameter(idx++, secPermission.getOrder());
      query.setParameter(idx, secPermission.getIdSecPermission());
      query.executeUpdate();
   }

}
