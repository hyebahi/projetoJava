/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.dao;

import java.util.List;

/**
 *
 * @author Leandro
 * @param <Pedido>
 */
public interface PedidoDAO<Pedido> {
    Pedido save(Pedido cliente);

    void remove(Pedido pedido);

    Pedido findByID(Integer id);

    List<Pedido> findAll();   
}