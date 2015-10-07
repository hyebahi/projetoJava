/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import com.destrosul.entity.Pedido;
import com.destrosul.entity.Usuario;
import com.destrosul.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Leandro
 */
public class PedidoDAO implements IDAO<Pedido>{
    
    private final EntityManager Manager;
    
    public PedidoDAO() {
      Manager = JPAUtil.getEntityManager();
    }
    
    @Override
    public Pedido save(Pedido pedido) {
         Manager.getTransaction().begin();
        Pedido merged = Manager.merge(pedido);
        Manager.getTransaction().commit();
        Manager.close();
        return merged;
    }
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Pedido findById(Long id) {
        Pedido pedido = Manager.find(Pedido.class, id);
        Manager.close();
        return pedido;
    }

    /**
     *
     * @return
     */
    @Override
     public List<Pedido> findAll() {
        //TypedQuery<Pedido> query = Manager.createNamedQuery("Pedido.findAll", Pedido.class);
        //List<Pedido> pedidos = query.getResultList();
        List<Pedido> pedidos = Manager.createNamedQuery("Pedido.findAll", Pedido.class).getResultList();
        Manager.close();
        return pedidos;
    }

    @Override
     public void remove(Pedido pedido) {
        Manager.getTransaction().begin();
        Manager.remove(pedido);
        Manager.getTransaction().commit();
        Manager.close();    
    }
    
    
    
    
    
}
