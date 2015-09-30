/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author winston
 */
public abstract class BindableModel {
    
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    /**
     * Adiciona um listener para notificar mudanças no bean
     * @param listener Um listener a ser adicionado
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.changeSupport.addPropertyChangeListener(listener);
    }    
    
    /**
     * Adiciona um listener para notificar mudanças no bean
     * @param propertyName Nome da propriedade a ser notificada em caso de mudanças
     * @param listener Um listener a ser adicionado
     */
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.changeSupport.addPropertyChangeListener(propertyName, listener);
    }
    
    /**
     * Remove um listener
     * @param listener Um listener a ser removido
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.changeSupport.removePropertyChangeListener(listener);
    }
    
    /**
     * Remove um listener
     * @param propertyName Nome da propriedade que terá o listener removido
     * @param listener Um listener a ser removido
     */
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.changeSupport.removePropertyChangeListener(propertyName, listener);
    }
    
    /**
     * Notifica ouvinte sobre a mudança no bean
     * @param propertyName Nome da propriedade que foi alterada
     * @param oldValue Valor antigo
     * @param newValue  Valor novo
     */
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        this.changeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
    
}
