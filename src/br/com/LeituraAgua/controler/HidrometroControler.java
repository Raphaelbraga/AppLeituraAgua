/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.HidrometroDAO;
import br.com.model.Hidrometro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HidrometroControler {
    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    
    public Hidrometro cadastraNovo(Hidrometro obj){
        HidrometroDAO hidrometro = new HidrometroDAO();
        Hidrometro hidrometroExist = hidrometro.buscaPorTag(obj.getTagHidrometro());
        
        
        if (hidrometroExist != null) {
            setMensagem("Erro - Hidrometro ja existe!");
        } else {
            Hidrometro novoHidrometro = hidrometro.cadastrar(obj);
            setMensagem("Hidrometro cadastrado com sucesso!");
            return novoHidrometro;
        }
            return hidrometroExist;            
    }
    
    public List<Hidrometro> consultarListaPorTermo(int termo) {
        HidrometroDAO consulta = new HidrometroDAO();
        List<Hidrometro> hidroLista = consulta.listarPorTermo(termo);

        if (hidroLista == null) {
            setMensagem("Erro - lista de usuario não existe");
        } else {
            return hidroLista;
        }
        return null;
    }
    
    public List<Hidrometro> consultarLista() {
        HidrometroDAO consulta = new HidrometroDAO();
        List<Hidrometro> hidrometroLista = consulta.listar();

        if (hidrometroLista == null) {
            setMensagem("Erro - lista de Hidrometro não existe");
        } else {
            return hidrometroLista;
        }
        return null;
    }
    
    public Hidrometro pesquisaPorId(int id) {
        HidrometroDAO consulta = new HidrometroDAO();
        Hidrometro hidrometroId = consulta.buscaPorId(id);

        if (hidrometroId == null) {
            setMensagem("Erro - Hidrometro ja existe!");
        } else {
            return hidrometroId;
        }
            return null;
    }
    
    public Hidrometro pesquisaPorTag(int tag) {
        HidrometroDAO consulta = new HidrometroDAO();
        Hidrometro hidrometroId = consulta.buscaPorTag(tag);

        if (hidrometroId == null) {
            setMensagem("Erro - Hidrometro ja existe!");
        } else {
            return hidrometroId;
        }
            return null;
    }


    public Boolean atualizar(Hidrometro obj) {
        HidrometroDAO atualiza = new HidrometroDAO();
        Hidrometro idHidrometro = atualiza.buscaPorId(obj.getIdHidrometro());
        
        if (idHidrometro == null) {
            setMensagem("Erro - Hidrometro não existe!");
            return false;
        } else {
            
            return atualiza.atualizar(obj);
        }
    } 
    
    public Boolean deletar(Hidrometro obj) {
       HidrometroDAO deleta = new HidrometroDAO();
        Hidrometro idHidrometro = deleta.buscaPorId(obj.getIdHidrometro());

        if (idHidrometro == null) {
            setMensagem("Erro -Hidrometro não existe!");
        } else {
            Boolean hidrometroDeletado = deleta.deletar(obj);
            if(!hidrometroDeletado){
                setMensagem("falha ao deletar Hidrometro, contate suporte");
            }
            setMensagem("hidrometro deletado com sucesso");
            return true;
        }
        return false;
    }
       
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }    
}
