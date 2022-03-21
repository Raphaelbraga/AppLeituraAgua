/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradb;

/**
 *
 * @author Cleumar
 */
public class Hidrometro {
    private int idHidrometro;
    private int leituraInstalacao;
    private boolean situacao;
    private Consumidor consumidor;
    private Endereco endereco;

    public Hidrometro(int idHidrometro, int leituraInstalacao, boolean situacao, Consumidor consumidor, Endereco endereco) {
        this.idHidrometro = idHidrometro;
        this.leituraInstalacao = leituraInstalacao;
        this.situacao = situacao;
        this.consumidor = consumidor;
        this.endereco = endereco;
    }
    
    

    public int getIdHidrometro() {
        return idHidrometro;
    }

    public void setIdHidrometro(int idHidrometro) {
        this.idHidrometro = idHidrometro;
    }

    public int getLeituraInstalacao() {
        return leituraInstalacao;
    }

    public void setLeituraInstalacao(int leituraInstalacao) {
        this.leituraInstalacao = leituraInstalacao;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
}