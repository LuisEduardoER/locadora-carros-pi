/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.Cambio;
import Classes.Carro;
import Classes.Carroceria;
import Classes.Combustivel;
import Classes.Direcao;
import Classes.Fabricante;
import Classes.Lugares;
import Classes.Motor;
import Classes.Portas;
import Controles.Conexao;
import Globais.Geral;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael.csilva
 */
public class TelaCadastroCarro extends javax.swing.JFrame {

    boolean editar;
    Carro c;
    
    /**
     * Creates new form Motor
     */
    public TelaCadastroCarro() {
        initComponents();
        myInitComponents();
        
        this.setTitle(Geral.getEmpresa() + " - CADASTRO CARRO");
        this.setSize(555, 625);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Não deixa maximizar
        this.setResizable(false);
        
        //Não deixa Fechar
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        cboxFabricante.removeAllItems();
        cboxCambio.removeAllItems();
        cboxCarroceria.removeAllItems();
        cboxCombustivel.removeAllItems();
        cboxDirecao.removeAllItems();
        cboxLugares.removeAllItems();
        cboxPortas.removeAllItems();
        
        try {         
            ResultSet resultado = Conexao.buscaTodoConteudo("fabricante");
            
            while(resultado.next()){
                Fabricante f = new Fabricante();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxFabricante.addItem(f);
            }
            
            resultado = Conexao.buscaTodoConteudo("cambio");
            
            while(resultado.next()){
                Cambio f = new Cambio();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxCambio.addItem(f);
            }
            
            resultado = Conexao.buscaTodoConteudo("carroceria");
            
            while(resultado.next()){
                Carroceria f = new Carroceria();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxCarroceria.addItem(f);
            }
            
            resultado = Conexao.buscaTodoConteudo("combustivel");
            
            while(resultado.next()){
                Combustivel f = new Combustivel();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxCombustivel.addItem(f);
            }
            
            resultado = Conexao.buscaTodoConteudo("direcao");
            
            while(resultado.next()){
                Direcao f = new Direcao();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxDirecao.addItem(f);
            }
            
            resultado = Conexao.buscaTodoConteudo("lugares");
            
            while(resultado.next()){
                Lugares f = new Lugares();
                f.setQuantidade(resultado.getInt("quantidade"));
                f.setId(resultado.getInt("id"));
                cboxLugares.addItem(f);
            }
            
            resultado = Conexao.buscaTodoConteudo("portas");
            
            while(resultado.next()){
                Portas f = new Portas();
                f.setQuantidade(resultado.getInt("quantidade"));
                f.setId(resultado.getInt("id"));
                cboxPortas.addItem(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        editar = false;
        c = null;
    }

    public TelaCadastroCarro(Carro car) {
        initComponents();
        myInitComponents();
        
        this.setTitle(Geral.getEmpresa() + " - EDITAR CARRO");
        this.setSize(555, 625);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Não deixa maximizar
        this.setResizable(false);
        
        //Não deixa Fechar
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        cboxFabricante.removeAllItems();
        cboxCambio.removeAllItems();
        cboxCarroceria.removeAllItems();
        cboxCombustivel.removeAllItems();
        cboxDirecao.removeAllItems();
        cboxLugares.removeAllItems();
        cboxPortas.removeAllItems();
        
        try {         
            ResultSet resultado = Conexao.buscaTodoConteudo("fabricante");
            
            while(resultado.next()){
                Fabricante f = new Fabricante();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxFabricante.addItem(f);
                if(f.getId() == car.getFabricante_id()){
                    cboxFabricante.setSelectedItem(f);
                }
            }
            
            resultado = Conexao.buscaTodoConteudo("cambio");
            
            while(resultado.next()){
                Cambio f = new Cambio();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxCambio.addItem(f);
                if(f.getId() == car.getCambio_id()){
                    cboxCambio.setSelectedItem(f);
                }
            }
            
            resultado = Conexao.buscaTodoConteudo("carroceria");
            
            while(resultado.next()){
                Carroceria f = new Carroceria();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxCarroceria.addItem(f);
                if(f.getId() == car.getCarroceria_id()){
                    cboxCarroceria.setSelectedItem(f);
                }
            }
            
            resultado = Conexao.buscaTodoConteudo("combustivel");
            
            while(resultado.next()){
                Combustivel f = new Combustivel();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxCombustivel.addItem(f);
                if(f.getId() == car.getCombustivel_id()){
                    cboxCombustivel.setSelectedItem(f);
                }
            }
            
            resultado = Conexao.buscaTodoConteudo("direcao");
            
            while(resultado.next()){
                Direcao f = new Direcao();
                f.setNome(resultado.getString("nome"));
                f.setId(resultado.getInt("id"));
                cboxDirecao.addItem(f);
                if(f.getId() == car.getDirecao_id()){
                    cboxDirecao.setSelectedItem(f);
                }
            }
            
            resultado = Conexao.buscaTodoConteudo("lugares");
            
            while(resultado.next()){
                Lugares f = new Lugares();
                f.setQuantidade(resultado.getInt("quantidade"));
                f.setId(resultado.getInt("id"));
                cboxLugares.addItem(f);
                if(f.getId() == car.getLugares_id()){
                    cboxLugares.setSelectedItem(f);
                }
            }
            
            resultado = Conexao.buscaTodoConteudo("portas");
            
            while(resultado.next()){
                Portas f = new Portas();
                f.setQuantidade(resultado.getInt("quantidade"));
                f.setId(resultado.getInt("id"));
                cboxPortas.addItem(f);
                if(f.getId() == car.getPortas_id()){
                    cboxPortas.setSelectedItem(f);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastroCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtModelo.setText(car.getModelo());
        txtAlinhamento.setText(car.getMotor().getAlinhamento());
        txtAno.setText("" + car.getAno());
        txtCategoria.setText(car.getCategoria());
        txtCilindradas.setText("" + car.getMotor().getCilindradas());
        txtCilindros.setText("" + car.getMotor().getCilindros());
        txtPlaca.setText(car.getPlaca());
        txtPotencia.setText("" + car.getMotor().getPotencia());
        txtPreco.setText("" + car.getPreco());
        txtValvulas.setText("" + car.getMotor().getValvulas());
      
        editar = true;
        c = car;
        
        btnInserir.setText("Alterar");
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
        bar2 = new javax.swing.JProgressBar();
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        lblPotencia = new javax.swing.JLabel();
        lblFabricante = new javax.swing.JLabel();
        lblValvulas = new javax.swing.JLabel();
        lblAlinhamento = new javax.swing.JLabel();
        lblCilindros = new javax.swing.JLabel();
        lblCilindradas = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        txtPotencia = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtValvulas = new javax.swing.JTextField();
        txtAlinhamento = new javax.swing.JTextField();
        txtCilindros = new javax.swing.JTextField();
        txtCilindradas = new javax.swing.JTextField();
        cboxFabricante = new javax.swing.JComboBox();
        lblDirecao = new javax.swing.JLabel();
        lblPortas = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCarroceria = new javax.swing.JLabel();
        lblCombustivel = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        cboxCombustivel = new javax.swing.JComboBox();
        cboxCarroceria = new javax.swing.JComboBox();
        cboxLugares = new javax.swing.JComboBox();
        cboxPortas = new javax.swing.JComboBox();
        cboxCambio = new javax.swing.JComboBox();
        cboxDirecao = new javax.swing.JComboBox();
        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        lblAno = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPotencia.setText("Potência:");

        lblFabricante.setText("Fabricante:");

        lblValvulas.setText("Valvulas:");

        lblAlinhamento.setText("Alinhamento:");

        lblCilindros.setText("Cilindros:");

        lblCilindradas.setText("Cilindradas:");

        lblModelo.setText("Modelo:");

        cboxFabricante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDirecao.setText("Direção:");

        lblPortas.setText("Portas:");

        lblCambio.setText("Câmbio:");

        jLabel1.setText("Lugares:");

        lblCarroceria.setText("Carroceria:");

        lblCombustivel.setText("Combustível:");

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        cboxCombustivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboxCarroceria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboxLugares.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboxPortas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboxCambio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboxDirecao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCategoria.setText("Categoria:");

        lblAno.setText("Ano:");

        lblPreco.setText("Preço:");

        lblPlaca.setText("Placa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAno)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPlaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInserir))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFabricante)
                                        .addGap(21, 21, 21)
                                        .addComponent(cboxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(lblValvulas)
                                                    .addGap(33, 33, 33))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lblAlinhamento)
                                                    .addGap(13, 13, 13)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblCilindros)
                                                    .addComponent(lblCilindradas)
                                                    .addComponent(lblModelo)
                                                    .addComponent(lblPotencia))
                                                .addGap(20, 20, 20)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCilindradas)
                                            .addComponent(txtCilindros, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtAlinhamento, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtModelo)
                                            .addComponent(txtValvulas)
                                            .addComponent(txtPotencia)
                                            .addComponent(txtAno)
                                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCombustivel)
                                            .addComponent(lblCarroceria)
                                            .addComponent(jLabel1)
                                            .addComponent(lblPortas))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblDirecao)
                                            .addGap(23, 23, 23)))
                                    .addComponent(lblCambio)
                                    .addComponent(lblCategoria)
                                    .addComponent(lblPreco))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboxDirecao, 0, 156, Short.MAX_VALUE)
                                    .addComponent(cboxCambio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboxPortas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboxLugares, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboxCarroceria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboxCombustivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCategoria)
                                    .addComponent(txtPreco))))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFabricante)
                    .addComponent(lblCombustivel)
                    .addComponent(cboxCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarroceria)
                    .addComponent(cboxCarroceria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPotencia)
                            .addComponent(txtPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(cboxLugares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValvulas)
                            .addComponent(txtValvulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPortas)
                            .addComponent(cboxPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblAlinhamento))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAlinhamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCambio)
                        .addComponent(cboxCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCilindros)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCilindros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDirecao)
                        .addComponent(cboxDirecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCilindradas)
                    .addComponent(txtCilindradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoria)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnInserir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlaca)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        String[] options = new String[] { "Sim", "Cancelar" };

        Object ret = JOptionPane.showOptionDialog(null, "Deseja voltar ?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        
        
        if(ret == JOptionPane.YES_NO_OPTION){
            if(editar){
                TelaConsultaCarro tela = new TelaConsultaCarro();       
                tela.setVisible(true);
            }
            else{
                TelaCadastros tela = new TelaCadastros();
                tela.setVisible(true);
            }

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
    
    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        // TODO add your handling code here:
        Motor novoMotor = new Motor();
        novoMotor.setAlinhamento(txtAlinhamento.getText());
        novoMotor.setCilindradas(Integer.parseInt(txtCilindradas.getText()));
        novoMotor.setCilindros(Integer.parseInt(txtCilindros.getText()));
        novoMotor.setValvulas(Integer.parseInt(txtValvulas.getText()));
        novoMotor.setPotencia(Integer.parseInt(txtPotencia.getText()));
        
        Carro novoCarro = new Carro();
        novoCarro.setModelo(txtModelo.getText());
        novoCarro.setFabricante_id(((Fabricante)cboxFabricante.getSelectedItem()).getId());
        novoCarro.setAno(Integer.parseInt(txtAno.getText()));
        novoCarro.setPreco(Double.parseDouble(txtPreco.getText()));
        novoCarro.setCategoria(txtCategoria.getText());
        novoCarro.setPlaca(txtPlaca.getText());            
        novoCarro.setPortas_id(((Portas)cboxPortas.getSelectedItem()).getId());
        novoCarro.setLugares_id(((Lugares)cboxLugares.getSelectedItem()).getId());
        novoCarro.setCarroceria_id(((Carroceria)cboxCarroceria.getSelectedItem()).getId());
        novoCarro.setCombustivel_id(((Combustivel)cboxCombustivel.getSelectedItem()).getId());
        novoCarro.setCambio_id(((Cambio)cboxCambio.getSelectedItem()).getId());
        novoCarro.setDirecao_id(((Direcao)cboxDirecao.getSelectedItem()).getId());
        
        if(editar){            
            novoMotor.setId(c.getMotor().getId());
            novoCarro.setId(c.getId());
            
            novoCarro.setMotor_id(novoMotor.getId());
            novoCarro.setMotor(novoMotor);
            
            Conexao.alterarCarro(novoCarro);
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        }
        else{        
            Conexao.inserirMotor(novoMotor);

            novoCarro.setMotor_id(Conexao.buscaIdMotor(novoMotor));
            
            Conexao.inserirCarro(novoCarro);
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                    
        }
                
    }//GEN-LAST:event_btnInserirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCarro().setVisible(true);
            }
        });
    }   
    
    // Variables declaration - do not modify     
    private javax.swing.JProgressBar bar2;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInserir;
    private javax.swing.JComboBox cboxCambio;
    private javax.swing.JComboBox cboxCarroceria;
    private javax.swing.JComboBox cboxCombustivel;
    private javax.swing.JComboBox cboxDirecao;
    private javax.swing.JComboBox cboxFabricante;
    private javax.swing.JComboBox cboxLugares;
    private javax.swing.JComboBox cboxPortas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlinhamento;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblCarroceria;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCilindradas;
    private javax.swing.JLabel lblCilindros;
    private javax.swing.JLabel lblCombustivel;
    private javax.swing.JLabel lblDirecao;
    private javax.swing.JLabel lblFabricante;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblPortas;
    private javax.swing.JLabel lblPotencia;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblValvulas;
    private javax.swing.JTextField txtAlinhamento;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCilindradas;
    private javax.swing.JTextField txtCilindros;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPotencia;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtValvulas;
    // End of variables declaration//GEN-END:variables
}
