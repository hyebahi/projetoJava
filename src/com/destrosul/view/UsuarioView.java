
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.destrosul.view;

import com.destrosul.controller.UsuarioController;
import com.destrosul.entity.Usuario;
import com.destrosul.exception.BusinessException;
import com.destrosul.model.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author aron.oliveira
 */
public class UsuarioView extends javax.swing.JFrame {

    private UsuarioModel model = new UsuarioModel();
    private UsuarioController controller = new UsuarioController(model);

    /**
     * Creates new form ManutencaoProdutoView
     */
    public UsuarioView() {
        initComponents();
        controller.carregarUsuarios();
        doBindings();

    }

    private void doBindings() {
        BindingGroup bindingGroup = new BindingGroup();

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, model,
                ELProperty.create("${usuarios}"), masterTable);

        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(Long.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${senha}"));
        columnBinding.setColumnName("Senha");
        columnBinding.setColumnClass(String.class);

        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        
        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, model, 
                ELProperty.create("${registroSelecionado != null}"), updateButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);
        
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, model, 
                ELProperty.create("${registroSelecionado != null}"), removeButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);        
        bindingGroup.bind();                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        removeButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Usuários");

        removeButton.setText("Remover");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Fechar");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        addButton.setText("Adicionar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        masterTable.setModel(new UsuarioTableModel());
        masterTable.getSelectionModel().addListSelectionListener(new UsuarioMasterTableListSelectionListener());
        jScrollPane2.setViewportView(masterTable);

        updateButton.setText("Alterar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton)
                    .addComponent(closeButton)
                    .addComponent(updateButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        model.setBackupRegistro(model.getRegistroSelecionado());
        model.setRegistroEditado(new Usuario());
        new Thread(() -> {
            UsuarioForm form = new UsuarioForm(this, true);
            form.setTitle("Adicionar Usuário");
            form.setController(controller);
            form.setVisible(true);
        }).start();
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro selecionado?",
                "Confirmação de remoção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            try {
                controller.remove(model.getRegistroSelecionado());
            } catch (BusinessException ex) {
                Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        model.setBackupRegistro(model.getRegistroSelecionado());
        model.setRegistroEditado(model.getRegistroSelecionado());
        new Thread(() -> {
            UsuarioForm form = new UsuarioForm(this, true);
            form.setTitle("Alterar Usuaário");
            form.setController(controller);
            form.setVisible(true);
        }).start();
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UsuarioView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private class UsuarioTableModel extends AbstractTableModel /*implements TableCellRenderer*/ {

        private List<Usuario> usuarios;        
        private final String[] columnNames = {"ID", "Nome", "Senha"};
        private final int COLUMN_COUNT = columnNames.length;

        public UsuarioTableModel() {
            usuarios = new ArrayList();
        }

        public UsuarioTableModel(List<Usuario> usuarios) {
            this();
            this.usuarios.addAll(usuarios);
        }

        @Override
        public int getRowCount() {
            return usuarios.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_COUNT;
        }

        @Override
        public String getColumnName(int i) {
            return columnNames[i];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Usuario usuario = usuarios.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return usuario.getId();
                case 1:
                    return usuario.getNome();
                case 2:
                    return usuario.getSenha();
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Usuario usuario = usuarios.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    usuario.setId(Long.parseLong(aValue.toString()));
                    break;
                case 1:
                    usuario.setNome(aValue.toString());
                    break;
                case 2:
                    usuario.setSenha(aValue.toString());
                    break;                
            }
            fireTableDataChanged();
        }

//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            return getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        }

    }

    private class UsuarioMasterTableListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row = masterTable.getSelectedRow();
            if (row >= 0) {
                Usuario u = model.getUsuarios().get(row);
                Usuario backup = new Usuario();
                backup.setId(u.getId());
                backup.setNome(u.getNome());
                backup.setSenha(u.getSenha());
                model.setBackupRegistro(backup);
                
                Usuario selecionado = new Usuario();
                selecionado.setId(u.getId());
                selecionado.setNome(u.getNome());
                selecionado.setSenha(u.getSenha());
                
                model.setRegistroSelecionado(selecionado);
            }
        }
    }

}
