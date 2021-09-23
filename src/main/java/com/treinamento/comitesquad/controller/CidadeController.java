package com.treinamento.comitesquad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.comitesquad.entities.Cidade;
import com.treinamento.comitesquad.repositories.CidadeRepository;

	
@RestController
@RequestMapping("cidade")
public class CidadeController {

	@Autowired	
	private CidadeRepository cidadeRepository;

	@GetMapping("listar")
	public List<Cidade> listar(){
		List<Cidade> lista = cidadeRepository.findAll();
		return lista;
	}
	 
}
