package com.treinamento.comitesquad.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_modalidade")
public class Modalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="descricao")
    private String descricao;

    @Column(name="id_confederacao")
    private Integer id_confederacao;

    public Modalidade() {

    }

    public Modalidade(Integer id, String descricao, Integer id_confederacao) {
        this.id = id;
        this.descricao = descricao;
        this.id_confederacao = id_confederacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId_confederacao() {
        return id_confederacao;
    }

    public void setId_confederacao(Integer id_confederacao) {
        this.id_confederacao = id_confederacao;
    }

}
