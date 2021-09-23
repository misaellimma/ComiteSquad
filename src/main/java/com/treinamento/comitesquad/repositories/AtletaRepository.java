package com.treinamento.comitesquad.repositories;

import com.treinamento.comitesquad.entities.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, Integer> {

}
