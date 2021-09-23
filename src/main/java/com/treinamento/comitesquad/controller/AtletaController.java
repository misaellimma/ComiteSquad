package com.treinamento.comitesquad.controller;

import com.treinamento.comitesquad.Mensagem;
import com.treinamento.comitesquad.entities.Atleta;
import com.treinamento.comitesquad.repositories.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atleta")
public class AtletaController {
    @Autowired
    AtletaRepository atletaRepositorio;

    @CrossOrigin
    @GetMapping("listar")
    public List<Atleta> listar(){
        return atletaRepositorio.findAll();
    }

    @PostMapping("incluir")
    public void incluir(){
        //TODO: Post
    }
}
