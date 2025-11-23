package com.pedro.api_teste.service;

import com.pedro.api_teste.model.datasource.Jogador;
import com.pedro.api_teste.exception.JogadorResourceException;
import com.pedro.api_teste.model.request.JogadorResource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class JogadorConversor {

    public Jogador conversor(JogadorResource jogadorResource)
            throws JogadorResourceException {

                try {
                    LocalDate idade = checkIdade(jogadorResource.getIdade());

                    return Jogador.builder()
                                    .idade(idade)
                                    .nome(jogadorResource.getNome())
                                    .time(jogadorResource.getTime())
                                    .posicao(jogadorResource.getPosicao())
                                    .build();

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
