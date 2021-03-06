/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import com.destrosul.entity.Produto;
import com.destrosul.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Leandro
 */
public class ProdutoDAO implements IDAO<Produto> {

    private final EntityManager entityManager;

    public ProdutoDAO() {
        entityManager = JPAUtil.getEntityManager();
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

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Produto findById(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        entityManager.close();
        return produto;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Produto> findAll() {
        List<Produto> produtos = entityManager.createNamedQuery("Produto.findAll", Produto.class).getResultList();
        entityManager.close();
        return produtos;
    }  

}
