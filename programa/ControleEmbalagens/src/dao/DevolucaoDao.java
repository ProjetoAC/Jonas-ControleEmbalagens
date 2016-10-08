
package dao;

import Model.Devolucao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DevolucaoDao {

    Statement st;
    PreparedStatement prepst;

    static String INSERT = "INSERT INTO devolucao(idDevolucao, idEmpresa, idPessoa, idProduto, "
            + "data, quantidade) "
            + "VALUES ((SELECT COALESCE(max(idDevolucao)+1,1) FROM devolucao),?,?,?,?,?);";
    static String SELECTALL = "SELECT idDevolucao, idempresa, idProduto, idpessoa, data, "
            + "quantidade,  flagEntrega, dataentrega FROM devolucao order by idDevolucao;";
    static String UPDATE = "UPDATE devolucao SET idDevolucao = ?, idempresa = ?, iddevolucao = ?, "
            + "idpessoa = ?, data = ?, quantidade = ?,  flagentrega = ?, dataentrega = ? "
            + "WHERE idDevolucao = ? ;";
    static String UPDATEDEVOLUCAO = "UPDATE devolucao SET idDevolucao = ?, flagentrega = ?, dataentrega = ? "
            + "WHERE idDevolucao = ?;";
    static String DELETE = "DELETE FROM devolucao  WHERE idDevolucao = ?;";

    public boolean insereCadastroDevolucao(Devolucao devolucao) {
        ResultSet rs;
        int id = 0;
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(INSERT);
            preparedStatement.setInt(1, devolucao.getIdEmpresa());
            preparedStatement.setInt(2, devolucao.getIdPessoa());
            preparedStatement.setInt(3, devolucao.getIdProduto());
            preparedStatement.setString(4, devolucao.getData());
            preparedStatement.setInt(5, devolucao.getQuantidade());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema ao inserir Cadastro Devolucao: " + ex);
        }
        return false;
    }

    public ArrayList<Devolucao> buscaCadastroDevolucao() {
        ArrayList<Devolucao> lista = new ArrayList<Devolucao>();

        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Devolucao devolucao = new Devolucao();
                devolucao.setIdDevolucao(rs.getInt("idDevolucao"));
                devolucao.setIdEmpresa(rs.getInt("idEmpresa"));
                devolucao.setIdPessoa(rs.getInt("idPessoa"));
                devolucao.setIdProduto(rs.getInt("idProduto"));
                devolucao.setData(rs.getString("data"));
                devolucao.setQuantidade(rs.getInt("quantidade"));
                devolucao.setFlagDevolucao(rs.getString("flagEntrega").charAt(0));
                devolucao.setDataEntrega(rs.getString("dataEntrega"));
                lista.add(devolucao);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao carregar cadastro de devolucao :" + ex);
        }
        return lista;
    }

    public boolean updateCadastroDevolucao(Devolucao devolucao) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATE);
            preparedStatement.setInt(1, devolucao.getIdDevolucao());
            preparedStatement.setInt(2, devolucao.getIdEmpresa());
            preparedStatement.setInt(3, devolucao.getIdPessoa());
            preparedStatement.setInt(4, devolucao.getIdProduto());
            preparedStatement.setString(5, devolucao.getData());
            preparedStatement.setInt(6, devolucao.getQuantidade());
            preparedStatement.setString(7, String.valueOf(devolucao.getFlagDevolucao()));//flagDevolucao
            preparedStatement.setString(8, devolucao.getDataEntrega());//DataEntrega
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao fazer update do update do cadastro de devolucao:" + ex);
        }
        return false;
    }

    public boolean excluirCadastroDevolucao(int id) {
        try {
            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao deletar o cadastro devolucao:" + ex);
        }
        return false;
    }

    public boolean updateDevolucao(Devolucao devolucao) {
        try {

            PreparedStatement preparedStatement = Conexao.getConexao().prepareStatement(UPDATEDEVOLUCAO);
            preparedStatement.setInt(1, devolucao.getIdDevolucao());
            preparedStatement.setString(2, String.valueOf(devolucao.getFlagDevolucao()));//flagDevolucao
            preparedStatement.setString(3, devolucao.getDataEntrega());//DataEntrega
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problema ao fazer update do update do cadastro de devolucao:" + ex);
        }
        return false;
    }
}
