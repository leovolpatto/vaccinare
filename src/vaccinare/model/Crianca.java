/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccinare.model;

/**
 *
 * @author mauricio.rosito
 */
public class Crianca {
    private int id;
    private String nome;
    private int idade;
    private Sexo sexo;
    private boolean partoNatural;
    private String mae;
    private Etnia etnia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean isPartoNatural() {
        return partoNatural;
    }

    public void setPartoNatural(boolean partoNatural) {
        this.partoNatural = partoNatural;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public Etnia getEtnia() {
        return etnia;
    }

    public void setEtnia(Etnia etnia) {
        this.etnia = etnia;
    }

    public Crianca() {
    }

    public Crianca(int id,String nome, int idade, Sexo sexo, boolean partoNatural, String mae, Etnia etnia) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.partoNatural = partoNatural;
        this.mae = mae;
        this.etnia = etnia;
    }
    
     public Crianca(String nome, int idade, Sexo sexo, boolean partoNatural, String mae, Etnia etnia) {

        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.partoNatural = partoNatural;
        this.mae = mae;
        this.etnia = etnia;
    }
    
    
}
