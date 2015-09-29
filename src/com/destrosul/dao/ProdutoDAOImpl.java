/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import com.destrosul.model.Produto;
import com.destrosul.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author visitante
 */
public class ProdutoDAOImpl implements ProdutoDAO<Produto>{

    private final EntityManager entityManager;
    
    public ProdutoDAOImpl(){
        entityManager = javax.persistence.Persistence.createEntityManagerFactory("projeto_finalPU").createEntityManager();
    }
    
    @Override
    public Produto save(Produto produto) {
        entityManager.getTransaction().begin();
        Produto merged = entityManager.merge(produto);
        entityManager.getTransaction().commit();
        entityManager.close();
        return merged;
    }

    @Override
    public void remove(Produto produto) {
        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Produto findByID(Integer codigo) {
        return entityManager.find(Produto.class, codigo);
    }

    @Override
    public List<Produto> findAll() {
        TypedQuery<Produto> query = entityManager.createQuery("from Produto", Produto.class);
        List<Produto> usuarios = query.getResultList();
        return usuarios;
    }
    
}
