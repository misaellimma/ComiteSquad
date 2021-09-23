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
import com.treinamento.comitesquad.biz.CidadeBiz;
import com.treinamento.comitesquad.entities.Cidade;
import com.treinamento.comitesquad.repositories.CidadeRepository;
import com.treinamento.comitesquad.repositories.ProvinciaRepository;

	
@RestController
@RequestMapping("cidade")
public class CidadeController {

	@Autowired	
	private CidadeRepository cidadeRepository;
	
	@Autowired 
	private ProvinciaRepository provinciaRepository;

	@GetMapping("listar")
	public List<Cidade> listar(){
		List<Cidade> lista = cidadeRepository.findAll();
		return lista;
	}
	
	@PostMapping("incluir")
	public Mensagem incluirCidade(@Validated @RequestBody Cidade cidade) {
		
		CidadeBiz cidadeBiz = new CidadeBiz(this.provinciaRepository);
		try {
			
			if (cidadeBiz.validar(cidade)) {
				cidadeRepository.save(cidade);
				cidadeRepository.flush();
				cidadeBiz.getMsg().getMensagem().add("OK");
			}
			
		} catch (Exception e) {
			cidadeBiz.getMsg().getMensagem().add("Erro ao Incluir:" + e.getMessage());
		}
		
		return cidadeBiz.getMsg();
	}
	 
}
