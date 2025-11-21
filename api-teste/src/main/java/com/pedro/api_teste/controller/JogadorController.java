package com.pedro.api_teste.controller;

import com.pedro.api_teste.datasource.model.Jogador;
import com.pedro.api_teste.exception.JogadorNotFoundException;
import com.pedro.api_teste.resource.model.JogadorResource;
import com.pedro.api_teste.service.BuscarJogadorPorIdServiceImp;
import com.pedro.api_teste.service.BuscarJogadoresServiceImp;
import com.pedro.api_teste.service.CadastroJogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class JogadorController {

    @Autowired
    private BuscarJogadorPorIdServiceImp serviceBuscarPorId;
    @Autowired
    private BuscarJogadoresServiceImp buscarService;

    @Autowired
    private CadastroJogador serviceCadastro;

    @GetMapping(path = "/jogador-id/{id}")
    public Jogador buscarJogadorPorId(
            @PathVariable(name = "id", required = true) Long id) throws JogadorNotFoundException {
        return serviceBuscarPorId.buscarPorid(id);
    }
    @GetMapping(path = "/jogadores")
    public List<Jogador> buscarJogadores() {
        return buscarService.buscarTodosJogadores();
    }

    @PostMapping(path = "/jogador/save")
    public void salvarJogador(@RequestBody JogadorResource jogador){
        serviceCadastro.cadastro(jogador);

    }
    @DeleteMapping(path = "/jogador/delete/{id}")
    public void deletarJogador(
            @PathVariable(name = "id", required = true) Long id) throws JogadorNotFoundException {
        serviceBuscarPorId.deletarPorId(id);

    }
}
