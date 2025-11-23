package com.pedro.api_teste.controller;

import com.pedro.api_teste.model.datasource.Jogador;
import com.pedro.api_teste.exception.JogadorNotFoundException;
import com.pedro.api_teste.model.request.JogadorResource;
import com.pedro.api_teste.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class JogadorController {

    //@Autowired
    //private BuscarJogadorPorIdServiceImp serviceBuscarPorId;
    //@Autowired
    //private BuscarJogadoresServiceImp buscarService;

    //@Autowired
    //private CadastroJogador serviceCadastro;

    @Autowired
    private JogadorService jogadorService;

    @GetMapping(path = "/jogador-id/{id}")
    public Jogador buscarJogadorPorId(
            @PathVariable(name = "id", required = true) Long id) throws JogadorNotFoundException {
        return jogadorService.buscarPorid(id);
    }
    @GetMapping(path = "/jogadores")
    public List<Jogador> buscarJogadores() {
        return jogadorService.buscarTodosJogadores();
    }

    @PostMapping(path = "/jogador/save")
    public void salvarJogador(@RequestBody JogadorResource jogador){
        jogadorService.cadastro(jogador);

    }
    @DeleteMapping(path = "/jogador/delete/{id}")
    public void deletarJogador(
            @PathVariable(name = "id", required = true) Long id) throws JogadorNotFoundException {
        jogadorService.deletarPorId(id);

    }

    //Adicionar endpoint de update, CRUD
    //PATCH e PUT, ver a diferenca
    // adicionar testes cobrindo todos os use cases, cria jogador, busca por id, busca todos os jogadores, deleta, atualiza
    //atualizar tirar getter e setters e usar lombok
    // ajustar os endpoints pra ser padrao
    // criar JogadorResponse e retornar nas API, JogadorResource vira JogadorRequest
    // adicionar validacao, o nome, a idade, posicao tem que ser obrigatorio


}
