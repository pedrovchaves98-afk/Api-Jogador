package com.pedro.api_teste.model.datasource;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@Entity
@Table(name = "jogador")
public class Jogador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nomejogador")
    private String nome;
    private LocalDate idade;

    @Column(name = "Posicao")
    private String posicao;
    private String time;

}

