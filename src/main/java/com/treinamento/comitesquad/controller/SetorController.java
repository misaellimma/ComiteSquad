package com.treinamento.comitesquad.controller;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.biz.SetorBiz;
import com.treinamento.comitesquad.entities.Setor;
import com.treinamento.comitesquad.repositories.SetorRepository;
import com.treinamento.comitesquad.repositories.ComiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("setor")
public class SetorController {
    @Autowired
    SetorRepository setorRepositorio;
    @Autowired
    ComiteRepository comiteRepositorio;

    @CrossOrigin
    @GetMapping("listar")
    public List<Setor> listar(){
        return setorRepositorio.findAll();
    }

    @CrossOrigin
    @PostMapping("incluir")
    public List<String> incluir(@Valid @RequestBody Setor novoSetor){
        Mensagem mensagem = new Mensagem();
        SetorBiz validador = new SetorBiz(comiteRepositorio);
        if(validador.verificaSetor(novoSetor)){
            try{
                setorRepositorio.save(novoSetor);
                setorRepositorio.flush();
                mensagem.mensagem.add("Sucesso ao incluir setor");
            }catch (Exception err){
                mensagem.mensagem.add("Erro ao incluir setor:");
                mensagem.mensagem.add(err.getMessage());
            }
        }else{
            mensagem.mensagem.add("O setor informado é inválido:");
            mensagem.mensagem.addAll(validador.getMensagens().mensagem);
        }
        return mensagem.mensagem;
    }
}
