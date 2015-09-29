/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import com.destrosul.entity.Pedido;
import com.destrosul.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Leandro
 */
public class PedidoDAOImp implements PedidoDAO<Pedido> {
    
    private final EntityManager entityManager;

    public ClienteDAOImp() {
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
    public Cliente findByID(Integer codigo) {
        return entityManager.find(Cliente.class, codigo);
    }

    @Override
    public List<Cliente> findAll() {
        TypedQuery<Cliente> query = entityManager.createQuery("from cliente", Cliente.class);
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }    
    
    
}
