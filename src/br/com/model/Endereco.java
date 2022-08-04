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
public class Endereco {
    private int idEndereco;
    private String rua;
    private int numero;
    private String complemento;
    private String distrito;
    private String bairro;
    private String cidade;

    public Endereco() {
    }

    public Endereco(int idEndereco, String rua, int numero, String complemento, String distrito, String bairro, String cidade) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.distrito = distrito;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", distrito=" + distrito + ", bairro=" + bairro + ", cidade=" + cidade + '}';
    }
       
}
