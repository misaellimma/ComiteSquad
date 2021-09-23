package com.treinamento.comitesquad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	    public String incluirComite(@RequestBody Comite comite) {
	        
	        try{
	            comiteRepository.save(comite);
	            comiteRepository.flush();
	            return comite.toString();
	        }catch(Exception e) {
	            return e.getMessage();
	        }
	        
	    }
	  
}