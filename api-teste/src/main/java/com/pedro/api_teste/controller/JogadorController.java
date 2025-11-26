package com.pedro.api_teste.controller;

import com.pedro.api_teste.exception.JogadorResourceException;
import com.pedro.api_teste.model.datasource.Jogador;
import com.pedro.api_teste.exception.JogadorNotFoundException;
import com.pedro.api_teste.model.request.JogadorResource;
import com.pedro.api_teste.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping(path = "/buscarPorId/{id}")
    public Jogador buscarJogadorPorId(
            @PathVariable(name = "id", required = true) Long id) throws JogadorNotFoundException {
        return jogadorService.buscarPorid(id);
    }
    @GetMapping(path = "/jogadores")
    public List<Jogador> buscarJogadores() {
        return jogadorService.buscarTodosJogadores();
    }

    @PostMapping(path = "/save")
    public void salvarJogador(@RequestBody JogadorResource jogador){
        jogadorService.cadastro(jogador);

    }
    @DeleteMapping(path = "/delete/{id}")
    public void deletarJogador(
            @PathVariable(name = "id", required = true) Long id) throws JogadorNotFoundException {
        jogadorService.deletarPorId(id);

    }

    @PutMapping(path = "/update/{id}")
    public void update(@RequestBody JogadorResource jogador, @PathVariable(name = "id", required = true) Long id ) throws JogadorResourceException, JogadorNotFoundException {
            jogadorService.updateJogador(jogador, id);
    }

}
