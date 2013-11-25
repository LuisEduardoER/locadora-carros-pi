/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.Aluguel;
import Classes.Carro;
import Classes.Usuario;
import Controles.Conexao;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class TelaNovoAluguel extends javax.swing.JFrame {

    boolean editar;
    Aluguel al;
    
    /**
     * Creates new form TelaNovoAluguel
     */
    public TelaNovoAluguel() {
        initComponents();
        
        editar = false;
        al = null;
    }
    
    public TelaNovoAluguel(Aluguel a) {
        initComponents();
        
        editar = true;
        al = a;
        
        txtCliente.setText("" + a.getCliente_id());
        txtCarro.setText("" + a.getCarro_id());
        chkboxSeguro.setSelected(a.isAssegurado());
        spnDiarias.setValue(a.getPrazo());
        
        btnRegistrar.setText("Alterar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        lblCarro = new javax.swing.JLabel();
        lblDiarias = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtCarro = new javax.swing.JTextField();
        spnDiarias = new javax.swing.JSpinner();
        chkboxSeguro = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCliente.setText("ID Cliente:");

        lblCarro.setText("ID Carro:");

        lblDiarias.setText("Diarias:");

        spnDiarias.setModel(new javax.swing.SpinnerNumberModel(1, 1, 365, 1));

        chkboxSeguro.setText("Seguro");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCliente)
                    .addComponent(lblCarro)
                    .addComponent(lblDiarias))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar)
                    .addComponent(chkboxSeguro)
                    .addComponent(spnDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCliente)
                        .addComponent(txtCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarro)
                    .addComponent(txtCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiarias)
                    .addComponent(spnDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkboxSeguro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        
        Aluguel novo = new Aluguel();
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //format it as per your requirement
        String dateNow = formatter.format(currentDate.getTime());
        System.out.println("Now the date is :=>  " + dateNow);

        
        Date data_retirada = new Date(currentDate.getTimeInMillis());
        Date data_entrega = new Date(currentDate.getTimeInMillis() + Integer.parseInt(spnDiarias.getValue().toString()) * 86400000);

        novo.setAssegurado(chkboxSeguro.isSelected());
        novo.setData_retirada(data_retirada);
        novo.setDate_entrega(data_entrega);
        novo.setPrazo(Integer.parseInt(spnDiarias.getValue().toString()));
        novo.setStatus_id(1);
        novo.setCarro_id(Integer.parseInt(txtCarro.getText()));
        novo.setCliente_id(Integer.parseInt(txtCliente.getText()));
        novo.setAtraso(0);
        
        
        Carro car = Conexao.buscaCarro(Integer.parseInt(txtCarro.getText()));
        
        double seguro = 0;
        
        if(novo.isAssegurado()){
            seguro = (novo.getPrazo() * car.getPreco()) * 0.1;
        }
        
        novo.setValor_parcial(novo.getPrazo() * car.getPreco() + seguro);
        novo.setValor_atraso(novo.getValor_parcial());
        
        if(editar){
            Conexao.alterarAluguel(novo);
        }
        else{        

            novo.setCarro(car);
            Usuario user = Conexao.buscaUsuario(Integer.parseInt(txtCliente.getText()));
            novo.setCliente(user);

            Conexao.inserirAluguel(novo);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaNovoAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovoAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovoAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovoAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovoAluguel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JCheckBox chkboxSeguro;
    private javax.swing.JLabel lblCarro;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDiarias;
    private javax.swing.JSpinner spnDiarias;
    private javax.swing.JTextField txtCarro;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}