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
public class PedidoDAO implements IDAO<Pedido>{
    
    private final EntityManager entityManager;
    
    public PedidoDAO() {
      entityManager = JPAUtil.getEntityManager();
    }
    
    @Override
    public Pedido save(Pedido pedido) {
         entityManager.getTransaction().begin();
        Pedido merged = entityManager.merge(pedido);
        entityManager.getTransaction().commit();
        entityManager.close();
        return merged;
    }

    @Override
    public Pedido findById(Long IdPedido) {
        Pedido pedido = entityManager.find(Pedido.class, IdPedido);
        entityManager.close();
        return pedido;
    }

    @Override
     public List<Pedido> findAll() {
        TypedQuery<Pedido> query = entityManager.createNamedQuery("Pedido.findAll", Pedido.class);
        List<Pedido> pedidos = query.getResultList();
        entityManager.close();
        return pedidos;
    }

    @Override
     public void remove(Pedido pedido) {
        entityManager.getTransaction().begin();
        entityManager.remove(pedido);
        entityManager.getTransaction().commit();
        entityManager.close();    
    }
    
    
    
    
    
}
