/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.controller;

import com.destrosul.dao.PedidoDAO;
import com.destrosul.entity.Pedido;
import com.destrosul.model.PedidoModel;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class PedidoController {

    private final PedidoModel model;
    private PedidoDAO PedidoDAO;

    /**
     *
     * @param model
     */
    public PedidoController(PedidoModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     */
    public void CarregaPedido() {
        PedidoDAO = new PedidoDAO();
        List<Pedido> pedido = PedidoDAO.findAll();
        model.setPedido(pedido);
        model.setPedidoMap(pedido);
    }
    
     public PedidoModel getModel() {
        return model;
    }

}
