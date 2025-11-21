package com.pedro.api_teste.repository;


import com.pedro.api_teste.datasource.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository
        extends JpaRepository<Jogador,Long> {
}
