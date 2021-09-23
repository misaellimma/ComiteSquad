package com.treinamento.comitesquad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.comitesquad.entities.Provincia;
import com.treinamento.comitesquad.repositories.ProvinciaRepository;

@RestController
@RequestMapping("provincia")
public class ProvinciaController {
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	@GetMapping("listar")
	public List<Provincia> listarProvincia(){
		List<Provincia> lista = provinciaRepository.findAll();
		return lista;
	}
	
	  @PostMapping("incluir")
	    public String incluirProvincia(@RequestBody Provincia provincia) {
	        
	        try{
	            provinciaRepository.save(provincia);
	            provinciaRepository.flush();
	            return provincia.toString();
	        }catch(Exception e) {
	            return e.getMessage();
	        }
	        
	    }
}