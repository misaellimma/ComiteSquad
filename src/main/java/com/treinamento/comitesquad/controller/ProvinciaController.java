package com.treinamento.comitesquad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.biz.ProvinciaBiz;
import com.treinamento.comitesquad.entities.Provincia;
import com.treinamento.comitesquad.repositories.ProvinciaRepository;

@RestController
@RequestMapping("provincia")
public class ProvinciaController {
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	@CrossOrigin
	@GetMapping("listar")
	public List<Provincia> listarProvincia(){
		List<Provincia> lista = provinciaRepository.findAll();
		return lista;
	}
	
	@CrossOrigin
	@PostMapping("incluir")
	public Mensagem incluirProvincia(@Validated @RequestBody Provincia provincia) {
		
		ProvinciaBiz provinciaBiz = new ProvinciaBiz(this.provinciaRepository);
		try {
			
			if (provinciaBiz.validar(provincia)) {
				provinciaRepository.save(provincia);
				provinciaRepository.flush();
				provinciaBiz.getMsg().getMensagem().add("OK");
			}
			
		} catch (Exception e) {
			provinciaBiz.getMsg().getMensagem().add("Erro ao Incluir:" + e.getMessage());
		}
		
		return provinciaBiz.getMsg();
	}
}