/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import com.destrosul.entity.Usuario;
import com.destrosul.exception.BusinessException;
import com.destrosul.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

/**
 *
 * @author aron.oliveira
 */
public class UsuarioDAO implements IDAO<Usuario> {

    private final EntityManager manager;

    /**
     * Construtor da classe
     */
    public UsuarioDAO() {
        manager = JPAUtil.getEntityManager();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Usuario> findAll() {
        List<Usuario> doacoes = manager.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
        manager.close();
        return doacoes;
    }

    /**
     *
     * @param usuario
     * @return
     * @throws BusinessException
     */
    @Override
    public Usuario save(Usuario usuario) throws BusinessException {
        try {
            manager.getTransaction().begin();
            if (!manager.contains(usuario)) {
                usuario = manager.merge(usuario);
            }
            manager.persist(usuario);
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar registro: " + usuario, e);
        } finally {
            manager.close();
        }
        return usuario;
    }

    @Override
    public void remove(Usuario usuario) throws BusinessException {
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(usuario));
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao remover registro: " + usuario, e);
        } finally {
            manager.close();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Usuario findById(Long id) {
        Usuario usuario = manager.find(Usuario.class, id);
        manager.close();
        return usuario;
    }

    public Usuario findByLoginSenha(final String login, final String senha) {
        TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.findByLoginSenha", Usuario.class)
                .setParameter("login", login)
                .setParameter("senha", senha);

        Usuario u = query.getSingleResult();
        manager.close();
        return u;
    }

}
