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
import com.treinamento.comitesquad.biz.ComiteBiz;
import com.treinamento.comitesquad.biz.ComiteBiz;
import com.treinamento.comitesquad.entities.Comite;
import com.treinamento.comitesquad.entities.Comite;
import com.treinamento.comitesquad.repositories.ComiteRepository;

@RestController
@RequestMapping("comite")
public class ComiteController {
	
	@Autowired
	private ComiteRepository comiteRepository;
	
	@GetMapping("listar")
	public List<Comite> listarComite(){
		List<Comite> lista = comiteRepository.findAll();
		return lista;
	}
	
	@PostMapping("incluir")
	public Mensagem incluirComite(@Validated @RequestBody Comite comite) {
		
		ComiteBiz comiteBiz = new ComiteBiz(this.comiteRepository);
		try {
			
			if (comiteBiz.validar(comite)) {
				comiteRepository.save(comite);
				comiteRepository.flush();
				comiteBiz.getMsg().getMensagem().add("OK");
			}
			
		} catch (Exception e) {
			comiteBiz.getMsg().getMensagem().add("Erro ao Incluir:" + e.getMessage());
		}
		
		return comiteBiz.getMsg();
	}
	 
	  
}