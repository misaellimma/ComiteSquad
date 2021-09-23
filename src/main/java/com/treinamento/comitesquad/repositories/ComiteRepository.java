package com.treinamento.comitesquad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.comitesquad.entities.Comite;

@Repository
public interface ComiteRepository extends JpaRepository<Comite, Integer> {

}
