/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;


import Classes.Cambio;
import Classes.Carro;
import Classes.Carroceria;
import Classes.Combustivel;
import Classes.Direcao;
import Classes.Endereco;
import Classes.Fabricante;
import Classes.Lugares;
import Classes.Motor;
import Classes.Outros;
import Classes.Portas;
import Classes.Telefone;
import Classes.Usuario;
import java.sql.Connection;
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
    
    public static ResultSet buscaOutros(String nome, String tabela, String coluna){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT * FROM " + tabela + " WHERE (" + coluna + " LIKE '%" + nome + "%')");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
    public static ResultSet buscaCarro(String modelo, String ano, String cambio, String portas, String lugares, String carroceria, String direcao, String combustivel, String motor, String fabricante, String categoria, String placa){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT car.id, car.modelo, car.placa, f.nome AS fabricante, car.ano, car.preco, car.categoria, pt.quantidade AS portas, l.quantidade AS lugares, c.nome AS carroceria, com.nome AS combustivel, cb.nome AS cambio, d.nome AS direcao, m.potencia, m.valvulas, m.cilindros, m.cilindradas, m.alinhamento\n" +
                    "FROM carro AS car\n" +
                    "LEFT JOIN fabricante AS f\n" +
                    "ON car.fabricante_id = f.id\n" +
                    "LEFT JOIN portas AS pt\n" +
                    "ON car.portas_id = pt.id\n" +
                    "LEFT JOIN lugares AS l\n" +
                    "ON car.lugares_id = l.id\n" +
                    "LEFT JOIN motor AS m\n" +
                    "ON car.motor_id = m.id\n" +
                    "LEFT JOIN carroceria AS c\n" +
                    "ON car.carroceria_id = c.id\n" +
                    "LEFT JOIN combustivel AS com\n" +
                    "ON car.combustivel_id = com.id\n" +
                    "LEFT JOIN cambio AS cb\n" +
                    "ON car.cambio_id = cb.id\n" +
                    "LEFT JOIN direcao AS d\n" +
                    "ON car.direcao_id = d.id"
                    + " WHERE (car.modelo LIKE '%" + modelo +"%' "
                    + "AND car.ano LIKE '%" + ano + "%' "
                    + "AND cb.nome LIKE '%" + cambio + "%' "
                    + "AND pt.quantidade LIKE '%" + portas + "%' "
                    + "AND l.quantidade LIKE '%" + lugares + "%' "
                    + "AND c.nome LIKE '%" + carroceria + "%' "
                    + "AND d.nome LIKE '%" + direcao + "%' "
                    + "AND com.nome LIKE '%" + combustivel + "%' "
                    + "AND f.nome LIKE '%" + fabricante + "%' "
                    + "AND car.categoria LIKE '%" + categoria + "%' "
                    + "AND car.placa LIKE '%" + placa + "%' "
                    + "AND (m.potencia LIKE '%" + motor + "%' "
                    + "OR m.valvulas LIKE '%" + motor + "%' "
                    + "OR m.cilindros LIKE '%" + motor + "%' "
                    + "OR m.cilindradas LIKE '%" + motor + "%' "
                    + "OR m.alinhamento LIKE '%" + motor + "%'))");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
    public static Fabricante buscaFabricante(int id){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT f.id, f.nome, f.email, f.origem, f.id_telefone, f.id_endereco, \n" +
                    "t.ddi, t.ddd, t.numero, t.tipo, \n" +
                    "e.cep, e.logradouro, e.numero AS numerores, e.complemento, e.bairro, e.cidade, e.estado \n" +
                    "FROM fabricante AS f\n" +
                    "LEFT JOIN telefone AS t \n" +
                    "ON f.id_telefone = t.id \n" +
                    "LEFT JOIN endereco AS e \n" +
                    "ON f.id_endereco = e.id\n" +
                    "WHERE f.id = " + id);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Fabricante fab = new Fabricante();
        try {
//            user.setId(Integer.parseInt(resultado.getString("id")));
            if(!resultado.next()){
                return null;
            }
            else{
                fab.setId(Integer.parseInt(resultado.getString("id")));
                fab.setNome(resultado.getString("nome"));
                fab.setEmail(resultado.getString("email"));
                fab.setOrigem(resultado.getString("origem"));
                fab.setId_telefone(Integer.parseInt(resultado.getString("id_telefone")));
                fab.setId_endereco(Integer.parseInt(resultado.getString("id_endereco")));
                Telefone t = new Telefone();
                Endereco e = new Endereco();
                t.setId(Integer.parseInt(resultado.getString("id_telefone")));
                e.setId(Integer.parseInt(resultado.getString("id_endereco")));
                t.setDdd(Integer.parseInt(resultado.getString("ddi")));
                t.setDdi(Integer.parseInt(resultado.getString("ddd")));
                t.setNumero(Integer.parseInt(resultado.getString("numero")));
                t.setTipo(resultado.getString("tipo"));
                e.setCep(resultado.getString("cep"));
                e.setLogradouro(resultado.getString("logradouro"));
                e.setNumero(Integer.parseInt(resultado.getString("numerores")));
                e.setComplemento(resultado.getString("complemento"));
                e.setBairro(resultado.getString("bairro"));
                e.setCidade(resultado.getString("cidade"));
                e.setEstado(resultado.getString("estado"));
                fab.setTelefone(t);
                fab.setEndereco(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fab;
    }
    
    public static void alterarFabricante(Fabricante fab){
        String query = "UPDATE fabricante SET nome = '" + fab.getNome() + "', email = '" + fab.getEmail() + "', origem = '" + fab.getOrigem() + "' WHERE (id = " + fab.getId() + ")";  
        String query2 = "UPDATE telefone SET ddi = " + fab.getTelefone().getDdi()+ ", ddd = " + fab.getTelefone().getDdd()+ ", numero = " + fab.getTelefone().getNumero() + ", tipo = '" + fab.getTelefone().getTipo() + "' WHERE (id = " + fab.getId_telefone()+ ")";
        String query3 = "UPDATE endereco SET cep = '" + fab.getEndereco().getCep()+ "', logradouro = '" + fab.getEndereco().getLogradouro()+ "', numero = " + fab.getEndereco().getNumero() + ", complemento = '" + fab.getEndereco().getComplemento() + "', bairro = '" + fab.getEndereco().getBairro() + "', cidade = '" + fab.getEndereco().getCidade() + "', estado = '" + fab.getEndereco().getEstado() + "' WHERE (id = " + fab.getId_endereco()+ ")";
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Carro buscaCarro(int id){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT c.id, c.modelo, c.fabricante_id, c.ano, c.preco, c.portas_id, c.lugares_id, c.motor_id, c.carroceria_id, c.combustivel_id, c.cambio_id, c.direcao_id, c.categoria, c.placa, m.potencia, m.valvulas, m.cilindros, m.cilindradas, m.alinhamento \n" +
                    "FROM carro AS c \n" +
                    "LEFT JOIN motor AS m \n" +
                    "ON c.motor_id = m.id\n" +
                    "WHERE c.id = " + id);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Carro car = new Carro();
        try {
//            user.setId(Integer.parseInt(resultado.getString("id")));
            if(!resultado.next()){
                return null;
            }
            else{
                car.setId(Integer.parseInt(resultado.getString("id")));
                car.setModelo(resultado.getString("modelo"));
                car.setFabricante_id(Integer.parseInt(resultado.getString("fabricante_id")));
                car.setAno(Integer.parseInt(resultado.getString("ano")));
                car.setPreco(Double.parseDouble(resultado.getString("preco")));
                car.setPortas_id(Integer.parseInt(resultado.getString("portas_id")));
                car.setLugares_id(Integer.parseInt(resultado.getString("lugares_id")));
                car.setFabricante_id(Integer.parseInt(resultado.getString("fabricante_id")));
                car.setMotor_id(Integer.parseInt(resultado.getString("motor_id")));
                car.setCarroceria_id(Integer.parseInt(resultado.getString("carroceria_id")));
                car.setCombustivel_id(Integer.parseInt(resultado.getString("combustivel_id")));
                car.setCambio_id(Integer.parseInt(resultado.getString("cambio_id")));
                car.setDirecao_id(Integer.parseInt(resultado.getString("direcao_id")));
                car.setCategoria(resultado.getString("categoria"));
                car.setPlaca(resultado.getString("placa"));
                Motor mot = new Motor();
                mot.setId(resultado.getInt("motor_id"));
                mot.setPotencia(resultado.getInt("potencia"));
                mot.setValvulas(resultado.getInt("valvulas"));
                mot.setCilindros(resultado.getInt("cilindros"));
                mot.setCilindradas(resultado.getInt("cilindradas"));
                mot.setAlinhamento(resultado.getString("alinhamento"));
                car.setMotor(mot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return car;
    }
    
    public static void alterarCarro(Carro car){
        String query = "UPDATE carro SET modelo = '" + car.getModelo() + "', fabricante_id = " + car.getFabricante_id() + ", ano = " + car.getAno() + ", preco = " + car.getPreco() + ", portas_id = " + car.getPortas_id() + ", lugares_id = " + car.getLugares_id() + ", motor_id = " + car.getMotor_id() + ", carroceria_id = " + car.getCarroceria_id() + ", combustivel_id = " + car.getCombustivel_id() + ", cambio_id = " + car.getCambio_id() + ", direcao_id = " + car.getDirecao_id() + ", categoria = '" + car.getCategoria() + "', placa = '" + car.getPlaca() + "' WHERE (id = " + car.getId() + ")";  
        String query2 = "UPDATE motor SET potencia = " + car.getMotor().getPotencia()+ ", valvulas = " + car.getMotor().getValvulas()+ ", cilindros = " + car.getMotor().getCilindros() + ", cilindradas = " + car.getMotor().getCilindradas() + ", alinhamento = '" + car.getMotor().getAlinhamento() + "' WHERE (id = " + car.getMotor_id()+ ")";
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ResultSet buscaUsuario(String nome, String email, String cpf, String rg, String where){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT * FROM usuario WHERE (nome LIKE '%" + nome + "%' AND email LIKE '%" + email + "%' AND cpf LIKE '%" + cpf + "%' AND rg LIKE '%" + rg + "%'" + where + ")");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    
    public static void alterarOutros(String tabela, String campo, String valor, int id){ 
        String query = "UPDATE " + tabela + " SET " + campo + " = " + valor + " WHERE (id = " + id + ")";
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
    
    public static Outros buscaOutros(int id, String tabela){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT * "+
                    "FROM " + tabela + " " +
                    "WHERE id = " + id);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Outros out = null;
        try {
//            user.setId(Integer.parseInt(resultado.getString("id")));
            if(!resultado.next()){
                return null;
            }
            else{
                switch (tabela){
                    case "cambio":
                        Cambio c = new Cambio();
                        c.setId(resultado.getInt("id"));
                        c.setNome(resultado.getString("nome"));
                        out = c;
                        break;
                        
                    case "combustivel":
                        Combustivel co = new Combustivel();
                        co.setId(resultado.getInt("id"));
                        co.setNome(resultado.getString("nome"));
                        out = co;
                        break;
                        
                    case "carroceria":
                        Carroceria ca = new Carroceria();
                        ca.setId(resultado.getInt("id"));
                        ca.setNome(resultado.getString("nome"));
                        out = ca;
                        break;
                        
                    case "direcao":
                        Direcao d = new Direcao();
                        d.setId(resultado.getInt("id"));
                        d.setNome(resultado.getString("nome"));
                        out = d;
                        break;
                        
                    case "portas":
                        Portas p = new Portas();
                        p.setId(resultado.getInt("id"));
                        p.setQuantidade(resultado.getInt("quantidade"));
                        out = p;
                        break;
                        
                    case "lugares":
                        Lugares l = new Lugares();
                        l.setId(resultado.getInt("id"));
                        l.setQuantidade(resultado.getInt("quantidade"));
                        out = l;
                        break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return out;
    }
    
    public static void alterarUsuario(Usuario fab){
        String query = "UPDATE usuario SET nome = '" + fab.getNome() + "', email = '" + fab.getEmail() + "', senha = '" + fab.getSenha() + "', cpf = '" + fab.getCpf() + "', rg = '" + fab.getRg() + "', permissao_id = " + fab.getPermissao() + ", cnh = '" + fab.getCnh() + "', categoria_carta = '" + fab.getCategoria_carta() + "' WHERE (id = " + fab.getId() + ")";  
        String query2 = "UPDATE telefone SET ddi = " + fab.getTelefone().getDdi()+ ", ddd = " + fab.getTelefone().getDdd()+ ", numero = " + fab.getTelefone().getNumero() + ", tipo = '" + fab.getTelefone().getTipo() + "' WHERE (id = " + fab.getId_telefone()+ ")";
        String query3 = "UPDATE endereco SET cep = '" + fab.getEndereco().getCep()+ "', logradouro = '" + fab.getEndereco().getLogradouro()+ "', numero = " + fab.getEndereco().getNumero() + ", complemento = '" + fab.getEndereco().getComplemento() + "', bairro = '" + fab.getEndereco().getBairro() + "', cidade = '" + fab.getEndereco().getCidade() + "', estado = '" + fab.getEndereco().getEstado() + "' WHERE (id = " + fab.getId_endereco()+ ")";
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Usuario buscaUsuario(int id){
        Statement statement = null;
        try {
            statement = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet resultado = null;
        try {
            resultado = statement.executeQuery("SELECT f.id, f.nome, f.email, f.senha, f.id_telefone, f.id_endereco, f.cpf, f.rg, f.cnh, f.permissao_id, f.categoria_carta, \n" +
                    "t.ddi, t.ddd, t.numero, t.tipo, \n" +
                    "e.cep, e.logradouro, e.numero AS numerores, e.complemento, e.bairro, e.cidade, e.estado \n" +
                    "FROM usuario AS f\n" +
                    "LEFT JOIN telefone AS t \n" +
                    "ON f.id_telefone = t.id \n" +
                    "LEFT JOIN endereco AS e \n" +
                    "ON f.id_endereco = e.id\n" +
                    "WHERE f.id = " + id);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Usuario fab = new Usuario();
        try {
//            user.setId(Integer.parseInt(resultado.getString("id")));
            if(!resultado.next()){
                return null;
            }
            else{
                fab.setId(Integer.parseInt(resultado.getString("id")));
                fab.setNome(resultado.getString("nome"));
                fab.setEmail(resultado.getString("email"));
                fab.setSenha(resultado.getString("senha"));
                fab.setCpf(resultado.getString("cpf"));
                fab.setRg(resultado.getString("rg"));
                fab.setCnh(resultado.getString("cnh"));
                fab.setCategoria_carta(resultado.getString("categoria_carta"));
                fab.setPermissao(resultado.getInt("permissao_id"));
                fab.setId_telefone(Integer.parseInt(resultado.getString("id_telefone")));
                fab.setId_endereco(Integer.parseInt(resultado.getString("id_endereco")));
                Telefone t = new Telefone();
                Endereco e = new Endereco();
                t.setId(Integer.parseInt(resultado.getString("id_telefone")));
                e.setId(Integer.parseInt(resultado.getString("id_endereco")));
                t.setDdd(Integer.parseInt(resultado.getString("ddi")));
                t.setDdi(Integer.parseInt(resultado.getString("ddd")));
                t.setNumero(Integer.parseInt(resultado.getString("numero")));
                t.setTipo(resultado.getString("tipo"));
                e.setCep(resultado.getString("cep"));
                e.setLogradouro(resultado.getString("logradouro"));
                e.setNumero(Integer.parseInt(resultado.getString("numerores")));
                e.setComplemento(resultado.getString("complemento"));
                e.setBairro(resultado.getString("bairro"));
                e.setCidade(resultado.getString("cidade"));
                e.setEstado(resultado.getString("estado"));
                fab.setTelefone(t);
                fab.setEndereco(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fab;
    }
}