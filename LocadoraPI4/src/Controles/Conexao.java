/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;


import Classes.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ana Carolina, Beatriz Henrique, Patricia Tertuliano, Weslly Akatuka
 */
public class Conexao {


public Conexao () {    }    


public static Connection connect = null;


    public static void Conectar() {
        System.out.println("Conectando ao banco...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/locadora_pi4", "root", "");
            //connect = DriverManager.getConnection("jdbc:mysql://localhost:3307/agenda", "root", "admin");
            System.out.println("Conectado! :)");
            
//            String query = "INSERT INTO agenda (nome, tel) VALUES ('rafael', '9999')";
//            Statement statement = connect.createStatement();
//            statement.executeUpdate(query);
            
            
//            ResultSet resultado;
//            resultado = statement.executeQuery("SELECT * FROM agenda");
//            
//            while ( resultado.next() ) {
//            
//                System.out.println(resultado.getString("nome"));
//            }
    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }


    }
    
    public static void inserir(String tabela, String coluna, String registro){
        String query = "INSERT INTO " + tabela + " (" + coluna + ") VALUES ('" + registro + "')";
            Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Usuario buscar_usuario(String busca){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT * FROM usuario WHERE (email = '" + busca + "')");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Usuario user = new Usuario();
        try {
//            user.setId(Integer.parseInt(resultado.getString("id")));
            if(!resultado.next()){
                return null;
            }
            else{
                user.setId(Integer.parseInt(resultado.getString("id")));
                user.setNome(resultado.getString("nome"));
                user.setEmail(resultado.getString("email"));
                user.setSenha(resultado.getString("senha"));
                user.setCpf(resultado.getString("cpf"));
                user.setRg(resultado.getString("rg"));
                //user.setData_nascimento(Date.parse(resultado.getString("data_nascimento")));
                user.setPermissao(Integer.parseInt(resultado.getString("permissao_id")));
                user.setCnh(resultado.getString("cnh"));
                user.setCategoria_carta(resultado.getString("categoria_carta"));
                user.setId_endereco(Integer.parseInt(resultado.getString("id_endereco")));
                user.setId_telefone(Integer.parseInt(resultado.getString("id_telefone")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
        
    }
}