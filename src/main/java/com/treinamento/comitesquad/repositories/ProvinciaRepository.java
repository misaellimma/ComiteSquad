package com.treinamento.comitesquad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.comitesquad.entities.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

}
