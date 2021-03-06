
package dao;

import Model.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpresaDao {

    Statement st;
    PreparedStatement prepst;

    static String INSERT = "INSERT INTO empresas(idEmpresa, idCidade, nome, cnpj, endereco, numero, bairro, "
            + "complemento, cep, telefonefixo, telefonecelular, email) "
            + "VALUES ((SELECT COALESCE(max(idempresa)+1,1) FROM empresas),?,?,?,?,?,?,?,?,?,?,?);";
    static String SELECTALL = "SELECT idEmpresa, idCidade, nome, cnpj, endereco, numero, bairro, "
            + "complemento, cep, telefonefixo, telefonecelular, email"
            + " FROM empresas order by nome;";
    static String UPDATE = "UPDATE empresas SET idCidade = ?, nome = ?, cnpj = ?, "
            + "endereco = ?, numero = ?, bairro = ? , complemento = ?, "
            + "cep = ?, telefonefixo = ?, telefonecelular = ?, email = ? WHERE idEmpresa = ?;";
    static String DELETE = "DELETE FROM empresas  WHERE idEmpresa = ?;";
    static String BUSCAIDEMPRESA = "SELECT idEmpresa FROM empresas WHERE nome = ?;";
    static String BUSCAIDCIDADE = "SELECT idCidade FROM cidades WHERE nome = ?;";

    public boolean insereCadastroEmpresa(Empresa empresa) {
        ResultSet rs;
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(INSERT);
            preparedStatement.setInt(1, empresa.getIdCidade());
            preparedStatement.setString(2, empresa.getNome());
            preparedStatement.setString(3, empresa.getCnpj());
            preparedStatement.setString(4, empresa.getEndereco());
            preparedStatement.setInt(5, empresa.getNumero());
            preparedStatement.setString(6, empresa.getBairro());
            preparedStatement.setString(7, empresa.getComplemento());
            preparedStatement.setString(8, empresa.getCep());
            preparedStatement.setString(9, empresa.getTelfixo());
            preparedStatement.setString(10, empresa.getTelcell());
            preparedStatement.setString(11, empresa.getEmail());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao inserir Cadastro Empresa: " + ex);
        }
        return false;
    }

    public ArrayList<Empresa> buscaCadastroEmpresa() {
        ArrayList<Empresa> lista = new ArrayList<Empresa>();
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(rs.getInt("IdEmpresa"));
                empresa.setIdCidade(rs.getInt("IdCidade"));
                empresa.setNome(rs.getString("nome"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setEndereco(rs.getString("endereco"));
                empresa.setNumero(rs.getInt("numero"));
                empresa.setBairro(rs.getString("bairro"));
                empresa.setComplemento(rs.getString("complemento"));
                empresa.setCep(rs.getString("cep"));
                empresa.setTelfixo(rs.getString("telefonefixo"));
                empresa.setTelcell(rs.getString("telefonecelular"));
                empresa.setEmail(rs.getString("email"));
                lista.add(empresa);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao carregar cadastro de empresas: " + ex);
        }
        return lista;
    }

    public boolean updateCadastroEmpresa(Empresa empresa) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATE);
            preparedStatement.setInt(1, empresa.getIdCidade());
            preparedStatement.setString(2, empresa.getNome());
            preparedStatement.setString(3, empresa.getCnpj());
            preparedStatement.setString(4, empresa.getEndereco());
            preparedStatement.setInt(5, empresa.getNumero());
            preparedStatement.setString(6, empresa.getBairro());
            preparedStatement.setString(7, empresa.getComplemento());
            preparedStatement.setString(8, empresa.getCep());
            preparedStatement.setString(9, empresa.getTelfixo());
            preparedStatement.setString(10, empresa.getTelcell());
            preparedStatement.setString(11, empresa.getEmail());
            preparedStatement.setInt(12, empresa.getIdEmpresa());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao fazer update do update do cadastro de empresa: " + ex);
        }
        return false;
    }

    public boolean excluirCadastroEmpresa(int id) {
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao deletar o empresa do cadastro empresa: " + ex);
        }
        return false;
    }

    public int buscaIdNomeEmpresa(String nome) {
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(BUSCAIDEMPRESA);
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idEmpresa");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao carregar idEmpresa: " + ex);
        }
        return id;
    }

    public int buscaIdNomeCidade(String nome) {
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(BUSCAIDCIDADE);
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idCidade");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao carregar idCidade: " + ex);
        }
        return id;
    }
}
