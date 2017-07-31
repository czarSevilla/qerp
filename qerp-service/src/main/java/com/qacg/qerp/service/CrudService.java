package com.qacg.qerp.service;

import java.util.List;

import com.qacg.qerp.exception.ServiceException;

public interface CrudService<T, I> {
    
    List<T> findAll();
    
    void save(T t) throws ServiceException;
    
    void delete(I id) throws ServiceException;
}
