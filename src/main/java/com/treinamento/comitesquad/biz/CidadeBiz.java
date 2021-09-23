package com.treinamento.comitesquad.biz;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Cidade;
import com.treinamento.comitesquad.repositories.ProvinciaRepository;

public class CidadeBiz {

	private Mensagem msg;
	private ProvinciaRepository provinciaRepository;
	
	public CidadeBiz( ProvinciaRepository provinciaRepository) {
		this.provinciaRepository = provinciaRepository;
		this.msg = new Mensagem();
	}

	public Boolean validar( Cidade cidade) {
		Boolean valido = true;
		
		if (cidade.getNome().isEmpty()) {
			msg.getMensagem().add("O nome não pode ser vazio");
			valido = false;
		}else if(cidade.getNome().length() > 255) {
			msg.getMensagem().add("O nome não pode ser maior que 255 caracteres");
			valido = false;
		}
			
		if (provinciaRepository.findById(cidade.getId_provincia()).isEmpty()) {
			msg.getMensagem().add(("O setor do funcionario não existe"));
			valido = false;
		}
		
		return valido;
	}
	

	public Mensagem getMsg() {
		return msg;
	}

	public void setMsg(Mensagem msg) {
		this.msg = msg;
	}
}
