
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.DAO;


import br.com.model.*;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class HidrometroDAO {


    private PreparedStatement  stmt;

    @SuppressWarnings("static-access")
    public Hidrometro cadastrar(Hidrometro obj) {
        try {
            String sqlcadastra = "INSERT INTO hidrometro (tag_hidrometro, leitura_Instalacao, situacao, id_Consumidor, id_Endereco ) values (?, ?, ?, ?, ?)";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlcadastra, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, obj.getTagHidrometro());
            stmt.setDouble(2, obj.getLeituraInstalacao());
            stmt.setBoolean(3, obj.isSituacao());
            stmt.setInt(4, obj.getConsumidor().getIdConsumidor());
            stmt.setInt(5, obj.getEndereco().getIdEndereco());
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
    
    public List<Hidrometro> listarPorTermo(int termo) {
        List<Hidrometro> lista = new ArrayList<Hidrometro>();
        String sqlLogin = "SELECT* FROM hidrometro WHERE tag_hidrometro like? ";
        try {
            ConexaoDAO con = ConexaoDAO.getInstance();
            stmt = con.connect.prepareStatement(sqlLogin);
            stmt.setString(1, "%" + termo + "%");
            ResultSet rs = stmt.executeQuery();

            ConsumidorDAO consDao = new ConsumidorDAO();
            EnderecoDAO endeDao = new EnderecoDAO();
            
            while (rs.next()) {

                Hidrometro obj = new Hidrometro();
                obj.setIdHidrometro(rs.getInt("id_hidrometro"));
                obj.setTagHidrometro(rs.getInt("tag_hidrometro"));
                obj.setLeituraInstalacao(rs.getDouble("leitura_instalacao"));
                obj.setSituacao(rs.getBoolean("situacao"));               
                obj.setConsumidor(consDao.buscaPorId(rs.getInt("id_consumidor")));
                obj.setEndereco(endeDao.buscaPorId(rs.getInt("id_endereco")));
                lista.add(obj);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            lista = null;
        }
        return lista;
    }
    
    public  Hidrometro buscaPorTag (int tag){
        String sqlListar = "SELECT * FROM hidrometro WHERE tag_hidrometro = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, tag);
            ResultSet rs = stmt.executeQuery();

            ConsumidorDAO consDao = new ConsumidorDAO();
            EnderecoDAO endeDao = new EnderecoDAO();
            
            while (rs.next()) {

                Hidrometro obj = new Hidrometro();
                obj.setIdHidrometro(rs.getInt("id_hidrometro"));
                obj.setTagHidrometro(rs.getInt("tag_hidrometro"));
                obj.setLeituraInstalacao(rs.getDouble("leitura_instalacao"));
                obj.setSituacao(rs.getBoolean("situacao"));               
                obj.setConsumidor(consDao.buscaPorId(rs.getInt("id_consumidor")));
                obj.setEndereco(endeDao.buscaPorId(rs.getInt("id_endereco")));
                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Hidrometro buscaPorId(int id) {
        String sqlListar = "SELECT * FROM hidrometro WHERE id_hidrometro = ?";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            ConsumidorDAO consDao = new ConsumidorDAO();
            EnderecoDAO endeDao = new EnderecoDAO();
            
            while (rs.next()) {

                Hidrometro obj = new Hidrometro();
                obj.setIdHidrometro(rs.getInt("id_hidrometro"));
                obj.setTagHidrometro(rs.getInt("tag_hidrometro"));
                obj.setLeituraInstalacao(rs.getDouble("leitura_instalacao"));
                obj.setSituacao(rs.getBoolean("situacao"));               
                obj.setConsumidor(consDao.buscaPorId(rs.getInt("id_consumidor")));
                obj.setEndereco(endeDao.buscaPorId(rs.getInt("id_endereco")));
                return obj;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
        public List<Hidrometro> listar() {
        List<Hidrometro> lista = new ArrayList<Hidrometro>();
        String sqlListar = "SELECT * FROM hidrometro ";

        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();

            ConsumidorDAO consDao = new ConsumidorDAO();
            EnderecoDAO endeDao = new EnderecoDAO();
            
            while (rs.next()) {

                Hidrometro obj = new Hidrometro();
                obj.setIdHidrometro(rs.getInt("id_hidrometro"));
                obj.setTagHidrometro(rs.getInt("tag_hidrometro"));
                obj.setLeituraInstalacao(rs.getDouble("leitura_instalacao"));
                obj.setSituacao(rs.getBoolean("situacao"));               
                obj.setConsumidor(consDao.buscaPorId(rs.getInt("id_consumidor")));
                obj.setEndereco(endeDao.buscaPorId(rs.getInt("id_endereco")));
                lista.add(obj);

            }
        } catch (SQLException add) {
            lista = null;
        }
        return lista;
    }
    
    public Boolean atualizar(Hidrometro obj) {
        try {
            String sqlAtualiza = "UPDATE hidrometro SET tag_hidrometro=?, leitura_instalacao=?,"
                    + "situacao=?, id_consumidor=?, id_endereco=?  WHERE id_hidrometro=?";
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlAtualiza);
            stmt.setInt(1, obj.getTagHidrometro());
            stmt.setDouble(2, obj.getLeituraInstalacao());
            stmt.setBoolean(3, obj.isSituacao());
            stmt.setInt(4, obj.getIdConsumidor());
            stmt.setInt(5,obj.getIdEndereco());
            stmt.setInt(6, obj.getIdHidrometro());
            
            int retornoUpdate = stmt.executeUpdate();
                if (retornoUpdate>0 ){
                return true;
                }else{
                    return false;
                }

        } catch (SQLException add) {
            add.printStackTrace();
        }
        return false;
    }   
    
    public Boolean deletar(Hidrometro obj) {
        String sqlDel = "DELETE FROM hidrometro WHERE id_hidrometro=? ";
        try {
            ConexaoDAO conDao = ConexaoDAO.getInstance();
            stmt = conDao.connect.prepareStatement(sqlDel);
            stmt.setInt(1, obj.getIdHidrometro());
            int retornoDelet = stmt.executeUpdate();
            
            if (retornoDelet > 0) {
            System.out.println("hidrometro deletado com sucesso");
            return true;
    }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }    
    
}