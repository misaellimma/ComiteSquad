package com.treinamento.comitesquad.biz;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Confederacao;
import com.treinamento.comitesquad.repositories.ComiteRepository;

public class ConfederacaoBiz {
	private Mensagem mensagem;
	private ComiteRepository comiteRepository;
	
	public ConfederacaoBiz(ComiteRepository comiteRepository) {
		this.comiteRepository = comiteRepository;
		this.mensagem = new Mensagem();
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
	
	public Boolean validar(Confederacao confedercao) {
		Boolean valido = true;
		
		if (confedercao.getNome().isEmpty()) {
			getMensagem().mensagem.add("O nome não pode ser vazio");
			valido = false;
		}
		if (confedercao.getNome().length() > 255) {
			getMensagem().mensagem.add("O nome não pode ser maior que 255 caracteres!");
			valido = false;
		}
		if (confedercao.getId_comite() == null) {
			getMensagem().mensagem.add("O id comitê não deve ser nulo");
			valido = false;
		}else if (comiteRepository.findById(confedercao.getId_comite()).isEmpty()) {
			getMensagem().mensagem.add("Comitê não cadastrado");
			valido = false;
		}
		return valido;
	}
}
