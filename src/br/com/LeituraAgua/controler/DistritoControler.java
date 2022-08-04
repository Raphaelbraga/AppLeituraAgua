/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.DistritoDAO;
import br.com.model.Distrito;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Cleumar
 */
public class DistritoControler {
 PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    
    public Distrito cadastraNovo(Distrito obj){
        DistritoDAO solicita = new DistritoDAO();
        Distrito distritoexist = solicita.listarPorNome(obj.getNomeDistrito());

        if (distritoexist != null) {
            setMensagem("Erro - Distrito já existe!");
        } else {
            Distrito distrito = solicita.cadastrar(obj);
            setMensagem("sucesso - Distrito cadastrado com sucesso");
            return distrito;
        }
        return null;
    }
    
    public List<Distrito> consultarLista() {
        DistritoDAO consulta = new DistritoDAO();
        List<Distrito> distritoLista = consulta.listar();

        if (distritoLista == null) {
            setMensagem("Erro - lista de distrito não existe");
        }else {
            return distritoLista;
        }
     return null;
    }
    
    public Distrito pesquisarPorId(int id) {
        DistritoDAO consulta = new DistritoDAO();
        Distrito distritoId = consulta.listarPorId(id);

        if (distritoId == null) {
            setMensagem("Erro - Distrito não existe!");
        } else {
            return distritoId;
        }
        return null;
    }

    public Distrito pesquisaPorNome(String nome){
        DistritoDAO consulta = new DistritoDAO();
        Distrito distritonome = consulta.listarPorNome(nome);
        if (distritonome == null) {
            setMensagem("Erro - Distrito não Existe!");
        } else {
            return distritonome;
        }
        return null;
    }
    public List<Distrito> consultarListaPorTermo(String termo) {
        DistritoDAO consulta = new DistritoDAO();
        List<Distrito> distritoLista = consulta.listarPorTermo(termo);

        if (distritoLista == null) {
            setMensagem("Erro - lista de distrito não existe");
        } else {
            return distritoLista;
        }
        return null;
    }

    public Distrito atualizar(Distrito obj) {
        DistritoDAO atualiza = new DistritoDAO();
        Distrito idDistrito = atualiza.listarPorId(obj.getIdDistrito());
        
        if (idDistrito == null) {
            setMensagem("Erro - Distrito não existe!");
        } else {
            Distrito DistritoAtual = atualiza.atualizar(obj);
            return DistritoAtual;
        }
        return null;
    } 
    
    public Boolean deletar(Distrito obj) {
        DistritoDAO deleta = new DistritoDAO();
        Distrito idDistrito = deleta.listarPorId(obj.getIdDistrito());

        if (idDistrito == null) {
            setMensagem("Erro -Distrito não existe!");
        } else {
            Boolean distritoDeletado = deleta.deletar(obj);
            if(!distritoDeletado){
                setMensagem("falha ao deletar Distrito, contate suporte");
            }
            return distritoDeletado;
        }
        return false;
    }
       
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }    

    public Distrito pesquisaPorNome(JTextField NomeDistrito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
