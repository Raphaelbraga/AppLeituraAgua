/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.DAO;

import br.com.model.Endereco;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Cleumar
 */
 @SuppressWarnings("static-access")
 
public class EnderecoDAO {

    private PreparedStatement stmt;

   
    public Endereco cadastrar(Endereco obj) {

        try {
            String sqlcadastra = "INSERT INTO endereco ( rua,  numero, complemento, distrito, bairro, cidade ) values (?,?,?,?,?,?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);           
            stmt.setString(1, obj.getRua());
            stmt.setInt(2, obj.getNumero());
            stmt.setString(3, obj.getComplemento());
            stmt.setString(4, obj.getDistrito());
            stmt.setString(5, obj.getBairro());
            stmt.setString(6, obj.getCidade());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return buscaPorId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Ocorreu um erro ao cadastrar o endereço!");
                }
            }

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public Endereco buscaPorId(int id) {
        String sqlListar = "SELECT * FROM endereco WHERE id_endereco = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Endereco obj = new Endereco();
                obj.setIdEndereco(rs.getInt("id_endereco"));
                obj.setRua(rs.getString("rua"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setDistrito(rs.getString("distrito"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));

                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   
    
    
    public Endereco buscaPorRuaNumero(String rua, int numero) {
        String sqlListar = "SELECT * FROM endereco where (rua = ? and numero = ?)";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setString(1, rua);
            stmt.setInt(2, numero);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Endereco obj = new Endereco();
                obj.setRua(rs.getString("rua"));
                obj.setNumero(rs.getInt("numero"));
                obj.setIdEndereco(rs.getInt("id_endereco"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setDistrito(rs.getString("distrito"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Endereco> listaPorRua(String ruaNumero){
        List<Endereco> enderecoList = new ArrayList<>();
        String sqlListar = "SELECT* FROM endereco WHERE rua LIKE? or numero LIKE? ";
        
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setString(1, "%"+ruaNumero+"%");
            stmt.setString(2, "%"+ruaNumero+"%");
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Endereco obj = new Endereco();
                obj.setRua(result.getString("rua"));
                obj.setNumero(result.getInt("numero"));
                obj.setIdEndereco(result.getInt("id_endereco"));
                obj.setComplemento(result.getString("complemento"));
                obj.setDistrito(result.getString("distrito"));
                obj.setBairro(result.getString("bairro"));
                obj.setCidade(result.getString("cidade"));
                enderecoList.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            enderecoList = null;       
        } 
        return enderecoList;  
    }

    public List<Endereco> listar() {
        List<Endereco> lista = new ArrayList<Endereco>();
        String sqlListar = "SELECT * FROM endereco ";

        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Endereco obj = new Endereco();
                obj.setIdEndereco(rs.getInt("id_endereco"));
                obj.setRua(rs.getString("rua"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setDistrito(rs.getString("distrito"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                lista.add(obj);
            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }

    public Endereco atualizar(Endereco obj) {
        try {
            String sqlAtualiza = "UPDATE endereco SET (rua=?,"
                    + "numero=?, complemento=?, distrito=?, bairro?, cidade=? )  WHERE id_endereco = ?";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setString(1, obj.getRua());
            stmt.setInt(2, obj.getNumero());
            stmt.setString(3, obj.getComplemento());
            stmt.setString(4, obj.getDistrito());
            stmt.setString(5,obj.getBairro());
            stmt.setString(6,obj.getCidade());
            stmt.executeUpdate();
            
            return buscaPorId(obj.getIdEndereco());

        } catch (SQLException add) {
            add.getMessage();
        }
        return null;
    }

    public Boolean deletar(Endereco obj) {
        String sqlDel = "DELETE FROM endereco WHERE id_endereco =? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdEndereco());
            int retornoDelet = stmt.executeUpdate();
            
            if(retornoDelet ==1) {
                return true;    
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


