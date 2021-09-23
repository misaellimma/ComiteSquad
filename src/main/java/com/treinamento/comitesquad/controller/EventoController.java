package com.treinamento.comitesquad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.biz.EventoBiz;
import com.treinamento.comitesquad.entities.Evento;
import com.treinamento.comitesquad.repositories.CidadeRepository;
import com.treinamento.comitesquad.repositories.EventoRepository;
import com.treinamento.comitesquad.repositories.ModalidadeRepository;

@RestController
@RequestMapping("evento")
public class EventoController {
	
	@Autowired	
	private EventoRepository eventoRepository;
	@Autowired
	private CidadeRepository cidadeRepositorio;
	@Autowired
	private ModalidadeRepository modalidadeRepositorio;

	@GetMapping("listar")
	public List<Evento> listar(){
		List<Evento> lista = eventoRepository.findAll();
		return lista;
	}
	
	@PostMapping("incluir")
	public Mensagem incluir(@RequestBody Evento novoEvento) {

		EventoBiz validador = new EventoBiz(eventoRepository, modalidadeRepositorio, cidadeRepositorio);

		try {
			if (validador.validar(novoEvento)) {
				eventoRepository.save(novoEvento);
				eventoRepository.flush();
				validador.getMensagem().mensagem.add("Incluido com sucesso");
			}
		} catch (Exception e) {
			validador.getMensagem().mensagem.add("Erro ao Incluir:" + e.getMessage());
		}

		return validador.getMensagem();
	}
}
