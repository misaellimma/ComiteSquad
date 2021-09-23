package com.treinamento.comitesquad.biz;


import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.repositories.ComiteRepository;

public class ComiteBiz {
	
	private ComiteRepository comiteRepository;
	
	private Mensagem msg;
	
	public ComiteBiz(ComiteRepository comiteRepository) {
		this.msg = new Mensagem();
		this.comiteRepository = comiteRepository;
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
