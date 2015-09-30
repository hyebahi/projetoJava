/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.view;

import com.destrosul.entity.Produto;
import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class ProdutoView extends JFrame {

    
    /**
     * Creates new form NewJPanel
     */
    public ProdutoView() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("DestrosulPU").createEntityManager();
        produtoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Produto p");
        produtoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : produtoQuery.getResultList();
        jPbotoes = new javax.swing.JPanel();
        txCodigo = new javax.swing.JTextField();
        txDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        BtNovo = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtLimpar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtPrimeiro = new javax.swing.JButton();
        BtAnterior = new javax.swing.JButton();
        BtProximo = new javax.swing.JButton();
        BtUltimo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 400));

        txCodigo.setEnabled(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nrProduto}"), txCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txDescricao.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.descricao}"), txDescricao, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel1.setText("Código");

        jLabel2.setText("Descrição");

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, produtoList, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProduto}"));
        columnBinding.setColumnName("Id Produto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nrProduto}"));
        columnBinding.setColumnName("Nr Produto");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descricao");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(masterTable);

        javax.swing.GroupLayout jPbotoesLayout = new javax.swing.GroupLayout(jPbotoes);
        jPbotoes.setLayout(jPbotoesLayout);
        jPbotoesLayout.setHorizontalGroup(
            jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPbotoesLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addGroup(jPbotoesLayout.createSequentialGroup()
                        .addGroup(jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txCodigo)
                            .addComponent(txDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPbotoesLayout.setVerticalGroup(
            jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPbotoesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(7, 7, 7)
                .addGroup(jPbotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        BtNovo.setText("Novo");
        BtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtNovoActionPerformed(evt);
            }
        });

        BtSalvar.setText("Salvar");
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });

        BtLimpar.setText("Limpar");
        BtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLimparActionPerformed(evt);
            }
        });

        BtExcluir.setText("Excluir");
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

        BtPrimeiro.setText("Primeiro");
        BtPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPrimeiroActionPerformed(evt);
            }
        });

        BtAnterior.setText("Anterior");
        BtAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAnteriorActionPerformed(evt);
            }
        });

        BtProximo.setText("Próximo");
        BtProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtProximoActionPerformed(evt);
            }
        });

        BtUltimo.setText("Último");
        BtUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtUltimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtPrimeiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtProximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtUltimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPbotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPbotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void BtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLimparActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = produtoQuery.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        produtoList.clear();
        produtoList.addAll(data);
    }//GEN-LAST:event_BtLimparActionPerformed

    private void BtPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPrimeiroActionPerformed
        if (masterTable.getModel().getRowCount() > 0) {
            masterTable.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_BtPrimeiroActionPerformed

    private void BtAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAnteriorActionPerformed
        if (masterTable.getModel().getRowCount() > 0) {
            int row = masterTable.getSelectedRow() - 1;
            if (row >= 0) {
                masterTable.setRowSelectionInterval(row, row);
            }
        }
    }//GEN-LAST:event_BtAnteriorActionPerformed

    private void BtProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtProximoActionPerformed
        if (masterTable.getModel().getRowCount() > 0) {
            int row = masterTable.getSelectedRow() + 1;
            if (row < masterTable.getRowCount()) {
                masterTable.setRowSelectionInterval(row, row);
            }
        }
    }//GEN-LAST:event_BtProximoActionPerformed

    private void BtUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtUltimoActionPerformed
        if (masterTable.getModel().getRowCount() > 0) {
            int row = masterTable.getRowCount() - 1;
            masterTable.setRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_BtUltimoActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro selecionado?", "Confirmação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            int[] selected = masterTable.getSelectedRows();
            List<Produto> toRemove = new ArrayList<Produto>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                 Produto a = produtoList.get(masterTable.convertRowIndexToModel(selected[idx]));
                toRemove.add(a);
                entityManager.remove(a);
            }
            produtoList.removeAll(toRemove);
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtNovoActionPerformed
        /*Produto a = new Produto();
        entityManager.persist(a);
        produtoList.add(a);
        int row = produtoList.size() - 1;
        Table.setRowSelectionInterval(row, row);
        Table.scrollRectToVisible(Table.getCellRect(row, 0, true));*/
        txCodigo.setEnabled(true);
        txDescricao.setEnabled(true);
        Produto a = new Produto();
        entityManager.persist(a);
        produtoList.add(a);
        int row = produtoList.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_BtNovoActionPerformed

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
            JOptionPane.showMessageDialog(null, "Salvo!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<Produto> merged = new ArrayList<Produto>(produtoList.size());
            for (Produto a : produtoList) {
                merged.add(entityManager.merge(a));
            }
            produtoList.clear();
            produtoList.addAll(merged);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAnterior;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtLimpar;
    private javax.swing.JButton BtNovo;
    private javax.swing.JButton BtPrimeiro;
    private javax.swing.JButton BtProximo;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JButton BtUltimo;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPbotoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable masterTable;
    private java.util.List<com.destrosul.entity.Produto> produtoList;
    private javax.persistence.Query produtoQuery;
    private javax.swing.JTextField txCodigo;
    private javax.swing.JTextField txDescricao;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoView().setVisible(true);
                //JDialog dialog = new JDialog(new JFrame(), "Clientes", true);
                //dialog.setContentPane(new ClienteView());
                //dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //dialog.pack();
                //dialog.setLocationRelativeTo(null);
                //dialog.setVisible(true);

            }
        });
    }

}