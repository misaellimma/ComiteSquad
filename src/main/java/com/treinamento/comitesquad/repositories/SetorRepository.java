package com.treinamento.comitesquad.repositories;

import com.treinamento.comitesquad.entities.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

}
