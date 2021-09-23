package com.treinamento.comitesquad.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_setor")
public class Setor {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "id_comite", nullable = false)
    private Integer id_comite;

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

    public Integer getId_comite() {
        return id_comite;
    }

    public void setId_comite(Integer id_comite) {
        this.id_comite = id_comite;
    }
}
