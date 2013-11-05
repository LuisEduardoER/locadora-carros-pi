/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globais;

import Classes.Usuario;

/**
 *
 * @author rafael.baraldi
 */
public class Geral extends javax.swing.JFrame {
    
    private static String empresa = "LOCADORA S.I.";
    public static final int width = 520;  
    public static final int height = 500;  
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
}
