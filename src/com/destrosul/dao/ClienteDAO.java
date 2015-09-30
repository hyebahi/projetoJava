/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import java.util.List;
import com.destrosul.util.JPAUtil;
import com.destrosul.entity.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Leandro
 */
public class ClienteDAO implements IDAO<Cliente> {

    private final EntityManager entityManager;

    public ClienteDAO() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public Cliente save(Cliente cliente) {
        entityManager.getTransaction().begin();
        Cliente merged = entityManager.merge(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
        return merged;
    }

    @Override
    public void remove(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Cliente findById(Long codigo) {
        Cliente cliente = entityManager.find(Cliente.class, codigo);
        entityManager.close();
        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        TypedQuery<Cliente> query = entityManager.createNamedQuery("Cliente.findAll", Cliente.class);
        List<Cliente> clientes = query.getResultList();
        entityManager.close();
        return clientes;
    }

}
