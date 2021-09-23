package com.treinamento.comitesquad.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table( name = "tb_atleta")
public class Atleta {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "id_modalidade", nullable = false)
    private Integer id_modalidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(Integer id_modalidade) {
        this.id_modalidade = id_modalidade;
    }
}
