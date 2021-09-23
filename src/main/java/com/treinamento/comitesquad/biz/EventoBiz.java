package com.treinamento.comitesquad.biz;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Evento;
import com.treinamento.comitesquad.repositories.CidadeRepository;
import com.treinamento.comitesquad.repositories.EventoRepository;
import com.treinamento.comitesquad.repositories.ModalidadeRepository;

public class EventoBiz {

    private Mensagem mensagem;

    
    private ModalidadeRepository modalidadeRepository;
    private CidadeRepository cidadeRepository;

    public EventoBiz(EventoRepository eventoRepository, ModalidadeRepository modalidadeRepository, CidadeRepository cidadeRepository) {      
        this.modalidadeRepository = modalidadeRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Boolean validar(Evento evento){

        Boolean valid = true;

        if(evento.getDescricao() == null || evento.getDescricao().isEmpty()) {
            getMensagem().mensagem.add("A descrição do evento não pode estar vazia!");
            valid = false;
        } else if(evento.getDescricao().length() > 255) {
            getMensagem().mensagem.add("A descrição não pode conter mais que 255 caracteres!");
            valid = false;
        } else if(!modalidadeRepository.findById(evento.getId_modalidade()).isEmpty()) {
            getMensagem().mensagem.add("Modalidade inexistente!");
            valid = false;
        } else if(!cidadeRepository.findById(evento.getId_cidade()).isEmpty()) {
            getMensagem().mensagem.add("Cidade inexistente!");
            valid = false;
        }

        return valid;

    }


}
