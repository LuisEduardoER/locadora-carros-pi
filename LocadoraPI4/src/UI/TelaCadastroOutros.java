/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.Cambio;
import Classes.Carroceria;
import Classes.Combustivel;
import Classes.Direcao;
import Classes.Lugares;
import Classes.Outros;
import Classes.Portas;
import Controles.Conexao;
import Globais.Geral;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael.csilva
 */
public class TelaCadastroOutros extends javax.swing.JFrame {

    String campo;
    Outros o;
    
    /**
     * Creates new form Outros
     */
    public TelaCadastroOutros() {
        initComponents();
        myInitComponents();
        
        this.setTitle(Geral.getEmpresa() + " - CADASTRO OUTROS");
        this.setSize(Geral.width, Geral.height);
        this.setLocationRelativeTo(null);
        
        //Não deixa maximizar
        this.setResizable(false);
        
        //Não deixa Fechar
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Nome do usuario
        lblBemVindo.setText("Bem Vindo, Sr.(a) " + Geral.getUser().getNome());
        
        campo = "nenhum";
        o = null;
    }
    
    public TelaCadastroOutros(Outros out, String cp) {
        initComponents();
        myInitComponents();
        
        this.setTitle(Geral.getEmpresa() + " - CADASTRO OUTROS");
        this.setSize(Geral.width, Geral.height);
        this.setLocationRelativeTo(null);
        
        //Não deixa maximizar
        this.setResizable(false);
        
        //Não deixa Fechar
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Nome do usuario
        lblBemVindo.setText("Bem Vindo, Sr.(a) " + Geral.getUser().getNome());
        
        campo = cp;
        o = out;
        
        btnCambio.setEnabled(false);
        btnCarroceria.setEnabled(false);
        btnDirecao.setEnabled(false);
        btnLugares.setEnabled(false);
        btnPortas.setEnabled(false);
        btnCombustivel.setEnabled(false);
            
        btnCambio.setText("Alterar");    
        btnCombustivel.setText("Alterar");    
        btnCarroceria.setText("Alterar");    
        btnDirecao.setText("Alterar");    
        btnLugares.setText("Alterar");    
        btnPortas.setText("Alterar");
        
        switch (cp){
            case "combustivel":
                btnCombustivel.setEnabled(true);
                txtCombustivel.setText(((Combustivel)out).getNome());                        
                break;
            case "cambio":
                btnCambio.setEnabled(true);
                txtCambio.setText(((Cambio)out).getNome()); 
                break;
            case "carroceria":
                btnCarroceria.setEnabled(true);
                txtCarroceria.setText(((Carroceria)out).getNome()); 
                break;
            case "direcao":
                btnDirecao.setEnabled(true);
                txtDirecao.setText(((Direcao)out).getNome()); 
                break;
            case "lugares":
                btnLugares.setEnabled(true);
                txtLugares.setText("" + ((Lugares)out).getQuantidade()); 
                break;
            case "portas":
                btnPortas.setEnabled(true);
                txtPortas.setText("" + ((Portas)out).getQuantidade()); 
                break;
        }
    }
    
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String[] options = new String[] { "Sim", "Cancelar" };

        Object ret = JOptionPane.showOptionDialog(null, "Deseja voltar ?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        
        if(ret == JOptionPane.YES_NO_OPTION){        
            TelaCadastros tela = new TelaCadastros();
            tela.setVisible(true);
            this.setVisible(false);
        }
    } 
    
