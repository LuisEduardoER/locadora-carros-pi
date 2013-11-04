/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import Globais.Geral;
/**
 *
 * @author rafael.baraldi
 */
public class TelaCadastros extends javax.swing.JFrame {

    /**
     * Creates new form Cadastros
     */
    public TelaCadastros() {
        initComponents();
        myInitComponents();
        
        this.setTitle(Geral.getEmpresa() + " - CADASTROS");
        this.setSize(Geral.getWidth(), Geral.getHeight());
        this.setLocationRelativeTo(null);
        
    }
    
    public void myInitComponents(){
        
        btnAluguel = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        btnCadastros = new javax.swing.JButton();
        btnLogoff = new javax.swing.JButton();
        lblBemVindo = new javax.swing.JLabel();
        lblCopyright = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblEndereco = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        //imgCapa = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAluguel.setText("Aluguel");

        btnRelatorio.setText("Relatórios");

        btnCadastros.setText("Cadastros");
        btnCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrosActionPerformed(evt);
            }
        });

        btnLogoff.setText("Sair");
        btnLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoffActionPerformed(evt);
            }
        });

        lblBemVindo.setText("Bem Vindo, Sr.(a) José Pereira");

        lblCopyright.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lblCopyright.setText("Copyright © Locadora S.I 2013");

        lblTelefone.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lblTelefone.setText("Telefone: (11) 5510-7070");

        lblEndereco.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lblEndereco.setText("Endereço: Rua Franciso Soares, 1200 - Santo Amarto - São Paulo /SP");

        //imgCapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/capa-carro.png"))); // NOI18N

        btnVoltar.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblBemVindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
            .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCopyright)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            //.addComponent(imgCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(btnVoltar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBemVindo)
                    .addComponent(btnLogoff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAluguel)
                    .addComponent(btnCadastros)
                    .addComponent(btnRelatorio)
                    .addComponent(btnVoltar))
                .addGap(42, 42, 42)
                //.addComponent(imgCapa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(lblCopyright))
                .addGap(6, 6, 6))
        );

        pack();
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        
        TelaMenuCadastros tela = new TelaMenuCadastros();
        tela.setVisible(true);
        this.setVisible(false);
    } 
    
    private void btnCadastrosActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        TelaMenuCadastros tela = new TelaMenuCadastros();
        
        tela.setVisible(true);
        this.setVisible(false);
    }                                            

    private void btnLogoffActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);
        this.setVisible(false);
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCliente = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnCarron = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnOutros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCliente.setText("Cliente");

        btnUsuario.setText("Usuário");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnCarron.setText("Carro");
        btnCarron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarronActionPerformed(evt);
            }
        });

        jButton1.setText("Fabricante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnOutros.setText("Outros");
        btnOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCarron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuario)
                    .addComponent(btnCliente))
                .addGap(33, 33, 33)
                .addComponent(btnCarron)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOutros)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutrosActionPerformed
        // TODO add your handling code here:
        
        TelaCadastroOutros tela = new TelaCadastroOutros();
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnOutrosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TelaCadastroFabricante tela = new TelaCadastroFabricante();
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCarronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarronActionPerformed
        // TODO add your handling code here:
        TelaCadastroCarro tela = new TelaCadastroCarro();
        tela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCarronActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastros().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAluguel;
    private javax.swing.JButton btnCadastros;
    private javax.swing.JButton btnLogoff;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnVoltar;
    //private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblCopyright;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblTelefone;
    // End of variables declaration        
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnVisualizar;
    // End of variables declaration      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarron;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnOutros;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
