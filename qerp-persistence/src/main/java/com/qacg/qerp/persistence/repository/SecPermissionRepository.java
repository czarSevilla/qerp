package com.qacg.qerp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qacg.qerp.persistence.entity.SecPermission;

public interface SecPermissionRepository extends JpaRepository<SecPermission, String>, SecPermissionCustomRepository {
    
    @Query("select p from SecPermission p where p.secModule.idSecModule = ? order by p.order")
    List<SecPermission> findAllByIdSecModule(Long idSecModule);
}
