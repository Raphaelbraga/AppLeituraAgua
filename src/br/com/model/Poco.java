/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Cleumar
 */
public class Poco {
    private int idPoco;
    private int unidadeConsumidora;

    public Poco() {
    }

    public Poco(int idPoco, int unidadeConsumidora) {
        this.idPoco = idPoco;
        this.unidadeConsumidora = unidadeConsumidora;
    }

    public int getIdPoco() {
        return idPoco;
    }

    public void setIdPoco(int idPoco) {
        this.idPoco = idPoco;
    }

    public int getUnidadeConsumidora() {
        return unidadeConsumidora;
    }

    public void setUnidadeConsumidora(int unidadeConsumidora) {
        this.unidadeConsumidora = unidadeConsumidora;
    }

    @Override
    public String toString() {
        return "Poco{" + "idPoco=" + idPoco + ", unidadeConsumidora=" + unidadeConsumidora + '}';
    }
    
    
}
