/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LeituraAgua.controler;

import br.com.LeituraAgua.DAO.ConsumidorDAO;
import br.com.model.Consumidor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Cleumar
 */
public class ConsumidorControler {
    PreparedStatement pst = null;
    ResultSet result = null;
    public String mensagem;

    
    public Consumidor cadastraNovo(Consumidor obj){
        ConsumidorDAO solicita = new ConsumidorDAO();
        Consumidor consumidorExist = solicita.buscaPorCpf(obj.getCpf());

        if (consumidorExist != null) {
            setMensagem("Erro - Consumidor ja existe!");
            return consumidorExist;
        } else {
            Consumidor novoConsumidor = solicita.cadastrar(obj);
            return novoConsumidor;
        }
    }
    
    public List<Consumidor> consultarLista() {
        ConsumidorDAO consulta = new ConsumidorDAO();
        List<Consumidor> consumidorLista = consulta.listar();

        if (consumidorLista == null) {
            setMensagem("Erro - lista de consumidor não existe");
        } else {
            return consumidorLista;
        }
        return null;
    }


    public Consumidor atualizar(Consumidor obj) {
        ConsumidorDAO atualiza = new ConsumidorDAO();
        Consumidor idConsumidor = atualiza.buscaPorId(obj.getIdConsumidor());
        
        if (idConsumidor != null) {
            setMensagem("Erro - Consumidor não existe!");
        } else {
            Consumidor ConsumidorAtual = atualiza.atualizar(obj);
            return ConsumidorAtual;
        }
        return null;
    } 
    
    public Consumidor deletar(Consumidor obj) {
        ConsumidorDAO deleta = new ConsumidorDAO();
        Consumidor idConsumidor = deleta.buscaPorId(obj.getIdConsumidor());

        if (idConsumidor != null) {
            setMensagem("Erro -Consumidor não existe!");
        } else {
            Boolean consumidorDeletado = deleta.deletar(obj);
            if(!consumidorDeletado){
                setMensagem("falha ao deletar Consumidor, contate suporte");
            }
        }
        return null;
    }
       
    public Consumidor consultarPorCpf (String cpf){
       ConsumidorDAO consultar = new ConsumidorDAO();
        Consumidor novoConsumidor = consultar.buscaPorCpf(cpf);

        if (novoConsumidor == null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
            return novoConsumidor;
        }
        return null;
    }
    
    public Consumidor consultarPorId (int id){
       ConsumidorDAO consultar = new ConsumidorDAO();
        Consumidor novoConsumidor = consultar.buscaPorId(id);

        if (novoConsumidor == null) {
            setMensagem("Erro - Usuário não existe!");
        } else {
            return novoConsumidor;
        }
        return null;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }    
}
