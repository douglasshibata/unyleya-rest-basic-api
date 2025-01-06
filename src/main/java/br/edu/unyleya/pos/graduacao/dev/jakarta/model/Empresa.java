package br.edu.unyleya.pos.graduacao.dev.jakarta.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Empresa extends BaseEntity implements Serializable {

    private String nome;

    @OneToOne(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
