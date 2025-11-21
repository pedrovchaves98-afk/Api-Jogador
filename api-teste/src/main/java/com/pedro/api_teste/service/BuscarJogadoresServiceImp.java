package com.pedro.api_teste.service;

import com.pedro.api_teste.datasource.model.Jogador;
import com.pedro.api_teste.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarJogadoresServiceImp {
    @Autowired
    private JogadorRepository jogadorRepository;

    public List<Jogador> buscarTodosJogadores(){
        List< Jogador > listJogador = jogadorRepository.findAll();
        return listJogador;
    }
}
