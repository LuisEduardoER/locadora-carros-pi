/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globais;

import Classes.Usuario;
import UI.TelaInicial;
import UI.TelaMenuAluguel;
import UI.TelaMenuCadastros;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael.baraldi
 */
public class Geral extends javax.swing.JFrame {
    
    private static String empresa = "LOCADORA S.I.";
    public static final int width = 580;  
    public static final int height = 550;  
    private static Usuario user = null;
    
    public static String getEmpresa() {
        return empresa;
    }

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        Geral.user = user;
    }

    public static void voltaActionPerformed(JFrame telaAtual, JFrame telaVoltar) {
        
        telaAtual.setVisible(false);
        telaVoltar.setVisible(true);
    }
    
    public static void telaAluguelActionPerformed(JFrame telaAtual) {                                          
        
        String[] options = new String[] { "Sim", "Cancelar" };

        Object ret = JOptionPane.showOptionDialog(null, "Deseja sair dessa tela ?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        
        if(ret == JOptionPane.YES_NO_OPTION){
            TelaMenuAluguel tela = new TelaMenuAluguel();
            tela.setVisible(true);
            telaAtual.setVisible(false);
        }
    }
    
    public static void telaRelatoriosActionPerformed(JFrame telaAtual) {                                          
        
        String[] options = new String[] { "Sim", "Cancelar" };

        Object ret = JOptionPane.showOptionDialog(null, "Deseja sair dessa tela ?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        
        if(ret == JOptionPane.YES_NO_OPTION){
            TelaMenuAluguel tela = new TelaMenuAluguel();
            tela.setVisible(true);
            telaAtual.setVisible(false);
        }
    }
    
    public static void logoffActionPerformed(JFrame telaAtual, JFrame telaLogin) {                                          
        
        String[] options = new String[] { "Sim", "Cancelar" };

        Object ret = JOptionPane.showOptionDialog(null, "Deseja fechar a sessão ?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        
        if(ret == JOptionPane.YES_NO_OPTION){
            telaLogin.setVisible(true);
            telaAtual.setVisible(false);
        }
    } 
}
