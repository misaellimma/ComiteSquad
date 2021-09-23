package com.treinamento.comitesquad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_confederacao")
public class Confedercao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@NotNull
	@Column(name = "nome")
	private String nome;
	@NotNull
	@Column(name = "id_comite")
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
