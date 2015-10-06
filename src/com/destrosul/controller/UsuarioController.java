/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.controller;

import com.destrosul.dao.UsuarioDAO;
import com.destrosul.entity.Usuario;
import com.destrosul.exception.BusinessException;
import com.destrosul.model.UsuarioModel;
import java.util.List;

/**
 *
 * @author
 */
public class UsuarioController {

    private UsuarioDAO usuarioDAO;
    private final UsuarioModel model;

    /**
     *
     * @param model
     */
    public UsuarioController(UsuarioModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     */
    public void carregarUsuarios() {
        usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.findAll();
        model.setUsuarios(usuarios);
    }

    /**
     *
     * @param usuario
     * @throws BusinessException
     */
    public void remove(Usuario usuario) throws BusinessException {
        usuarioDAO = new UsuarioDAO();
        usuarioDAO.remove(usuario);
        model.removeUsuario(usuario);
    }

    /**
     *
     * @param usuario
     * @throws BusinessException
     */
    public void save(Usuario usuario) throws BusinessException {
        usuarioDAO = new UsuarioDAO();
        usuario = usuarioDAO.save(usuario);
        Usuario u = new Usuario(usuario.getId());
        u.setNome(usuario.getNome());
        u.setSenha(usuario.getSenha());
        model.removeUsuario(usuario);
        model.addUsuario(u);
    }

    public UsuarioModel getModel() {
        return model;
    }

}
