package com.alexbarros.sistema_biblioteca;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaBibliotecaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SistemaBibliotecaApplication.class, args);
		Biblioteca biblioteca = new Biblioteca();
		Scanner scanner = new Scanner(System.in);

		// Adicionando autores
		Autor autor1 = new Autor(1, "J.K. Rowling", new Date());
		Autor autor2 = new Autor(2, "J.R.R. Tolkien", new Date());
		
		biblioteca.adicionarAutor(autor1);
		biblioteca.adicionarAutor(autor2);

		// Adicionando livros
		Livro livro1 = new Livro(1, "Harry Potter e a Pedra Filosofal", autor1);
        Livro livro2 = new Livro(2, "O Senhor dos Anéis: A Sociedade do Anel", autor2);
        Livro livro3 = new Livro(3, "Harry Potter e a Câmara Secreta", autor1);

		biblioteca.adicionarLivro(livro1);
		biblioteca.adicionarLivro(livro2);
		biblioteca.adicionarLivro(livro3);

		// Loop para a interação com o usuário
		while (true) {
			System.out.println("Deseja ver os livros disponiveis? (s/n)");
			String resposta = scanner.nextLine().toLowerCase();

			if (resposta.equals("s") || resposta.equals("sim")) {
				List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();

				if (livrosDisponiveis.isEmpty()) {
					System.out.println("Não há livros disponíveis no momento.");
				} else {
					System.out.println("Livros disponíveis:");
					for (Livro livro : livrosDisponiveis) {
						System.out.println(livro.getId() + ": " + livro.getTitulo());
					}

					System.out.println("Digite o ID do livro que deseja alugar:");
					int idLivro = scanner.nextInt();
					scanner.nextLine();

					Livro livroSelecionado = biblioteca.buscarLivroPorID(idLivro);

					if (livroSelecionado != null && livroSelecionado.isDisponivel()) {
						System.out.println("Digite seu nome:");
						String nomeUsuario = scanner.nextLine();

						biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);
						System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + nomeUsuario );
					} else {
						System.out.println("Livro não encontrado ou não disponível para empréstimo.");
					}
				}
			} else if (resposta.equals("n") || resposta.equals("não") || resposta.equals("nao"))
			{
				System.out.println("Obrigado por utilizar o sistema da biblioteca. Até mais!");
				break;
			} else {
				System.out.println("Resposta inválida. Por favor, responda com 'sim/s' ou 'não/n'.\"");	
			}
		}
		scanner.close();
	}

}
