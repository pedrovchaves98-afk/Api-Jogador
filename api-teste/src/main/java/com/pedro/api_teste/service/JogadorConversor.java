package com.pedro.api_teste.service;

import com.pedro.api_teste.datasource.model.Jogador;
import com.pedro.api_teste.exception.JogadorResourceException;
import com.pedro.api_teste.resource.model.JogadorResource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class JogadorConversor {

    public Jogador conversor(JogadorResource jogadorResource)
            throws JogadorResourceException {

                try {
                    Jogador jogador = new Jogador();

                    LocalDate idade = checkIdade(jogadorResource.getIdade());
                    jogador.setIdade(idade);
                    jogador.setNome(jogadorResource.getNome());
                    jogador.setTime(jogadorResource.getTime());
                    jogador.setPosicao(jogadorResource.getPosicao());

                    return jogador;
                }catch (Exception e){
                    throw new JogadorResourceException(
                            "Falha ao converter o resource para entidade, resource: "
                                    + jogadorResource);

                }


    }

    private LocalDate checkIdade(String idade){
        return LocalDate.parse(idade);
    }
}
