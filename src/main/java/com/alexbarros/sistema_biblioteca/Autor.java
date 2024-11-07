package com.alexbarros.sistema_biblioteca;

import java.util.Date;

import lombok.Data;

@Data
public class Autor {
    private int id;
    private String nome;
    private Date dataNascimento;

    public Autor(int id, String nome, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
