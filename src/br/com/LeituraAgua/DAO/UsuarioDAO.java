/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Endereco;
import br.com.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

   private PreparedStatement stmt;

    public Usuario cadastrar(Usuario obj) {

        try {
            String sqlcadastra = "INSERT INTO usuario (tipo_usuario, login, senha ) values (?, ?, ?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getTipoUsuario());
            stmt.setString(2, obj.getLogin());
            stmt.setInt(3, obj.getSenha());
            stmt.executeUpdate();

            try ( ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return listarPorId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Ocorreu um erro ao cadastrar o endereço!");
                }
            }

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public Usuario listarPorId(int id) {
        String sqlListar = "SELECT * FROM usuario WHERE id_usuario = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario obj = new Usuario();
                obj.setIdUsuario(rs.getInt("id_usuario"));
                obj.setTipoUsuario(rs.getString("tipo_usuario"));
                obj.setLogin(rs.getString("login"));
                obj.setSenha(rs.getInt("senha"));

                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario logarUsuario(String login, int senha) {
        String sqlLogin = "SELECT * FROM usuario where (login = ? and senha = ?)";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlLogin);
            stmt.setString(1, login);
            stmt.setInt(2, senha);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id_usuario"),
                        rs.getString("tipo_usuario"), rs.getString("login"), rs.getInt("senha"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<Usuario>();
        String sqlListar = "SELECT * FROM usuario ";

        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlListar);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(result.getInt("id_usuario"));
                obj.setTipoUsuario(result.getString("tipo_usuario"));
                obj.setLogin(result.getString("login"));
                obj.setSenha(result.getInt("senha"));
                lista.add(obj);
            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }

    public Usuario listarPorUsuario(String login) {
        String sqlLogin = "SELECT * FROM usuario WHERE login = ?";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlLogin);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id_usuario"),
                        rs.getString("tipo_usuario"), rs.getString("login"), rs.getInt("senha"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Usuario> listarPorTermo(String termo) {
        List<Usuario> lista = new ArrayList<Usuario>();
        String sqlLogin = "SELECT * FROM usuario WHERE login like ? or id_usuario like ?";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlLogin);
            stmt.setString(1, "%" + termo + "%");
            stmt.setString(2, "%" + termo + "%");
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(result.getInt("id_usuario"));
                obj.setTipoUsuario(result.getString("tipo_usuario"));
                obj.setLogin(result.getString("login"));
                obj.setSenha(result.getInt("senha"));
                lista.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            lista = null;
        }
        return lista;
    }

    public Usuario atualizar(Usuario obj) {
        try {
            String sqlAtualiza = "UPDATE usuario SET tipo_Usuario=?, login=?, senha=? "
                    + " WHERE id_usuario=?";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setString(1, obj.getTipoUsuario());
            stmt.setString(2, obj.getLogin());
            stmt.setInt(3, obj.getSenha());
            stmt.setInt(4, obj.getIdUsuario());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("usuadio atualisado com sucesso!");
            }
            return listarPorId(obj.getIdUsuario());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public Boolean deletar(Usuario obj) {
        String sqlDel = "DELETE FROM usuario WHERE id_usuario =? ";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdUsuario());
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
