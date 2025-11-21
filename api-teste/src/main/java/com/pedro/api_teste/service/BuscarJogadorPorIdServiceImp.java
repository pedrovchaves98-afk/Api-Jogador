package com.pedro.api_teste.service;

import com.pedro.api_teste.datasource.model.Jogador;
import com.pedro.api_teste.exception.JogadorNotFoundException;
import com.pedro.api_teste.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

@Service
public class BuscarJogadorPorIdServiceImp {
    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador buscarPorid(Long id) throws JogadorNotFoundException {
        Optional<Jogador> optionalJogador = getOptional(id);

        Jogador jogador = null;
        if (!optionalJogador.isPresent()){
            throw new JogadorNotFoundException("Jogador não encontrado atraves do ID: " + id);
        } else{
            jogador = optionalJogador.get();
        }
        return jogador;
    }

    private Optional<Jogador> getOptional(Long id) {
        Optional<Jogador> optionalJogador = jogadorRepository.findById(id);
        return optionalJogador;
    }

    public void deletarPorId(Long id) throws JogadorNotFoundException {
        Optional<Jogador> optionalJogador = getOptional(id);
        if (!optionalJogador.isPresent()){
            throw new JogadorNotFoundException("Jogador não encontrado atraves do ID: " + id);
        } else {
            jogadorRepository.delete(optionalJogador.get());
        }

    }
}
