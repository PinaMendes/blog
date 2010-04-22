package main.java.br.com.gabriel.blog.modelo;

import java.util.Calendar;

public class Comentario {
	private final String nome;
	private final Calendar dataDoComentario;
	private final String email;

	public Comentario(String nome, Calendar dataDoComentario, String email) {
		this.nome = nome;
		this.dataDoComentario = dataDoComentario;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataDoComentario() {
		return dataDoComentario;
	}

	public String getEmail() {
		return email;
	}

}
