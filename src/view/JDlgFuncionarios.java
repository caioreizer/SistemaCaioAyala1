/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.CraFuncionario;
import bean.CrsUsuarios;
import dao.FuncionariosDAO;
import dao.UsuariosDAO;
import java.awt.Color;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author u10916731103
 */
public class JDlgFuncionarios extends javax.swing.JDialog {

    private boolean incluir;
    private MaskFormatter mascaraCpf, mascaraDataNasc;  
    public JDlgFuncionarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Cadastro de Funcionário");
        setLocationRelativeTo(null);
        Util.habilitar(false, jTxtCodigo, jTxtNome, jTxtCargo, jTxtCelular,
                jFmtCpf, jFmtDataAdmissao, jTxtSalarios, 
                jBtnConfirmar, jBtnCancelar);
    
     try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraDataNasc = new MaskFormatter("##/##/####");
            jFmtCpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
            jFmtDataAdmissao.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNasc));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void beanView(CraFuncionario funcionario) {
        jTxtCodigo.setText(Util.intToStr(funcionario.getCraIdFuncionario()));
        jTxtNome.setText(funcionario.getCraNome());
        jFmtCpf.setText(funcionario.getCraCpf());
        jTxtCargo.setText(funcionario.getCraCargo());
        jTxtCelular.setText(funcionario.getCraCelular());
        jFmtDataAdmissao.setText(Util.dateToStr(funcionario.getCraDataAdmissao()));
        jTxtSalarios.setText(Util.doubleToStr(funcionario.getCraSalario()));
   
        
    }
       private void marcarCamposObrigatorios() {
        Color corObrigatoria = new Color(255, 255, 220);
     
        jTxtNome.setBackground(corObrigatoria);
        jTxtCodigo.setBackground(corObrigatoria);
        jTxtCargo.setBackground(corObrigatoria);
        jFmtCpf.setBackground(corObrigatoria);


    }

    private void desmarcarCampos() {
        Color corPadrao = Color.WHITE;
        jTxtNome.setBackground(corPadrao);
        jTxtCodigo.setBackground(corPadrao);
        jTxtCargo.setBackground(corPadrao);
        jFmtCpf.setBackground(corPadrao);


    }

    public CraFuncionario viewBean() {
        CraFuncionario funcionario = new CraFuncionario();
        int codigo = Util.strToInt(jTxtCodigo.getText());
        funcionario.setCraIdFuncionario(codigo);
        //usuarios.setIdusuarios(Util.strToInt( jTxtCodigo.getText() ));

        funcionario.setCraNome(jTxtNome.getText());
        funcionario.setCraCargo(jTxtCargo.getText());
        funcionario.setCraCelular(jTxtCelular.getText());
        funcionario.setCraCpf(jFmtCpf.getText());
        try {
            funcionario.setCraDataAdmissao(Util.strToDate(jFmtDataAdmissao.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        funcionario.setCraSalario(Util.strToDouble(jTxtSalarios.getText()));
        return funcionario;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jTxtCargo = new javax.swing.JFormattedTextField();
        jTxtCodigo = new javax.swing.JTextField();
        jTxtNome = new javax.swing.JTextField();
        jTxtCelular = new javax.swing.JFormattedTextField();
        jTxtSalarios = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jBtnCancelar = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnIncluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jFmtDataAdmissao = new javax.swing.JFormattedTextField();
        jFmtCpf = new javax.swing.JFormattedTextField();

        jLabel9.setText("Código");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigoActionPerformed(evt);
            }
        });

        jTxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Código");

        jLabel4.setText("Nome");

        jLabel5.setText("Cpf");

        jLabel7.setText("Data de admissão");

        jLabel8.setText("Cargo");

        jLabel11.setText("Celular");

        jLabel12.setText("Salários");

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnPesquisar)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTxtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                .addComponent(jTxtCodigo))
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jFmtCpf, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtCargo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFmtDataAdmissao, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtSalarios, javax.swing.GroupLayout.Alignment.LEADING))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtSalarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFmtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoActionPerformed

    private void jTxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtNomeActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false,  jTxtCodigo,jTxtNome,  jFmtCpf, jTxtCargo, jTxtCelular, jTxtSalarios, jFmtDataAdmissao,jBtnConfirmar, jBtnCancelar);

        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.limpar(jTxtCodigo,jTxtNome,  jFmtCpf, jTxtCargo, jTxtCelular, jTxtSalarios, jFmtDataAdmissao);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
       if (jTxtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pesquise um funcionário antes de alterar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
// TODO add your handling code here:
     Util.habilitar(true,jTxtNome,  jFmtCpf, jTxtCargo, jTxtCelular, jTxtSalarios, jFmtDataAdmissao,jBtnConfirmar, jBtnCancelar,
                jBtnConfirmar, jBtnCancelar);
                
       Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
               incluir = false;
               
         jTxtNome.grabFocus();
         marcarCamposObrigatorios();
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
         Util.habilitar(true, jTxtCodigo,jTxtNome,  jFmtCpf, jTxtCargo, jTxtCelular, jTxtSalarios, jFmtDataAdmissao,jBtnConfirmar, jBtnCancelar,
                jBtnConfirmar, jBtnCancelar);
                
       Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
       Util.limpar(jTxtCodigo,jTxtNome,  jFmtCpf, jTxtCargo, jTxtCelular, jTxtSalarios, jFmtDataAdmissao);
           // TODO add your handling code here:
         incluir = true;
         marcarCamposObrigatorios();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
          
        // TODO add your handling code here:
        FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
        CraFuncionario funcionarios = viewBean();
        if (incluir == true) {
            funcionariosDAO.insert(funcionarios);
            //usuariosDAO.insert( viewBean() );
        } else {
            funcionariosDAO.update(funcionarios);
            //usuariosDAO.update( viewBean() );
        }
        

    Util.habilitar(false,  jTxtCodigo,jTxtNome,  jFmtCpf, jTxtCargo, jTxtCelular, jTxtSalarios, jFmtDataAdmissao,jBtnConfirmar, jBtnCancelar);

        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.limpar(jTxtCodigo,jTxtNome,  jFmtCpf, jTxtCargo, jTxtCelular, jTxtSalarios, jFmtDataAdmissao);
         desmarcarCampos();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
       if (jTxtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pesquise um funcionário antes de excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (Util.perguntar("Deseja excluir ?") == true) {
           FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
            funcionariosDAO.delete(viewBean());
        }
        Util.limpar(jTxtCodigo,jTxtNome,  jFmtCpf, jTxtCargo, jTxtCelular, jTxtSalarios, jFmtDataAdmissao);
          desmarcarCampos();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
       JDlgFuncionariosPesquisar jDlgFuncionariosPesquisar = new JDlgFuncionariosPesquisar(null, true);
        jDlgFuncionariosPesquisar.setTelaAnterior(this);
        jDlgFuncionariosPesquisar.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgFuncionarios dialog = new JDlgFuncionarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JFormattedTextField jFmtCpf;
    private javax.swing.JFormattedTextField jFmtDataAdmissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField jTxtCargo;
    private javax.swing.JFormattedTextField jTxtCelular;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JFormattedTextField jTxtSalarios;
    // End of variables declaration//GEN-END:variables

}