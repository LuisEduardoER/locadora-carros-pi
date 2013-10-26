/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controles.Conexao;
import Globais.Geral;

/**
 *
 * @author rafael.csilva
 */
public class Outros extends javax.swing.JFrame {

    /**
     * Creates new form Outros
     */
    public Outros() {
        initComponents();
        
        this.setTitle(Geral.getEmpresa() + " - OUTROS");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCombustivel = new javax.swing.JLabel();
        lblCarroceria = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        lblPortas = new javax.swing.JLabel();
        lblDirecao = new javax.swing.JLabel();
        txtCombustivel = new javax.swing.JTextField();
        txtCarroceria = new javax.swing.JTextField();
        txtLugares = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        txtPortas = new javax.swing.JTextField();
        txtDirecao = new javax.swing.JTextField();
        btnCombustivel = new javax.swing.JButton();
        btnCarroceria = new javax.swing.JButton();
        btnLugares = new javax.swing.JButton();
        btnPortas = new javax.swing.JButton();
        btnCambio = new javax.swing.JButton();
        btnDirecao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCombustivel.setText("Combustível");

        lblCarroceria.setText("Carroceria");

        jLabel1.setText("Lugares");

        lblCambio.setText("Câmbio");

        lblPortas.setText("Portas");

        lblDirecao.setText("Direção");

        btnCombustivel.setText("Inserir");
        btnCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCombustivelActionPerformed(evt);
            }
        });

        btnCarroceria.setText("Inserir");
        btnCarroceria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarroceriaActionPerformed(evt);
            }
        });

        btnLugares.setText("Inserir");
        btnLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLugaresActionPerformed(evt);
            }
        });

        btnPortas.setText("Inserir");
        btnPortas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortasActionPerformed(evt);
            }
        });

        btnCambio.setText("Inserir");
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });

        btnDirecao.setText("Inserir");
        btnDirecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirecaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCombustivel)
                    .addComponent(lblCarroceria)
                    .addComponent(jLabel1)
                    .addComponent(lblCambio)
                    .addComponent(lblPortas)
                    .addComponent(lblDirecao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCombustivel)
                    .addComponent(txtCarroceria)
                    .addComponent(txtLugares)
                    .addComponent(txtCambio)
                    .addComponent(txtPortas)
                    .addComponent(txtDirecao, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCombustivel)
                    .addComponent(btnCarroceria)
                    .addComponent(btnLugares)
                    .addComponent(btnPortas)
                    .addComponent(btnCambio)
                    .addComponent(btnDirecao))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCombustivel)
                    .addComponent(txtCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCombustivel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarroceria)
                    .addComponent(txtCarroceria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarroceria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLugares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLugares))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCambio)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPortas)
                    .addComponent(txtPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPortas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDirecao)
                    .addComponent(txtDirecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDirecao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCombustivelActionPerformed
        // TODO add your handling code here:
        Conexao.inserir("combustivel", "nome", txtCombustivel.getText());
    }//GEN-LAST:event_btnCombustivelActionPerformed

    private void btnCarroceriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarroceriaActionPerformed
        // TODO add your handling code here:
        Conexao.inserir("carroceria", "nome", txtCarroceria.getText());
    }//GEN-LAST:event_btnCarroceriaActionPerformed

    private void btnLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLugaresActionPerformed
        // TODO add your handling code here:
        Conexao.inserir("lugares", "quantidade", txtLugares.getText());
    }//GEN-LAST:event_btnLugaresActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        // TODO add your handling code here:
        Conexao.inserir("cambio", "nome", txtCambio.getText());
    }//GEN-LAST:event_btnCambioActionPerformed

    private void btnPortasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortasActionPerformed
        // TODO add your handling code here:
        Conexao.inserir("portas", "quantidade", txtPortas.getText());
    }//GEN-LAST:event_btnPortasActionPerformed

    private void btnDirecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirecaoActionPerformed
        // TODO add your handling code here:
        Conexao.inserir("direcao", "nome", txtDirecao.getText());
    }//GEN-LAST:event_btnDirecaoActionPerformed

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
            java.util.logging.Logger.getLogger(Outros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Outros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Outros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Outros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Outros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambio;
    private javax.swing.JButton btnCarroceria;
    private javax.swing.JButton btnCombustivel;
    private javax.swing.JButton btnDirecao;
    private javax.swing.JButton btnLugares;
    private javax.swing.JButton btnPortas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblCarroceria;
    private javax.swing.JLabel lblCombustivel;
    private javax.swing.JLabel lblDirecao;
    private javax.swing.JLabel lblPortas;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCarroceria;
    private javax.swing.JTextField txtCombustivel;
    private javax.swing.JTextField txtDirecao;
    private javax.swing.JTextField txtLugares;
    private javax.swing.JTextField txtPortas;
    // End of variables declaration//GEN-END:variables
}
