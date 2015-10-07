/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.model;

import com.destrosul.entity.Produto;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Leandro
 */
public class ProdutoModel extends BindableModel {
    private Produto registroSelecionado;
    private Produto backupRegistro;
    private Produto registroEditado;
    private List<Produto> produtos;
    private Boolean isEnabled;

    /**
     * Construtor da classe
     */
    public ProdutoModel() {

    }

    /**
     *
     * @return
     */
    public Produto getRegistroSelecionado() {
        return registroSelecionado;
    }

    /**
     *
     * @param produto
     */
    public void setRegistroSelecionado(Produto produto) {
        this.registroSelecionado = produto;
        firePropertyChange("registroSelecionado", null, produto);
    }

    /**
     *
     * @return
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     *
     * @param produtos
     */
    public void setProdutos(List<Produto> produtos) {
        produtos.sort(new ProdutoComparator());
        this.produtos = ObservableCollections.observableList(produtos);
        firePropertyChange("produtos", null, Collections.unmodifiableList(produtos));
    }

    /**
     *
     * @param produto
     */
    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
        this.produtos.sort(new ProdutoComparator());
        firePropertyChange("produtos", null, Collections.unmodifiableList(produtos));
    }

    /**
     *
     * @param produto
     */
    public void addProduto(Produto produto) {
        this.produtos.add(produto);
        this.produtos.sort(new ProdutoComparator());
        firePropertyChange("produtos", null, Collections.unmodifiableList(produtos));
    }

    /**
     *
     * @return
     */
    public Produto getBackupRegistro() {
        return backupRegistro;
    }

    /**
     *
     * @param backupRegistro
     */
    public void setBackupRegistro(Produto backupRegistro) {
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

    public Produto getRegistroEditado() {
        return registroEditado;
    }

    public void setRegistroEditado(Produto registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }   
}
