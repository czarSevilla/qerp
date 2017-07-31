package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.model.dto.SecModuleDto;
import com.qacg.qerp.model.dto.SecRoleDto;

public interface SecRoleService extends CrudService<SecRoleDto, Long> {

    List<SecModuleDto> findAllModules();
}
