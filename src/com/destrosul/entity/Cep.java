/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Leandro
 */
@Entity
@Table(name = "CEP")
@NamedQueries({
    @NamedQuery(name = "Cep.findAll", query = "SELECT c FROM Cep c"),
    @NamedQuery(name = "Cep.findByCep", query = "SELECT c FROM Cep c WHERE c.cep = :cep"),
    @NamedQuery(name = "Cep.findByUfeSg", query = "SELECT c FROM Cep c WHERE c.ufeSg = :ufeSg"),
    @NamedQuery(name = "Cep.findByLogTipoLogradouro", query = "SELECT c FROM Cep c WHERE c.logTipoLogradouro = :logTipoLogradouro"),
    @NamedQuery(name = "Cep.findByLogNo", query = "SELECT c FROM Cep c WHERE c.logNo = :logNo"),
    @NamedQuery(name = "Cep.findByBairro", query = "SELECT c FROM Cep c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "Cep.findByCidade", query = "SELECT c FROM Cep c WHERE c.cidade = :cidade")})
public class Cep implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CEP", nullable = false, precision = 0, scale = -127)
    private BigDecimal cep;
    @Basic(optional = false)
    @Column(name = "UFE_SG", nullable = false, length = 2)
    private String ufeSg;
    @Column(name = "LOG_TIPO_LOGRADOURO", length = 72)
    private String logTipoLogradouro;
    @Basic(optional = false)
    @Column(name = "LOG_NO", nullable = false, length = 70)
    private String logNo;
    @Column(name = "BAIRRO", length = 72)
    private String bairro;
    @Column(name = "CIDADE", length = 50)
    private String cidade;

    public Cep() {
    }

    public Cep(BigDecimal cep) {
        this.cep = cep;
    }

    public Cep(BigDecimal cep, String ufeSg, String logNo) {
        this.cep = cep;
        this.ufeSg = ufeSg;
        this.logNo = logNo;
    }

    public BigDecimal getCep() {
        return cep;
    }

    public void setCep(BigDecimal cep) {
        this.cep = cep;
    }

    public String getUfeSg() {
        return ufeSg;
    }

    public void setUfeSg(String ufeSg) {
        this.ufeSg = ufeSg;
    }

    public String getLogTipoLogradouro() {
        return logTipoLogradouro;
    }

    public void setLogTipoLogradouro(String logTipoLogradouro) {
        this.logTipoLogradouro = logTipoLogradouro;
    }

    public String getLogNo() {
        return logNo;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cep != null ? cep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cep)) {
            return false;
        }
        Cep other = (Cep) object;
        if ((this.cep == null && other.cep != null) || (this.cep != null && !this.cep.equals(other.cep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.destrosul.entity.Cep[ cep=" + cep + " ]";
    }
    
}
