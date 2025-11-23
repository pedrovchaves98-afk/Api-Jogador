package com.pedro.api_teste.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JogadorResource {

    @JsonProperty("nome_jogador")
    private String nome;

    @JsonProperty("idade")
    private String idade;

    @JsonProperty("Posicao")
    private String posicao;

    @JsonProperty("time")
    private String time;

    public JogadorResource() {

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "JogadorResource{" +
                "nome='" + nome + '\'' +
                ", idade='" + idade + '\'' +
                ", posicao='" + posicao + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
