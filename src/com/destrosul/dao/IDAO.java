/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import com.destrosul.exception.BusinessException;
import java.util.List;

/**
 *
 * @author Leandro
 * @param <E>
 */
public interface IDAO<E> {
    
    E save(E entity) throws BusinessException;
    
    E findById(Long id);
    
    List<E> findAll();
    
    void remove(E entity) throws BusinessException;
}
