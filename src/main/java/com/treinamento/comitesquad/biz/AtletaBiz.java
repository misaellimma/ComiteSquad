package com.treinamento.comitesquad.biz;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Atleta;
import com.treinamento.comitesquad.repositories.ModalidadeRepository;

public class AtletaBiz {
    private Mensagem mensagens = new Mensagem();
    private ModalidadeRepository modalidadeRepositorio;
    public AtletaBiz(ModalidadeRepository modalidadeRepo){
        this.modalidadeRepositorio = modalidadeRepo;
    }
    public boolean verificaAtleta(Atleta atleta){
        boolean valido= true;
        if(atleta.getId_modalidade()==null){
            mensagens.mensagem.add("O id da modalidade informado não deve ser nulo");
            valido=false;
        }else if(modalidadeRepositorio.findById(atleta.getId_modalidade()).isEmpty()){
            mensagens.mensagem.add("Nenhuma modalidade foi encontrada com o id informado");
            valido=false;
        }
        if(atleta.getNome().isBlank() || atleta.getNome() == null){
            mensagens.mensagem.add("O nome informado não deve ser nulo");
            valido=false;
        }else if(atleta.getNome().length()>255){
            mensagens.mensagem.add("O nome informado não deve possuir mais que 255 caracteres");
            valido=false;
        }
        return valido;
    }

    public Mensagem getMensagens() {
        return mensagens;
    }

    public void setMensagens(Mensagem mensagens) {
        this.mensagens = mensagens;
    }
}
