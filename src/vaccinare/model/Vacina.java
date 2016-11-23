/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.model;

import java.util.Date;

/**
 *
 * @author mauricio.rosito
 */
public class Vacina {
    private int id;
    private int lote;
    private String nome;
    private Date dataValidade;
    private String fornecedor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Vacina() {
    }

    public Vacina(int id, int lote, String nome, Date dataValidade, String fornecedor) {
        this.id = id;
        this.lote = lote;
        this.nome = nome;
        this.dataValidade = dataValidade;
        this.fornecedor = fornecedor;
    }
    
    
}
