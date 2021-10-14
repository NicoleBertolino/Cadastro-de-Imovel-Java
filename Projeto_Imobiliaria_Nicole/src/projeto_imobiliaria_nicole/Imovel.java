/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_imobiliaria_nicole;

/**
 *
 * @author Nicole Bertolino
 */

public class Imovel {
    private int codigo;
    private String endereco;
    private String descricao;
    private int numquarto;
    private double metros;
    private int numvaga;
    private double valor;
    
    public Imovel(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumquarto() {
        return numquarto;
    }

    public void setNumquarto(int numquarto) {
        this.numquarto = numquarto;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    public int getNumvaga() {
        return numvaga;
    }

    public void setNumvaga(int numvaga) {
        this.numvaga = numvaga;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    


}