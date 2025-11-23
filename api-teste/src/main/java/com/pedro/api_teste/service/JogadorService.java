package com.pedro.api_teste.service;

import com.pedro.api_teste.model.datasource.Jogador;
import com.pedro.api_teste.exception.JogadorNotFoundException;
import com.pedro.api_teste.exception.JogadorResourceException;
import com.pedro.api_teste.repository.JogadorRepository;
import com.pedro.api_teste.model.request.JogadorResource;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JogadorService {
    private final JogadorRepository jogadorRepository;
    private final JogadorConversor service;
    //andrey mudou

    public List<Jogador> buscarTodosJogadores(){
        return jogadorRepository.findAll();
    }

    public Jogador buscarPorid(Long id) throws JogadorNotFoundException {
        return getOptional(id)
                .orElseThrow( () -> new JogadorNotFoundException("Jogador não encontrado atraves do ID: " + id));
    }

    private Optional<Jogador> getOptional(Long id) {
        return jogadorRepository.findById(id);
    }

    public void deletarPorId(Long id) throws JogadorNotFoundException {
        Optional<Jogador> optionalJogador = getOptional(id);
        if (!optionalJogador.isPresent()){
            throw new JogadorNotFoundException("Jogador não encontrado atraves do ID: " + id);
        } else {
            jogadorRepository.delete(optionalJogador.get());
        }

    }

    public void cadastro(JogadorResource jogadorResource){
        try {
            Jogador jogador = service.conversor(jogadorResource);
            jogadorRepository.saveAndFlush(jogador);

        } catch (JogadorResourceException e) {
            throw new RuntimeException("Erro ao cadastrar jogador: " + e.getMessage());
        }

    }
}
