package com.pedro.api_teste.repository;


import com.pedro.api_teste.model.datasource.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JogadorRepository
        extends JpaRepository<Jogador,Long> {

    @Query()
    Optional<Jogador> findByIdCustom(Long id);
}
