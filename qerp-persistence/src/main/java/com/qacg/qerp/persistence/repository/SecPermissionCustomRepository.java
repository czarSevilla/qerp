package com.qacg.qerp.persistence.repository;

import com.qacg.qerp.persistence.entity.SecPermission;

public interface SecPermissionCustomRepository {

    void customSave(SecPermission secPermision);
    
    void customUpdate(SecPermission secPermission);
}
