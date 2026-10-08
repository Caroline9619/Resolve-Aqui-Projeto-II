package br.com.resolveaqui.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orgaos")
public class Orgao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String secretaria;

    @Column(length = 200)
    private String descricao;

    public Orgao() {
    }

    public Orgao(String nome, String secretaria, String descricao) {
        this.nome = nome;
        this.secretaria = secretaria;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}