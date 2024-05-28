package Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.model;

import java.io.Serializable;

public class Unidade implements Serializable{
    private Long id;
    private String endereco;
    private String nome;

    public Unidade(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

}
