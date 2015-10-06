/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.model;

import com.destrosul.entity.Usuario;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de usuarios
 *
 *
 */
public class UsuarioModel extends BindableModel {

    private Usuario registroSelecionado;
    private Usuario backupRegistro;
    private Usuario registroEditado;
    private List<Usuario> usuarios;
    private Boolean isEnabled;

    /**
     * Construtor da classe
     */
    public UsuarioModel() {

    }

    /**
     *
     * @return
     */
    public Usuario getRegistroSelecionado() {
        return registroSelecionado;
    }

    /**
     *
     * @param usuario
     */
    public void setRegistroSelecionado(Usuario usuario) {
        this.registroSelecionado = usuario;
        firePropertyChange("registroSelecionado", null, usuario);
    }

    /**
     *
     * @return
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param usuarios
     */
    public void setUsuarios(List<Usuario> usuarios) {
        usuarios.sort(new UsuarioComparator());
        this.usuarios = ObservableCollections.observableList(usuarios);
        firePropertyChange("usuarios", null, Collections.unmodifiableList(usuarios));
    }

    /**
     *
     * @param usuario
     */
    public void removeUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
        this.usuarios.sort(new UsuarioComparator());
        firePropertyChange("usuarios", null, Collections.unmodifiableList(usuarios));
    }

    /**
     *
     * @param usuario
     */
    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        this.usuarios.sort(new UsuarioComparator());
        firePropertyChange("usuarios", null, Collections.unmodifiableList(usuarios));
    }

    /**
     *
     * @return
     */
    public Usuario getBackupRegistro() {
        return backupRegistro;
    }

    /**
     *
     * @param backupRegistro
     */
    public void setBackupRegistro(Usuario backupRegistro) {
        if (backupRegistro == null) {
            this.backupRegistro = null;
        } else {
            this.backupRegistro = backupRegistro;
        }
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        firePropertyChange("isEnabled", null, isEnabled);
    }

    public Usuario getRegistroEditado() {
        return registroEditado;
    }

    public void setRegistroEditado(Usuario registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }

}
