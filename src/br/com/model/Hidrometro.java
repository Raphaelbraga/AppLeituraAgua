
package br.com.model;

/**
 *
 * @author Cleumar
 */
public class Hidrometro {
    private int idHidrometro;
    private int tagHidrometro;
    private double leituraInstalacao;
    private boolean situacao;
    private Consumidor consumidor;
    private Endereco endereco;

    public Hidrometro() {
        consumidor = new Consumidor();
        endereco = new Endereco();
    }

    public Hidrometro(int idHidrometro, int tagHidrometro, double leituraInstalacao, boolean situacao, Consumidor consumidor, Endereco endereco) {
        this.idHidrometro = idHidrometro;
        this.tagHidrometro = tagHidrometro;
        this.leituraInstalacao = leituraInstalacao;
        this.situacao = situacao;
        this.consumidor = consumidor;
        this.endereco = endereco;
    }
    
    //--------DELEGATE METHODS-----------------

    public int getIdConsumidor() {
        return consumidor.getIdConsumidor();
    }

    public void setIdConsumidor(int idConsumidor) {
        consumidor.setIdConsumidor(idConsumidor);
    }
    
    

    public String getNome() {
        return consumidor.getNome();
    }

    public String getCpf() {
        return consumidor.getCpf();
    }

    public int getIdEndereco() {
        return endereco.getIdEndereco();
    }

    public void setIdEndereco(int idEndereco) {
        endereco.setIdEndereco(idEndereco);
    }
    
    

    public String getRua() {
        return endereco.getRua();
    }

    public int getNumero() {
        return endereco.getNumero();
    }

    public String getComplemento() {
        return endereco.getComplemento();
    }

    public String getDistrito() {
        return endereco.getDistrito();
    }

    public String getBairro() {
        return endereco.getBairro();
    }

    public String getCidade() {
        return endereco.getCidade();
    }
    

    public int getIdHidrometro() {
        return idHidrometro;
    }

    public void setIdHidrometro(int idHidrometro) {
        this.idHidrometro = idHidrometro;
    }

    public int getTagHidrometro() {
        return tagHidrometro;
    }

    public void setTagHidrometro(int tagHidrometro) {
        this.tagHidrometro = tagHidrometro;
    }

    public double getLeituraInstalacao() {
        return leituraInstalacao;
    }

    public void setLeituraInstalacao(double leituraInstalacao) {
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

    @Override
    public String toString() {
        return "Hidrometro{" + "idHidrometro=" + idHidrometro + ", tagHidrometro=" + tagHidrometro + ", leituraInstalacao=" + leituraInstalacao + ", situacao=" + situacao + ", consumidor=" + consumidor + ", endereco=" + endereco + '}';
    }
    
       
}
