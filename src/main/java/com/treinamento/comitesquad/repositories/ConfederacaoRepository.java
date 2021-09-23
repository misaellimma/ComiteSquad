package com.treinamento.comitesquad.repositories;

import com.treinamento.comitesquad.entities.Confederacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfederacaoRepository extends JpaRepository<Confederacao, Integer> {

}
