package com.treinamento.comitesquad.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="descricao")
    private String descricao;

    @Column(name="data")
    private Date data;

    @Column(name="id_cidade")
    private Integer id_cidade;

    @Column(name="id_modalidade")
    private Integer id_modalidade;

    public Evento() {

    }

    public Evento(Integer id, String descricao, Date data, Integer id_cidade, Integer id_modalidade) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.id_cidade = id_cidade;
        this.id_modalidade = id_modalidade;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(Integer id_cidade) {
        this.id_cidade = id_cidade;
    }

    public Integer getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(Integer id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

}
