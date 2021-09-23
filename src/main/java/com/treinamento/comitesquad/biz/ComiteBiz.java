package com.treinamento.comitesquad.biz;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Comite;
import com.treinamento.comitesquad.repositories.ComiteRepository;

public class ComiteBiz {

	private ComiteRepository comiteRepository;

	private Mensagem msg;

	public ComiteBiz(ComiteRepository comiteRepository) {
		this.msg = new Mensagem();
		this.comiteRepository = comiteRepository;
	}

	public Boolean validar(Comite comite) {
		Boolean valido = true;

		if (comite.getNome() == null || comite.getNome().isEmpty()) {
			msg.mensagem.add("O nome nao pode estar vazio");
			valido = false;
		} else if (comite.getNome().length() > 255) {
			msg.mensagem.add("Nao pode conter mais que 255 letras");
			valido = false;
		}

		return valido;

	}

	public ComiteRepository getComiteRepository() {
		return comiteRepository;
	}

	public void setComiteRepository(ComiteRepository comiteRepository) {
		this.comiteRepository = comiteRepository;
	}

	public Mensagem getMsg() {
		return msg;
	}

	public void setMsg(Mensagem msg) {
		this.msg = msg;
	}

}