    private void btnAluguelActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        TelaMenuAluguel tela = new TelaMenuAluguel();
        Geral.telaAluguelActionPerformed(tela);
    }                                          

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        TelaMenuRelatorios tela = new TelaMenuRelatorios();
        Geral.telaRelatoriosActionPerformed(tela);
    } 
    
    private void btnCadastrosActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        
        String[] options = new String[] { "Sim", "Cancelar" };

        Object ret = JOptionPane.showOptionDialog(null, "Deseja sair dessa tela ?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        
        if(ret == JOptionPane.YES_NO_OPTION){
            TelaMenuCadastros tela = new TelaMenuCadastros();
            tela.setVisible(true);
            this.setVisible(false);
        }
    }                                            

    private void btnLogoffActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String[] options = new String[] { "Sim", "Cancelar" };

        Object ret = JOptionPane.showOptionDialog(null, "Deseja fechar a sessão ?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        
        if(ret == JOptionPane.YES_NO_OPTION){
            TelaInicial tela = new TelaInicial();
            tela.setVisible(true);
            this.setVisible(false);
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
                .addGap(89, 89, 89)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
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
        if(campo.equalsIgnoreCase("nenhum")){
            Conexao.inserirOutros("combustivel", "nome", txtCombustivel.getText());
        }
        else if(campo.equalsIgnoreCase("combustivel")){
            Conexao.alterarOutros("combustivel", "nome", "'" + txtCombustivel.getText() + "'", ((Combustivel)o).getId());
        }
    }//GEN-LAST:event_btnCombustivelActionPerformed

    private void btnCarroceriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarroceriaActionPerformed
        // TODO add your handling code here:
        if(campo.equalsIgnoreCase("nenhum")){
            Conexao.inserirOutros("carroceria", "nome", txtCarroceria.getText());
        }
        else if(campo.equalsIgnoreCase("carroceria")){
            Conexao.alterarOutros("carroceria", "nome", "'" + txtCarroceria.getText() + "'", ((Carroceria)o).getId());
        }
    }//GEN-LAST:event_btnCarroceriaActionPerformed

    private void btnLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLugaresActionPerformed
        // TODO add your handling code here:
        if(campo.equalsIgnoreCase("nenhum")){
            Conexao.inserirOutros("lugares", "quantidade", txtLugares.getText());
        }
        else if(campo.equalsIgnoreCase("lugares")){
            Conexao.alterarOutros("lugares", "quantidade", txtLugares.getText(), ((Lugares)o).getId());
        }
    }//GEN-LAST:event_btnLugaresActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        // TODO add your handling code here:
        if(campo.equalsIgnoreCase("nenhum")){
            Conexao.inserirOutros("cambio", "nome", txtCambio.getText());
        }
        else if(campo.equalsIgnoreCase("cambio")){
            Conexao.alterarOutros("cambio", "nome", "'" + txtCambio.getText() + "'", ((Cambio)o).getId());
        }
    }//GEN-LAST:event_btnCambioActionPerformed

    private void btnPortasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortasActionPerformed
        // TODO add your handling code here:
        if(campo.equalsIgnoreCase("nenhum")){
            Conexao.inserirOutros("portas", "quantidade", txtPortas.getText());
        }
        else if(campo.equalsIgnoreCase("portas")){
            Conexao.alterarOutros("portas", "quantidade", txtPortas.getText(), ((Portas)o).getId());
        }
    }//GEN-LAST:event_btnPortasActionPerformed

    private void btnDirecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirecaoActionPerformed
        // TODO add your handling code here:
        if(campo.equalsIgnoreCase("nenhum")){
            Conexao.inserirOutros("direcao", "nome", txtDirecao.getText());
        }
        else if(campo.equalsIgnoreCase("direcao")){
            Conexao.alterarOutros("direcao", "nome", "'" + txtDirecao.getText() + "'", ((Direcao)o).getId());
        }
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
            java.util.logging.Logger.getLogger(TelaCadastroOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroOutros().setVisible(true);
            }
        });
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
        bar2 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAluguel.setText("Aluguel");
        btnAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAluguelActionPerformed(evt);
            }
        });
        btnRelatorio.setText("Relatórios");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });
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
            .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                //.addComponent(imgCapa, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(bar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblBemVindo)
                .addGap(18, 18, 18)
                .addComponent(btnLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCopyright))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnVoltar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBemVindo)
                    .addComponent(btnLogoff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAluguel)
                    .addComponent(btnCadastros)
                    .addComponent(btnRelatorio)
                    .addComponent(btnVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bar2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                //.addComponent(imgCapa)
                .addGap(40, 40, 40)
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
    
    // Variables declaration - do not modify                     
    public javax.swing.JProgressBar bar2;
    public javax.swing.JButton btnAluguel;
    public javax.swing.JButton btnCadastros;
    public javax.swing.JButton btnLogoff;
    public javax.swing.JButton btnRelatorio;
    public javax.swing.JButton btnVoltar;
    //public javax.swing.JLabel jLabel5;
    public javax.swing.JProgressBar jProgressBar1;
    public javax.swing.JProgressBar jProgressBar3;
    public javax.swing.JLabel lblBemVindo;
    public javax.swing.JLabel lblCopyright;
    public javax.swing.JLabel lblEndereco;
    public javax.swing.JLabel lblTelefone;
    // End of variables declaration        
    
    // Variables declaration - do not modify                     
//    private javax.swing.JButton btnInserir;
//    private javax.swing.JButton btnVisualizar;
    // End of variables declaration     

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
