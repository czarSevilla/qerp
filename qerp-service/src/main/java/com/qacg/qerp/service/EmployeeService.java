package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.model.dto.EmployeeDto;

public interface EmployeeService {
    List<EmployeeDto> findAll();
}