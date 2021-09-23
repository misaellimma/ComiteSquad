package com.treinamento.comitesquad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.comitesquad.entities.Confederacao;
import com.treinamento.comitesquad.repositories.ComiteRepository;
import com.treinamento.comitesquad.repositories.ConfederacaoRepository;

@RestController
@RequestMapping("confederacao")
public class ConfederacaoController {
	@Autowired
	private ConfederacaoRepository confederacaoRepository;
	@Autowired
	private ComiteRepository comiteRepository;
	
	@GetMapping
	public List<Confederacao> listarConfedercaos(){
		return confederacaoRepository.findAll();
	}
}
