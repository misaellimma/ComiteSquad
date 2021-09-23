package com.treinamento.comitesquad.biz;
import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Modalidade;
import com.treinamento.comitesquad.repositories.ConfederacaoRepository;

public class ModalidadeBiz {

    private Mensagem mensagem;

    private ConfederacaoRepository confederacaoRepository;

    public ModalidadeBiz(ConfederacaoRepository confederacaoRepository) {
        this.mensagem = new Mensagem();
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

        try {
            Integer intValue = Integer.parseInt(modalidade.getId_confederacao);
        } catch (NumberFormatException e) {
            getMensagem().mensagem.add("O valor inserido não é um número");
            valid = false;
        }

        if(modalidade.getDescricao() == null || modalidade.getDescricao().isEmpty()) {
            getMensagem().mensagem.add("A descrição da modalidade não pode estar vazia!");
            valid = false;
        } else if(modalidade.getDescricao().length() > 255) {
            getMensagem().mensagem.add("A descrição não pode conter mais que 255 caracteres!");
            valid = false;
        } else if(confederacaoRepository.findById(modalidade.getId_confederacao()).isEmpty()) {
            getMensagem().mensagem.add("Confederação inexistente!");
            valid = false;
        } else if(modalidade.getId_confederacao() == null) {
            getMensagem().mensagem.add("Confederação não pode ser nulo!");
            valid = false;
        } else if()

        return valid;

    }


}
