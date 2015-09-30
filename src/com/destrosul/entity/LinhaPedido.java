/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "LINHA_PEDIDO")
@NamedQueries({
    @NamedQuery(name = "LinhaPedido.findAll", query = "SELECT l FROM LinhaPedido l"),
    @NamedQuery(name = "LinhaPedido.findByIdLinha", query = "SELECT l FROM LinhaPedido l WHERE l.idLinha = :idLinha"),
    @NamedQuery(name = "LinhaPedido.findByIdPedido", query = "SELECT l FROM LinhaPedido l WHERE l.idPedido = :idPedido"),
    @NamedQuery(name = "LinhaPedido.findByNrLinha", query = "SELECT l FROM LinhaPedido l WHERE l.nrLinha = :nrLinha"),
    @NamedQuery(name = "LinhaPedido.findByIdProduto", query = "SELECT l FROM LinhaPedido l WHERE l.idProduto = :idProduto"),
    @NamedQuery(name = "LinhaPedido.findByQtItem", query = "SELECT l FROM LinhaPedido l WHERE l.qtItem = :qtItem"),
    @NamedQuery(name = "LinhaPedido.findByPrecoUnitario", query = "SELECT l FROM LinhaPedido l WHERE l.precoUnitario = :precoUnitario"),
    @NamedQuery(name = "LinhaPedido.findByPrecoTotal", query = "SELECT l FROM LinhaPedido l WHERE l.precoTotal = :precoTotal")})
public class LinhaPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LINHA", nullable = false, precision = 38, scale = 0)
    private BigDecimal idLinha;
    @Column(name = "ID_PEDIDO")
    private BigInteger idPedido;
    @Column(name = "NR_LINHA")
    private BigInteger nrLinha;
    @Column(name = "ID_PRODUTO")
    private BigInteger idProduto;
    @Column(name = "QT_ITEM")
    private BigInteger qtItem;
    @Column(name = "PRECO_UNITARIO")
    private BigInteger precoUnitario;
    @Column(name = "PRECO_TOTAL")
    private BigInteger precoTotal;

    public LinhaPedido() {
    }

    public LinhaPedido(BigDecimal idLinha) {
        this.idLinha = idLinha;
    }

    public BigDecimal getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(BigDecimal idLinha) {
        this.idLinha = idLinha;
    }

    public BigInteger getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(BigInteger idPedido) {
        this.idPedido = idPedido;
    }

    public BigInteger getNrLinha() {
        return nrLinha;
    }

    public void setNrLinha(BigInteger nrLinha) {
        this.nrLinha = nrLinha;
    }

    public BigInteger getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(BigInteger idProduto) {
        this.idProduto = idProduto;
    }

    public BigInteger getQtItem() {
        return qtItem;
    }

    public void setQtItem(BigInteger qtItem) {
        this.qtItem = qtItem;
    }

    public BigInteger getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigInteger precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigInteger getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigInteger precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLinha != null ? idLinha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhaPedido)) {
            return false;
        }
        LinhaPedido other = (LinhaPedido) object;
        if ((this.idLinha == null && other.idLinha != null) || (this.idLinha != null && !this.idLinha.equals(other.idLinha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.destrosul.entity.LinhaPedido[ idLinha=" + idLinha + " ]";
    }
    
}
