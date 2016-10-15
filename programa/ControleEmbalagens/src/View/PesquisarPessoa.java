package View;

import Model.Estado;
import Model.Pessoa;
import View.CadastroPessoa;
import View.Principal;
import controller.CidadeController;
import controller.EstadoController;
import controller.PessoaController;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class PesquisarPessoa extends javax.swing.JInternalFrame {

    PessoaController pc;
    EstadoController ec;
    CidadeController cc;
    CadastroPessoa enviaDados;
    Pessoa pessoa;
    ArrayList<Pessoa> listaPessoas;
    ArrayList<Estado> listaEstado;
    Principal telaPrincipal;
    String siglaEstado;

    public PesquisarPessoa() {
        initComponents();
        this.setTitle("Consulta de Cadastro de Empresas");
        desativaBotao();
        modeloTabela();
        exibirDadosCadastros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesqPessoa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnSelecionar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Pesquisar Nome:");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblPesqPessoa.setAutoCreateRowSorter(true);
        tblPesqPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPesqPessoa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblPesqPessoa.setAutoscrolls(false);
        jScrollPane1.setViewportView(tblPesqPessoa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnLimpar)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        pesquisar();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if (tblPesqPessoa.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Favor selecione uma linha na tabela!", "AVISO!", JOptionPane.WARNING_MESSAGE);
        } else {
            selecionaDadosTabela();
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparPesquisa();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPesqPessoa;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    private void desativaBotao() {
        this.setFrameIcon(null);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Container norteh = (Container) ui.getNorthPane();
        norteh.remove(0);
        norteh.validate();
        norteh.repaint();
    }

    DefaultTableModel modeloTabela = new DefaultTableModel(new Object[]{
        "Código", "Nome", "CPF", "RG", "Endereco", "Numero", "Bairro", "Complemento",
        "CEP", "Cidade", "Estado", "Tel Fixo", "Tel Celular", "E-mai", "Sexo"}, 0) {
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };

    private void modeloTabela() {
        tblPesqPessoa.setModel(modeloTabela);
        tblPesqPessoa.setAutoResizeMode(tblPesqPessoa.AUTO_RESIZE_OFF);
        ajustaTamanhoColunaTabela();
    }

    private void ajustaTamanhoColunaTabela() {
        tblPesqPessoa.getColumnModel().getColumn(0).setMinWidth(0);
        tblPesqPessoa.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblPesqPessoa.getColumnModel().getColumn(0).setMaxWidth(0);
        tblPesqPessoa.getColumnModel().getColumn(1).setPreferredWidth(200);//nome
        tblPesqPessoa.getColumnModel().getColumn(2).setPreferredWidth(120);//cpf
        tblPesqPessoa.getColumnModel().getColumn(3).setPreferredWidth(90);//rg
        tblPesqPessoa.getColumnModel().getColumn(4).setPreferredWidth(200);//endereco
        tblPesqPessoa.getColumnModel().getColumn(5).setPreferredWidth(60);//numero
        tblPesqPessoa.getColumnModel().getColumn(6).setPreferredWidth(150);//bairro
        tblPesqPessoa.getColumnModel().getColumn(7).setPreferredWidth(200);//complemento
        tblPesqPessoa.getColumnModel().getColumn(8).setPreferredWidth(80);//cep
        tblPesqPessoa.getColumnModel().getColumn(9).setPreferredWidth(150);//NomeCidade
        tblPesqPessoa.getColumnModel().getColumn(10).setPreferredWidth(60);//estado
        tblPesqPessoa.getColumnModel().getColumn(11).setPreferredWidth(110);//tel fixo
        tblPesqPessoa.getColumnModel().getColumn(12).setPreferredWidth(110);//tel cell
        tblPesqPessoa.getColumnModel().getColumn(13).setPreferredWidth(40);//sexo
        tblPesqPessoa.getColumnModel().getColumn(14).setPreferredWidth(250);//email
    }

    private void limparPesquisa() {
        txtPesquisa.setText("");
        exibirDadosCadastros();
    }

    private String carregaEstado(int idCidade) {
        String sigla;
        if (ec == null) {
            ec = new EstadoController();
        }
        return sigla = ec.buscarSiglaEstado(idCidade);
    }

    private String carregaCidade(int idCidade) {
        String nomeCidade;
        if (cc == null) {
            cc = new CidadeController();
        }
        return nomeCidade = cc.buscarCidade(idCidade);
    }

    private void insereDadosTabela(Pessoa pessoa) {
        Object[] dados = new Object[15];
        dados[0] = pessoa.getIdPessoa();
        dados[1] = pessoa.getNome();
        dados[2] = pessoa.getCpf();
        dados[3] = pessoa.getRg();
        dados[4] = pessoa.getEndereco();
        dados[5] = pessoa.getNumero();
        dados[6] = pessoa.getBairro();
        dados[7] = pessoa.getComplemento();
        dados[8] = pessoa.getCep();
        dados[9] = carregaCidade(pessoa.getIdCidade());
        dados[10] = carregaEstado(pessoa.getIdCidade());
        dados[11] = pessoa.getTelfixo();
        dados[12] = pessoa.getTelcell();
        dados[13] = pessoa.getSexo();
        dados[14] = pessoa.getEmail();
        modeloTabela.addRow(dados);
    }

    private int getIdPessoaSelecionado() {
        return Integer.parseInt(modeloTabela.getValueAt(tblPesqPessoa.getSelectedRow(), 0).toString());
    }

    public void exibirDadosCadastros() {
        modeloTabela.getDataVector().removeAllElements();
        modeloTabela();
        ArrayList<Pessoa> lista;
        if (pc == null) {
            pc = new PessoaController();
        }
        lista = pc.buscaCadastroPessoa();

        for (int x = 0; x < lista.size(); x++) {
            Pessoa p = lista.get(x);
            insereDadosTabela(p);
        }
        listaPessoas = lista;
    }

    private void pesquisar() {
        modeloTabela.getDataVector().removeAllElements();
        modeloTabela();
        txtPesquisa.getText();
        for (Pessoa p : listaPessoas) {
            if (p.getNome().toLowerCase().contains(txtPesquisa.getText().toLowerCase())) {
                insereDadosTabela(p);
            }
        }
    }

    private void carregaDadosCadastro() {
        int id = getIdPessoaSelecionado();
        for (int x = 0; x < listaPessoas.size(); x++) {
            Pessoa p = listaPessoas.get(x);
            pessoa = p;
            break;
        }
    }

    private void selecionaDadosTabela() {
        int id = getIdPessoaSelecionado();
        int a = 0, b = 0, c = 0;
        char d = ' ';
        String e = "", f = "", g = "", h = "", i = "", j = "", k = "", l = "", m = "", n = "", o = "";
        for (Pessoa p : listaPessoas) {
            if (p.getIdPessoa() == id) {
                a = p.getIdPessoa();
                b = p.getIdCidade();
                o = carregaEstado(p.getIdCidade());
                c = p.getNumero();
                d = p.getSexo();
                e = p.getNome();
                f = p.getCpf();
                g = p.getRg();
                h = p.getEndereco();
                i = p.getBairro();
                j = p.getComplemento();
                k = p.getCep();
                l = p.getTelfixo();
                m = p.getTelcell();
                n = p.getEmail();
                break;
            }
        }
        if (enviaDados == null) {
            enviaDados = new CadastroPessoa();
        }
        Principal.jdpPrincipal.add(enviaDados);
        enviaDados.setVisible(true);
        telaPrincipal.centralizaForm(enviaDados);
        enviaDados.recebeDados(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o);
        this.dispose();
    }
}
