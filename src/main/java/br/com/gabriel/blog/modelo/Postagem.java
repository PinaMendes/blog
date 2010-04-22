package main.java.br.com.gabriel.blog.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="postagem")
public class Postagem {
	@Id
	@GeneratedValue
	private Long id;
	private String autor;
	private String titulo;
	private Calendar dataDePostagem;
	private String texto;

	// private List<Comentario> comentarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDataDePostagem() {
		return (Calendar) dataDePostagem.clone();
	}

	public void setDataDePostagem(Calendar dataDePostagem) {
		this.dataDePostagem = dataDePostagem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	/*
	 * public List<Comentario> getComentarios() { return this.comentarios =
	 * Collections.unmodifiableList(comentarios); }
	 * 
	 * public void setComentarios(List<Comentario> comentarios) {
	 * this.comentarios = comentarios; }
	 */
	@Override
	public String toString() {
		return "Autor: " + this.autor + "\n" + this.texto + "\n" + this.id;
	}
}
