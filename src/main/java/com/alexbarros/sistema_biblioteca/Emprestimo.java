package com.alexbarros.sistema_biblioteca;

import java.util.Date;

import lombok.Data;

@Data
public class Emprestimo {
    private int id;
    private static int contadorId = 1;
    private Livro livro;
    private String nomeUsuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean ativo;

    public Emprestimo(Livro livro, String nomeUsuario) {
        this.id = contadorId++;
        this.livro = livro;
        this.nomeUsuario = nomeUsuario;
        this.dataEmprestimo = new Date();
        this.ativo = true;
    }

    public void devolverLivro() {
        this.dataDevolucao = new Date();
        this.ativo = false;
        this.livro.setDisponivel(true);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", livro=" + livro +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", ativo=" + ativo +
                '}';
    }
}
