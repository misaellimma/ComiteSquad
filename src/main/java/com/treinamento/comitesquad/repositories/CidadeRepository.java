package com.treinamento.comitesquad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.comitesquad.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
