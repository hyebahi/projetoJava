/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.controller;

import com.destrosul.dao.ProdutoDAO;
import com.destrosul.entity.Produto;
import com.destrosul.exception.BusinessException;
import com.destrosul.model.ProdutoModel;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class ProdutoController {

 private ProdutoDAO produtoDAO;
    private final ProdutoModel model;

    /**
     *
     * @param model
     */
    public ProdutoController(ProdutoModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     */
    public void carregarProdutos() {
        produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.findAll();
        model.setProdutos(produtos);
    }

    /**
     *
     * @param produto
     * @throws BusinessException
     */
    public void remove(Produto produto) throws BusinessException {
        produtoDAO = new ProdutoDAO();
        produtoDAO.remove(produto);
        model.removeProduto(produto);
    }

    /**
     *
     * @param produto
     * @throws BusinessException
     */
    public void save(Produto produto) throws BusinessException {
        produtoDAO = new ProdutoDAO();
        produto = produtoDAO.save(produto);
        Produto u = new Produto(produto.getIdProduto());
        u.setNrProduto(produto.getNrProduto());
        u.setDescricao(produto.getDescricao());
        model.removeProduto(produto);
        model.addProduto(u);
    }

    public ProdutoModel getModel() {
        return model;
    }    
    
}
