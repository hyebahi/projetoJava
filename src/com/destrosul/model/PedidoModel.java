/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.model;

import com.destrosul.entity.Pedido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 * @author Leandro
 */
public class PedidoModel extends BindableModel {
    
    private Pedido pedido;
    private List<Pedido> pedidoList;
    private Pedido pedidoSelecionado;
    private NavigableMap<Long, Pedido> pedidoNavigableMap;

    public PedidoModel() {
        pedidoSelecionado = new Pedido();
        pedidoList = new ArrayList();
        
    }
    
    /**
     * 
     * @return
     */
    public Pedido getPedidoSelecionado() {
        return pedidoSelecionado;
    }

    /**
     *
     * @param pedido
     */
    public void setPedidoSelecionado(Pedido pedido) {
        this.pedidoSelecionado = pedido;
        firePropertyChange("pedidoSelecionado", null, pedido);
    }    
    

    /**
     *
     * @return
     */
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }    
    
    
    public Pedido getPedido() {
        return pedidoSelecionado;
    }

      /**
     *
     * @param pedidos 
     */
    public void setPedido(List<Pedido> pedidos) {
        this.pedidoList = new ArrayList();
        this.pedidoList.addAll(pedidos);
        firePropertyChange("pedidoList", null, Collections.unmodifiableList(pedidos));
    }    
    
    /**
     *
     * @param pedidos
     */
    public void setPedidoMap(List<Pedido> pedidos) {
        pedidoNavigableMap = new TreeMap();
        pedidos.forEach(pedido -> {
            this.pedidoNavigableMap.put(pedido.getIdPedido(), pedido);
        });
        firePropertyChange("pedidoNavigableMap", null, Collections.unmodifiableNavigableMap(pedidoNavigableMap));
    }   
    
   

     /**
     * Efetua a navegação até o primeiro elemento da coleção
     */
    public void navigateToFirst() {
        if (pedidoNavigableMap != null && !pedidoNavigableMap.isEmpty()) {
            Map.Entry<Long, Pedido> entry = pedidoNavigableMap.firstEntry();
            if (entry != null) {
                setPedidoSelecionado(entry.getValue());
            }
        }
    }   
    
    
    
}
