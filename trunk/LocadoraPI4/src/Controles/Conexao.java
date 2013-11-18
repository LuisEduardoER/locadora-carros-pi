/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;


import Classes.Carro;
import Classes.Endereco;
import Classes.Fabricante;
import Classes.Motor;
import Classes.Telefone;
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
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
    public static void inserirOutros(String tabela, String coluna, String registro){
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
//                user.setData_nascimento(resultado.getDate("data_nascimento"));
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
    
    public static void inserirTelefone(Telefone tel){
        String query = "INSERT INTO telefone (ddi, ddd, numero, tipo) VALUES (" + tel.getDdi() + ", " + tel.getDdd() + ", " + tel.getNumero() + ", '" + tel.getTipo() + "')";
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
    
    public static void inserirEndereco(Endereco end){
        String query = "INSERT INTO endereco (cep, logradouro, numero, complemento, bairro, cidade, estado) VALUES ('" + end.getCep() + "', '" + end.getLogradouro() + "', " + end.getNumero() + ", '" + end.getComplemento() + "', '" + end.getBairro() + "', '" + end.getCidade() + "', '" + end.getEstado() + "')";
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
    
    public static int buscaIdTel(int ddi, int ddd, int numero){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT * FROM telefone WHERE (ddi = " + ddi + " AND ddd = " + ddd + " AND numero = " + numero + ")");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int id = 0;
        try {
//            user.setId(Integer.parseInt(resultado.getString("id")));
            if(!resultado.next()){
                return 0;
            }
            else{
                id = resultado.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public static int buscaIdEnd(String logradouro, int numero, String complemento){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT * FROM endereco WHERE (logradouro = '" + logradouro + "' AND numero = " + numero + " AND complemento = '" + complemento + "')");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int id = 0;
        try {
//            user.setId(Integer.parseInt(resultado.getString("id")));
            if(!resultado.next()){
                return 0;
            }
            else{
                id = resultado.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public static void inserirFabricante(Fabricante fab){
        String query = "INSERT INTO fabricante (nome, email, origem, id_telefone, id_endereco) VALUES ('" + fab.getNome() + "', '" + fab.getEmail() + "', '" + fab.getOrigem() + "', " + fab.getId_telefone() + ", " + fab.getId_endereco() + ")";
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
    
    public static ResultSet buscaTodoConteudo(String tabela){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT * FROM " + tabela);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
    public static void inserirMotor(Motor engine){
        String query = "INSERT INTO motor (potencia, valvulas, cilindros, cilindradas, alinhamento) VALUES (" + engine.getPotencia() + ", " + engine.getValvulas() + ", " + engine.getCilindros() + ", " + engine.getCilindradas()+ ", '" + engine.getAlinhamento() + "')";
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
    
    public static int buscaIdMotor(Motor engine){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            String query = "SELECT * FROM motor WHERE (potencia = " + engine.getPotencia() + " AND valvulas = " + engine.getValvulas() + " AND cilindros = " + engine.getCilindros() + " AND cilindradas = " + engine.getCilindradas() + " AND alinhamento = '" + engine.getAlinhamento() + "')";
            resultado = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int id = 0;
        try {
//            user.setId(Integer.parseInt(resultado.getString("id")));
            if(!resultado.next()){
                return 0;
            }
            else{
                id = resultado.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }

    public static void inserirCarro(Carro car){
        String query = "INSERT INTO carro (modelo, fabricante_id, ano, preco, portas_id, lugares_id, motor_id, carroceria_id, combustivel_id, cambio_id, direcao_id, categoria, placa) VALUES ('" + car.getModelo() + "', " + car.getFabricante_id() + ", " + car.getAno() + ", " + car.getPreco() + ", " + car.getPortas_id() + ", " + car.getLugares_id() + ", " + car.getMotor_id() + ", " + car.getCarroceria_id() + ", " + car.getCombustivel_id() + ", " + car.getCambio_id() + ", " + car.getDirecao_id() + ", '" + car.getCategoria() + "', '" + car.getPlaca() + "')";
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
    
    public static void inserirUsuario(Usuario user){
        String query = "INSERT INTO usuario (nome, email, senha, cpf, rg, permissao_id, cnh, categoria_carta, id_endereco, id_telefone) VALUES ('" + user.getNome() + "', '" + user.getEmail() + "', '" + user.getSenha() + "', '" + user.getCpf() + "', '" + user.getRg() + "', " + user.getPermissao() + ", '" + user.getCnh() + "', '" + user.getCategoria_carta() + "', " + user.getId_endereco() + ", " + user.getId_telefone() + ")";
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
    
    public static ResultSet buscaFabricante(String nome, String origem){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT * FROM fabricante WHERE (nome LIKE '%" + nome + "%' AND origem LIKE '%" + origem + "%')");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
    public static void excluirRegistro(String tabela, int id){
        String query = "DELETE FROM " + tabela + " WHERE (id = " + id + ")";
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
}