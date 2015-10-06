/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.controller;

import com.destrosul.dao.UsuarioDAO;
import com.destrosul.entity.Usuario;
import com.destrosul.exception.BusinessException;
import com.destrosul.model.LoginModel;
import com.destrosul.session.SessionManager;
import com.destrosul.view.PrincipalView;

/**
 *
 * @author Leandro
 */
public class LoginController {

    private final LoginModel model;

    public LoginController(LoginModel model) {
        this.model = model;
    }

    public void doLogin(Usuario usuario) throws BusinessException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioLogado = dao.findByLoginSenha(usuario.getNome(), usuario.getSenha());
        if (usuarioLogado == null) {
            throw new BusinessException("Usuário e/ou senha inválidos!");
        }
        SessionManager.setUsuarioLogado(usuarioLogado);
        new Thread(() -> {
            new PrincipalView().setVisible(true);
        }).start();
    }

}
