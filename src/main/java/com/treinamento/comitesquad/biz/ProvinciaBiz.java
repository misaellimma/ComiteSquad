package com.treinamento.comitesquad.biz;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Provincia;
import com.treinamento.comitesquad.repositories.ProvinciaRepository;

public class ProvinciaBiz {
	
	private ProvinciaRepository provinciaRepository;
	
	private Mensagem msg;
	
	public ProvinciaBiz(ProvinciaRepository provinciaRepository) {
		this.msg = new Mensagem();
		this.provinciaRepository = provinciaRepository;
	}
	
	public Boolean validar(Provincia provincia) {
		Boolean valido = true;
		
		if(provincia.getNome() == null || provincia.getNome().isEmpty()) {
			msg.mensagem.add("O nome nao pode estar vazio");
			valido = false;
		} else if(provincia.getNome().length() > 255 ) {
		msg.mensagem.add("Nao pode conter mais que 255 letras");
			valido = false;
		}
		
		return valido;
	
	}

	public ProvinciaRepository getProvinciaRepository() {
		return provinciaRepository;
	}

	public void setProvinciaRepository(ProvinciaRepository provinciaRepository) {
		this.provinciaRepository = provinciaRepository;
	}

	public Mensagem getMsg() {
		return msg;
	}

	public void setMsg(Mensagem msg) {
		this.msg = msg;
	}
	
	
}



