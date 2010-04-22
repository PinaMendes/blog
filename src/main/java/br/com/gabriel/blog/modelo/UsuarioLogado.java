package main.java.br.com.gabriel.blog.modelo;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioLogado {
	private Usuario usuarioLogado;
	
	public void efetuarLogin(Usuario usuario) {
		this.usuarioLogado = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	@Override
	public String toString() {
		return usuarioLogado.getNome();
	}
}
