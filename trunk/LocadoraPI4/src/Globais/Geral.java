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
public class Geral {
    
    private static String empresa = "LOCADORA S.I.";
    private static final int width = 520;  
    private static final int height = 500;  
    private static Usuario user = null;
    
    public static String getEmpresa() {
        return empresa;
    }
    
    public static int getWidth() {
        return width;
    }    
    public static int getHeight() {
        return height;
    }

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        Geral.user = user;
    }

    
    
}
