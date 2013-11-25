/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.Endereco;
import Classes.Fabricante;
import Classes.Telefone;
import Controles.Conexao;
import Globais.Geral;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class TelaCadastroFabricante extends javax.swing.JFrame {

    boolean editar;
    Fabricante fabri;
    
    /**
     * Creates new form TelaCadastroFabricante
     */
    public TelaCadastroFabricante() {
        initComponents();
        myInitComponents();
        
        this.setTitle(Geral.getEmpresa() + " - CADASTRO FABRICANTE");
        this.setSize(Geral.width, 650);
        this.setLocationRelativeTo(null);
        
        //Não deixa maximizar
        this.setResizable(false);
        
        //Não deixa Fechar
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Nome do usuario
        lblBemVindo.setText("Bem Vindo, Sr.(a) " + Geral.getUser().getNome());
        
        //Vem do inserir
        editar = false;
        fabri = null;
    }
    
    //Editar
    public TelaCadastroFabricante(Fabricante fab) {
        initComponents();
        myInitComponents();
        
        this.setTitle(Geral.getEmpresa() + " - CADASTRO FABRICANTE");
        this.setSize(Geral.width, 650);
        this.setLocationRelativeTo(null);
        
        //Não deixa maximizar
        this.setResizable(false);
        
        //Não deixa Fechar
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Nome do usuario
        lblBemVindo.setText("Bem Vindo, Sr.(a) " + Geral.getUser().getNome());
        
        btnInserir.setText("Alterar");
            
        //Vem do Editar
        editar = true;
        this.fabri = fab;
        
        txtNome.setText(fab.getNome());
        txtEmail.setText(fab.getEmail());
        txtOrigem.setText(fab.getOrigem());
        txtDDI.setText("" + fab.getTelefone().getDdi());
        txtDDD.setText("" + fab.getTelefone().getDdd());
        txtNumero.setText("" + fab.getTelefone().getNumero());
        txtTipo.setText(fab.getTelefone().getTipo());
        txtCEP.setText(fab.getEndereco().getCep());
        txtLogradouro.setText(fab.getEndereco().getLogradouro());
        txtNumeroRes.setText("" + fab.getEndereco().getNumero());
        txtComplemento.setText(fab.getEndereco().getComplemento());
        txtBairro.setText(fab.getEndereco().getBairro());
        txtCidade.setText(fab.getEndereco().getCidade());
        txtEstado.setText(fab.getEndereco().getEstado());
    }
    
    public void myInitComponents(){
        
        btnAluguel = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        btnCadastros = new javax.swing.JButton();
        btnLogoff = new javax.swing.JButton();
        lblBemVindo = new javax.swing.JLabel();
        lblCopyright = new javax.swing.JLabel();
        lblTelefoneBase = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblEnderecoBase = new javax.swing.JLabel();
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

        lblTelefoneBase.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lblTelefoneBase.setText("Telefone: (11) 5510-7070");

        lblEnderecoBase.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lblEnderecoBase.setText("Endereço: Rua Franciso Soares, 1200 - Santo Amarto - São Paulo /SP");

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
                        .addComponent(lblEnderecoBase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCopyright))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefoneBase)
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
                .addComponent(lblTelefoneBase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnderecoBase)
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

        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblOrigem = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtOrigem = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        lblDDI = new javax.swing.JLabel();
        txtDDI = new javax.swing.JTextField();
        lblDDD = new javax.swing.JLabel();
        txtDDD = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lbltTipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        txtCEP = new javax.swing.JTextField();
        lblLogradouro = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        lblNumeroRes = new javax.swing.JLabel();
        txtNumeroRes = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNome.setText("Nome:");

        lblEmail.setText("E-mail:");

        lblOrigem.setText("Origem:");

        lblTelefone.setText("Telefone:");

        lblDDI.setText("DDI:");

        lblDDD.setText("DDD:");

        lblNumero.setText("Numero:");

        lbltTipo.setText("Tipo:");

        lblEndereco.setText("Endereco:");

        lblCEP.setText("CEP:");

        lblLogradouro.setText("Logradouro:");

        txtLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogradouroActionPerformed(evt);
            }
        });

        lblNumeroRes.setText("Numero:");

        txtNumeroRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroResActionPerformed(evt);
            }
        });

        lblComplemento.setText("Complemento:");

        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });

        lblBairro.setText("Bairro:");

        lblCidade.setText("Cidade:");

        lblEstado.setText("Estado:");

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCEP)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumero)
                                    .addComponent(lblDDI))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDDI, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblEndereco)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblOrigem)
                                            .addComponent(lblNome)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblEmail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                    .addComponent(txtEmail)
                                    .addComponent(txtNome))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEstado)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnInserir))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNumeroRes)
                                        .addComponent(lblBairro))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtNumeroRes, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lblComplemento))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lblCidade)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lbltTipo)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lblLogradouro)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(lblDDD)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(9, 9, 9))))
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrigem)
                    .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDDD)
                            .addComponent(txtDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumero)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltTipo)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDDI)
                            .addComponent(txtDDI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(lblEndereco)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCEP)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogradouro)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroRes)
                    .addComponent(txtNumeroRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComplemento)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstado)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnInserir)))
                .addContainerGap(29, Short.MAX_VALUE))
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
                TelaConsultaFabricante tela = new TelaConsultaFabricante();       
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
        
        Telefone tel = new Telefone();

        tel.setId(fabri.getTelefone().getId());
        tel.setDdi(Integer.parseInt(txtDDI.getText()));
        tel.setDdd(Integer.parseInt(txtDDD.getText()));
        tel.setNumero(Integer.parseInt(txtNumero.getText()));
        tel.setTipo(txtTipo.getText());
        
        Endereco end = new Endereco();
        
        end.setId(fabri.getEndereco().getId());
        end.setCep(txtCEP.getText());
        end.setLogradouro(txtLogradouro.getText());
        end.setNumero(Integer.parseInt(txtNumeroRes.getText()));
        end.setComplemento(txtComplemento.getText());
        end.setBairro(txtBairro.getText());
        end.setCidade(txtCidade.getText());
        end.setEstado(txtEstado.getText());
        
        Fabricante fab = new Fabricante();

        fab.setId(fabri.getId());
        fab.setNome(txtNome.getText());
        fab.setEmail(txtEmail.getText());
        fab.setOrigem(txtOrigem.getText());
        
        if(editar){
            fab.setId_telefone(tel.getId());
            fab.setId_endereco(end.getId());
            
            fab.setTelefone(tel);
            fab.setEndereco(end);
            
            Conexao.alterarFabricante(fab);
        }
        else{
            Conexao.inserirTelefone(tel);

            Conexao.inserirEndereco(end);

            int idTel = Conexao.buscaIdTel(tel.getDdi(), tel.getDdd(), tel.getNumero());
            int idEnd = Conexao.buscaIdEnd(end.getLogradouro(), end.getNumero(), end.getComplemento());
            fab.setId_endereco(idEnd);
            fab.setId_telefone(idTel);

            Conexao.inserirFabricante(fab);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void txtLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogradouroActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtNumeroResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroResActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroResActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void btnOutrosActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        TelaCadastroOutros tela = new TelaCadastroOutros();
        tela.setVisible(true);
        this.setVisible(false);
    }                                         

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        TelaCadastroFabricante tela = new TelaCadastroFabricante();
        tela.setVisible(true);
        this.setVisible(false);
    } 
    
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
            java.util.logging.Logger.getLogger(TelaCadastroFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroFabricante().setVisible(true);
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
    private javax.swing.JLabel lblEnderecoBase;
    private javax.swing.JLabel lblTelefoneBase;
    // End of variables declaration        
    
    // Variables declaration - do not modify                     
    // End of variables declaration      
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInserir;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblDDD;
    private javax.swing.JLabel lblDDI;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblNumeroRes;
    private javax.swing.JLabel lblOrigem;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lbltTipo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtDDD;
    private javax.swing.JTextField txtDDI;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtNumeroRes;
    private javax.swing.JTextField txtOrigem;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
