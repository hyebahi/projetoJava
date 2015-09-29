/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import com.destrosul.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author visitante
 */
public class UsuarioDAOImpl implements UsuarioDAO<Usuario>{
    
    private final EntityManager entityManager;
    
    public UsuarioDAOImpl(){
        entityManager = javax.persistence.Persistence.createEntityManagerFactory("projeto_finalPU").createEntityManager();
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
        entityManager.remove(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Usuario findByID(Integer codigo) {
        return entityManager.find(Usuario.class, codigo);
    }

    @Override
    public List<Usuario> findAll() {
        TypedQuery<Usuario> query = entityManager.createQuery("from Usuario", Usuario.class);
        List<Usuario> alunos = query.getResultList();
        return alunos;
    }

    @Override
    public Boolean validaLogin(String usuario, String senha) {
        //Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha");
        Query query = entityManager.createNamedQuery("Usuario.findByUsuarioSenha", Usuario.class);
        query.setParameter("nome",usuario);
        query.setParameter("senha",senha);
        Usuario list = (Usuario) query.getSingleResult();
        return (list != null);
        
    }
    
}
