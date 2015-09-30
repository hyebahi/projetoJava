/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import com.destrosul.entity.Usuario;
import com.destrosul.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author visitante
 */
public class UsuarioDAO implements IDAO<Usuario> {

    private final EntityManager entityManager;

    public UsuarioDAO() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public Usuario save(Usuario usuario) {
        entityManager.getTransaction().begin();
        Usuario merged = entityManager.merge(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
        return merged;
    }

    @Override
    public void remove(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(usuario));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Usuario findById(Long codigo) {
        Usuario u = entityManager.find(Usuario.class, codigo);
        entityManager.close();
        return u;
    }

    @Override
    public List<Usuario> findAll() {
        TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.findAll", Usuario.class);
        List<Usuario> list = query.getResultList();
        entityManager.close();
        return list;
    }

    public Usuario validaLogin(String usuario, String senha) {
        TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.findByLoginSenha", Usuario.class)
                .setParameter("nome", usuario)
                .setParameter("senha", senha);
        Usuario u = null;
        try {
            u = query.getSingleResult();
        } catch (PersistenceException e) {
            
        }
        entityManager.close();
        return u;
    }

}
