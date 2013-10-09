/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.Presentation;

import br.edu.ifnmg.tads.sistemavendas.DataAcess.PessoaDAO;
import br.edu.ifnmg.tads.sistemavendas.DomainModel.Pessoa;
import br.edu.ifnmg.tads.sistemavendas.DomainModel.Telefone;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class frmPessoaCadastrar extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPessoaCadastrar
     */
    public frmPessoaCadastrar() {
        initComponents();
    }
    PessoaDAO pessoaDao = new PessoaDAO();
    Pessoa pessoa = new Pessoa();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void atualizaTabelaTelefones(List<Telefone> telefones){
        DefaultTableModel model = new DefaultTableModel();
        //model.addColumn("DDD");
        model.addColumn("Telefone");
        
        for(Telefone t : telefones){
            Vector valores = new Vector();
            //valores.add(1,t.getDDD());
            valores.add(0,t.getTelefone());
            model.addRow(valores);
        }
        tblTelefones.setModel(model);
        tblTelefones.repaint();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvarCadastroPessoa = new javax.swing.JToggleButton();
        btnApagar = new javax.swing.JButton();
        tabEndereco = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        lblNomePessoaCadastro = new javax.swing.JLabel();
        lblDataNascimentoCadastroPessoa = new javax.swing.JLabel();
        txtfDataNascimentoCadastroPessoa = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblDdd = new javax.swing.JLabel();
        txtDdd = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTelefones = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);

        btnSalvarCadastroPessoa.setText("Salvar");
        btnSalvarCadastroPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCadastroPessoaActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblNomePessoaCadastro.setText("Nome:");

        lblDataNascimentoCadastroPessoa.setText("Data Nascimento:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNomePessoaCadastro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDataNascimentoCadastroPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfDataNascimentoCadastroPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomePessoaCadastro)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNascimentoCadastroPessoa)
                    .addComponent(txtfDataNascimentoCadastroPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        tabEndereco.addTab("Dados Gerais", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        tabEndereco.addTab("Emails", jPanel3);

        lblDdd.setText("DDD:");

        txtDdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDddActionPerformed(evt);
            }
        });

        lblTelefone.setText("Telefone:");

        tblTelefones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblTelefones);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionar)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDdd)
                    .addComponent(txtDdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tabEndereco.addTab("Telefones", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        tabEndereco.addTab("Endereço", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabEndereco)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvarCadastroPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnApagar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(tabEndereco)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarCadastroPessoa)
                    .addComponent(btnApagar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarCadastroPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCadastroPessoaActionPerformed

        try {

            Calendar Data = GregorianCalendar.getInstance();
            pessoa.setNome(txtNome.getText());
            pessoa.setDataNascimento(Date.valueOf(txtfDataNascimentoCadastroPessoa.getText()));
        } catch (Exception ex) {
            Logger.getLogger(frmPessoaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(JOptionPane.showConfirmDialog(rootPane,"Deseja salvar?") == 0){
            pessoaDao.Salvar(pessoa);
            JOptionPane.showMessageDialog(rootPane,"Salvo com sucesso!");
        }else{
            JOptionPane.showMessageDialog(rootPane,"Operação Cancelada!");
        }
    }//GEN-LAST:event_btnSalvarCadastroPessoaActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed

        try{
            if(JOptionPane.showConfirmDialog(rootPane,"Deseja Apagar?") == 0){
                pessoaDao.Remover(pessoa);
                JOptionPane.showMessageDialog(rootPane,"Excluido com sucesso!");
            }else{
                JOptionPane.showMessageDialog(rootPane,"Operação Cancelada!");
            }
        }catch (Exception ex) {
            Logger.getLogger(frmPessoaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void txtDddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDddActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(rootPane,"Deseja Salvar?") == 0){
                
                Telefone t = new Telefone();
                t.setTelefone(Integer.parseInt(txtTelefone.getText()));
                
                pessoa.addTelefone(t);
                
                atualizaTabelaTelefones(pessoa.getTelefones());
                
                JOptionPane.showMessageDialog(rootPane,"Excluido com sucesso!");
            }else{
                JOptionPane.showMessageDialog(rootPane,"Operação Cancelada!");
            }
        }catch (Exception ex) {
            Logger.getLogger(frmPessoaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JToggleButton btnSalvarCadastroPessoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDataNascimentoCadastroPessoa;
    private javax.swing.JLabel lblDdd;
    private javax.swing.JLabel lblNomePessoaCadastro;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTabbedPane tabEndereco;
    private javax.swing.JTable tblTelefones;
    private javax.swing.JTextField txtDdd;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JFormattedTextField txtfDataNascimentoCadastroPessoa;
    // End of variables declaration//GEN-END:variables
}
