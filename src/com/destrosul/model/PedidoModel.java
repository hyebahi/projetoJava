/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.model;

import com.destrosul.entity.Pedido;

/**
 *
 * @author Leandro
 */
public class PedidoModel extends BindableModel {
    
    private Pedido pedido;

    public PedidoModel() {
        pedido = new Pedido();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        Pedido oldValue = this.pedido;
        this.pedido = pedido;
        firePropertyChange("pedido", oldValue, pedido);
    }    
    
    
}
