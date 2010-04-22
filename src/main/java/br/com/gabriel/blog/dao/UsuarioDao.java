package main.java.br.com.gabriel.blog.dao;

import main.java.br.com.gabriel.blog.interceptador.TransactionInterceptor;
import main.java.br.com.gabriel.blog.modelo.Usuario;

import org.hibernate.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class UsuarioDao {

	public Usuario buscaUsuarioPorLoginESenha(Usuario usuario) {
		Query query = TransactionInterceptor.session
				.createQuery("from Usuario where login = :pLogin and senha = :pSenha");

		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());

		System.out.println((Usuario) query.uniqueResult());

		return (Usuario) query.uniqueResult();
	}
}
