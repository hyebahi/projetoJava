/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.model;

import com.destrosul.entity.Produto;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Leandro
 */
public class ProdutoComparator implements Comparator<Produto>{
    @Override
    public int compare(Produto o1, Produto o2) {
        return (o1.getIdProduto() < o2.getIdProduto() ? -1 : (Objects.equals(o1.getIdProduto(), o2.getIdProduto()) ? 0 : 1));
    }  
}
