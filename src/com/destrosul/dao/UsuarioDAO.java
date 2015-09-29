/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import java.util.List;

/**
 *
 * @author HL
 * @param <Usuario>
 */
public interface UsuarioDAO<Usuario> {
    Usuario save(Usuario usuario);
    
    void remove(Usuario aluno);

    Usuario findByID(Integer codigo);

    List<Usuario> findAll();
    
    Boolean validaLogin(String usuario, String senha);
}
