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
import com.treinamento.comitesquad.biz.ModalidadeBiz;
import com.treinamento.comitesquad.entities.Modalidade;
import com.treinamento.comitesquad.repositories.ConfederacaoRepository;
import com.treinamento.comitesquad.repositories.ModalidadeRepository;

@RestController
@RequestMapping("modalidade")
public class ModalidadeController {
	@Autowired
	private ModalidadeRepository modalidadeRepository;
	@Autowired
	private ConfederacaoRepository confederacaoRepository;
	
	@GetMapping("listar")
	public List<Modalidade> listarModalidades(){
		return modalidadeRepository.findAll();
	}
	
	@PostMapping("incluir")
	public Mensagem createModalidade(@Validated @RequestBody Modalidade modalidade) {
		ModalidadeBiz modalidadeBiz = new ModalidadeBiz(confederacaoRepository);
		try {
			if(modalidadeBiz.validar(modalidade)) {				
				modalidadeRepository.save(modalidade);
				modalidadeRepository.flush();		
				modalidadeBiz.getMensagem().mensagem.add("Modalidade adicionado");
				modalidadeBiz.getMensagem().mensagem.add("id: " + modalidade.getId());
			}
		} catch (Exception e)
		{
			modalidadeBiz.getMensagem().mensagem.add("Erro ao Incluir: " + e.getMessage());
		}
		
		return modalidadeBiz.getMensagem();
	}
}
