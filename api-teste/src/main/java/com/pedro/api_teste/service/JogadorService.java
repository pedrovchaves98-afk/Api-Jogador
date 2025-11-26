package com.pedro.api_teste.service;

import com.pedro.api_teste.model.datasource.Jogador;
import com.pedro.api_teste.exception.JogadorNotFoundException;
import com.pedro.api_teste.exception.JogadorResourceException;
import com.pedro.api_teste.repository.JogadorRepository;
import com.pedro.api_teste.model.request.JogadorResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JogadorService {
    private final JogadorRepository jogadorRepository;
    private final JogadorConversor service;

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
    public Jogador updateJogador(@RequestBody JogadorResource jogadorResource, @PathVariable(name = "id", required = true) Long id ) throws JogadorNotFoundException {
                Jogador jogadorUp = buscarPorid(id);

                if (jogadorResource.getNome() != null) {
                    jogadorUp.setNome(jogadorResource.getNome());
                }
                if (jogadorResource.getIdade() != null) {
                    jogadorUp.setIdade(LocalDate.parse(jogadorResource.getIdade()));
                }
                if (jogadorResource.getPosicao() != null) {
                    jogadorUp.setPosicao(jogadorResource.getPosicao());
                }
                if (jogadorResource.getTime() != null) {
                    jogadorUp.setTime(jogadorResource.getTime());
                }

        return jogadorRepository.saveAndFlush(jogadorUp);
    }
}
