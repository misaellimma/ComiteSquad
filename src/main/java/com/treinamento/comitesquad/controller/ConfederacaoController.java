package com.treinamento.comitesquad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.biz.ConfederacaoBiz;
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
	
	@GetMapping("listar")
	public List<Confederacao> listarConfedercaos(){
		return confederacaoRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem incluirConfederacao(@Validated @RequestBody Confederacao confederacao) {
		
		ConfederacaoBiz confederacaoBiz = new ConfederacaoBiz(comiteRepository);
		try {
			if (confederacaoBiz.validar(confederacao)) {
				confederacaoRepository.save(confederacao);
				confederacaoRepository.flush();
				confederacaoBiz.getMensagem().mensagem.add("OK");
				confederacaoBiz.getMensagem().mensagem.add("id: " + confederacao.getId());
			}
		} catch (Exception e) {
			confederacaoBiz.getMensagem().mensagem.add("Erro ao Incluir:" + e.getMessage());
		}
		return confederacaoBiz.getMensagem();
	}
}
