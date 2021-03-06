/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "PEDIDO")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByNumero", query = "SELECT p FROM Pedido p WHERE p.numero = :numero"),
    @NamedQuery(name = "Pedido.findByIdCliente", query = "SELECT p FROM Pedido p WHERE p.idCliente = :idCliente"),
    @NamedQuery(name = "Pedido.findByDtPedido", query = "SELECT p FROM Pedido p WHERE p.dtPedido = :dtPedido"),
    @NamedQuery(name = "Pedido.findByDtEmissao", query = "SELECT p FROM Pedido p WHERE p.dtEmissao = :dtEmissao"),
    @NamedQuery(name = "Pedido.findByDtEntrega", query = "SELECT p FROM Pedido p WHERE p.dtEntrega = :dtEntrega"),
    @NamedQuery(name = "Pedido.findByObservacoes", query = "SELECT p FROM Pedido p WHERE p.observacoes = :observacoes"),
    @NamedQuery(name = "Pedido.findByTransportadora", query = "SELECT p FROM Pedido p WHERE p.transportadora = :transportadora")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PEDIDO", nullable = false, precision = 38, scale = 0)
    private Long idPedido;
    @Column(name = "NUMERO")
    private Long numero;
    @Column(name = "ID_CLIENTE")
    private Long idCliente;
    @Column(name = "DT_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPedido;
    @Column(name = "DT_EMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEmissao;
    @Column(name = "DT_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEntrega;
    @Column(name = "OBSERVACOES", length = 250)
    private String observacoes;
    @Column(name = "TRANSPORTADORA", length = 250)
    private String transportadora;

    public Pedido() {
    }

    public Pedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public Date getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(Date dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.destrosul.entity.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
