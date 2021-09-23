package com.treinamento.comitesquad.controller;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.biz.AtletaBiz;
import com.treinamento.comitesquad.entities.Atleta;
import com.treinamento.comitesquad.repositories.AtletaRepository;
import com.treinamento.comitesquad.repositories.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("atleta")
public class AtletaController {
    @Autowired
    AtletaRepository atletaRepositorio;
    @Autowired
    ModalidadeRepository modalidadeRepositorio;

    @CrossOrigin
    @GetMapping("listar")
    public List<Atleta> listar(){
        return atletaRepositorio.findAll();
    }

    @CrossOrigin
    @PostMapping("incluir")
    public List<String> incluir(@Valid @RequestBody Atleta novoAtleta){
        Mensagem mensagem = new Mensagem();
        AtletaBiz validador = new AtletaBiz(modalidadeRepositorio);
        if(validador.verificaAtleta(novoAtleta)){
            try{
                atletaRepositorio.save(novoAtleta);
                atletaRepositorio.flush();
                mensagem.mensagem.add("Sucesso ao incluir atleta");
            }catch (Exception err){
                mensagem.mensagem.add("Erro ao incluir atleta:");
                mensagem.mensagem.add(err.getMessage());
            }
        }else{
            mensagem.mensagem.add("O atleta informado é inválido:");
            mensagem.mensagem.addAll(validador.getMensagens().mensagem);
        }
        return mensagem.mensagem;
    }
}
