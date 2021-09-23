package com.treinamento.comitesquad.biz;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Setor;
import com.treinamento.comitesquad.repositories.ComiteRepository;

public class SetorBiz {
    private Mensagem mensagens = new Mensagem();
    private ComiteRepository comiteRepositorio;
    public SetorBiz(ComiteRepository comiteRepo){
        this.comiteRepositorio = comiteRepo;
    }
    public boolean verificaSetor(Setor setor){
        boolean valido= true;
        if(setor.getId_comite()==null){
            mensagens.mensagem.add("O id da comite informado não deve ser nulo");
            valido=false;
        }else if(comiteRepositorio.findById(setor.getId_comite()).isEmpty()){
            mensagens.mensagem.add("Nenhuma comite foi encontrada com o id informado");
            valido=false;
        }
        if(setor.getNome().isBlank() || setor.getNome() == null){
            mensagens.mensagem.add("O nome informado não deve ser nulo");
            valido=false;
        }else if(setor.getNome().length()>255){
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
