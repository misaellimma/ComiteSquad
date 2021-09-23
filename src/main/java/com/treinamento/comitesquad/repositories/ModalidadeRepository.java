package com.treinamento.comitesquad.repositories;

import com.treinamento.comitesquad.entities.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer> {

}
