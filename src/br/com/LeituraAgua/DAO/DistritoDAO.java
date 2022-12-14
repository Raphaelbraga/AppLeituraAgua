/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Consumidor;
import br.com.model.Distrito;
import br.com.model.Endereco;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DistritoDAO {

    private PreparedStatement stmt;

    public Distrito cadastrar(Distrito obj) {
        
        try {
            
            String sqlcadastra = " INSERT INTO distrito (nome_distrito, cidade ) values(?,?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getNomeDistrito());
            stmt.setString(2, obj.getCidade());
            stmt.executeUpdate();

            try ( ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return listarPorId(generatedKeys.getInt(0));
                } else {
                    throw new SQLException("Ocorreu um erro ao cadastrar o distrito!");
                }
            }

        } catch (SQLException add) {
            add.printStackTrace();
        }
        return null;
    }

    public Distrito listarPorNome(String nome) {
        String sqlListar = "SELECT * FROM distrito WHERE nome_distrito = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Distrito dist = new Distrito(rs.getInt("id_distrito"),
                rs.getString("nome_distrito"), rs.getString("cidade"));
                return dist;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Distrito listarPorId(Integer id) {
        String sqlListar = "SELECT * FROM distrito WHERE id_distrito = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Distrito dist = new Distrito(rs.getInt("id_distrito"), rs.getString("nome_distrito"), rs.getString("cidade"));
                return dist;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Distrito> listar() {
        List<Distrito> lista = new ArrayList<Distrito>();
        String sqlListar = "SELECT * FROM distrito ";

        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Distrito obj = new Distrito();
                obj.setIdDistrito(rs.getInt("id_distrito"));
                obj.setNomeDistrito(rs.getString("nome_distrito"));
                obj.setCidade(rs.getString("cidade"));

                lista.add(obj);
            }

        } catch (SQLException add) {
            lista = null;
            add.printStackTrace();
        }
        return lista;
    }
    
    public List <Distrito> listarPorTermo(String termo) {
        List<Distrito> lista = new ArrayList<Distrito> ();
        String sqlListar = "SELECT * FROM distrito WHERE nome_distrito like ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setString(1, "%" + termo + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Distrito dist = new Distrito();
                dist.setIdDistrito(rs.getInt("id_distrito"));
                dist.setNomeDistrito(rs.getString("nome_distrito"));
                dist.setCidade(rs.getString("cidade"));
                lista.add(dist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Distrito atualizar(Distrito obj) {
        try {
            String sqlAtualiza = "UPDATE distrito SET nome_distrito=?,"
                    + "cidade=?  WHERE id_distrito = ?";
            System.out.println(obj.getIdDistrito());
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setString(1, obj.getNomeDistrito());
            stmt.setString(2, obj.getCidade());
            stmt.setInt(3, obj.getIdDistrito());
            stmt.executeUpdate();

            return listarPorId(obj.getIdDistrito());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public Boolean deletar(Distrito obj) {
        String sqlDel = "DELETE FROM distrito WHERE id_distrito =? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdDistrito());
            int rowCount = stmt.executeUpdate();
            
            if (rowCount > 0) {
                return true;    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
