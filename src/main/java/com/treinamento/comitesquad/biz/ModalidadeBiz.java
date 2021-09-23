package com.treinamento.comitesquad.biz;
import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Modalidade;
import com.treinamento.comitesquad.repositories.ConfederacaoRepository;
import com.treinamento.comitesquad.repositories.ModalidadeRepository;

public class ModalidadeBiz {

    private Mensagem mensagem;

    private ModalidadeRepository modalidadeRepository;
    private ConfederacaoRepository confederacaoRepository;

    public ModalidadeBiz(Mensagem mensagem, ModalidadeRepository modalidadeRepository, ConfederacaoRepository confederacaoRepository) {
        this.mensagem = mensagem;
        this.modalidadeRepository = modalidadeRepository;
        this.confederacaoRepository = confederacaoRepository;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Boolean validar(Modalidade modalidade){

        Boolean valid = true;

        if(modalidade.getDescricao() == null || modalidade.getDescricao().isEmpty()) {
            getMensagem().mensagem.add("A descrição da modalidade não pode estar vazia!");
            valid = false;
        } else if(modalidade.getDescricao().length() > 255) {
            getMensagem().mensagem.add("A descrição não pode conter mais que 255 caracteres!");
            valid = false;
        } else if(!confederacaoRepository.findById(modalidade.getId_confederacao()).isEmpty()) {
            getMensagem().mensagem.add("Confederação inexistente!");
            valid = false;
        }

        return valid;

    }


}
