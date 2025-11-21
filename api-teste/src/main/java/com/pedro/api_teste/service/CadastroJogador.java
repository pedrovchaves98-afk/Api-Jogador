package com.pedro.api_teste.service;

import com.pedro.api_teste.datasource.model.Jogador;
import com.pedro.api_teste.exception.JogadorResourceException;
import com.pedro.api_teste.repository.JogadorRepository;
import com.pedro.api_teste.resource.model.JogadorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroJogador {
    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private JogadorConversor service;

    public void cadastro(JogadorResource jogadorResource){


        try {
           Jogador jogador = service.conversor(jogadorResource);
           jogadorRepository.saveAndFlush(jogador);

        } catch (JogadorResourceException e) {
            throw new RuntimeException("Erro ao cadastrar jogador: " + e.getMessage());
        }

    }


}
