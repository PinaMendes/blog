package main.java.br.com.gabriel.blog.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String login;
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Usuario nome(String nome){
		this.nome = nome;
		return this;
	}
	public Usuario senha(String senha) {
		this.senha = senha;
		return this;
	}

	@Override
	public String toString() {
		return this.nome + " ---- " + this.login + " ---- " + this.senha;
	}

}
