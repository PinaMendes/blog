package main.java.br.com.gabriel.blog.dao;

import java.util.List;

import main.java.br.com.gabriel.blog.interceptador.TransactionInterceptor;
import main.java.br.com.gabriel.blog.modelo.Postagem;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@RequestScoped
public class PostagemDao implements Dao<Postagem> {

	public void atualizar(Postagem postagem) {
		TransactionInterceptor.session.merge(postagem);
	}

	public Postagem buscarPorId(Long id) {
		return (Postagem) TransactionInterceptor.session.load(Postagem.class,
				id);
	}

	public void deletar(Postagem postagem) {
		TransactionInterceptor.session.delete(postagem);
	}

	public void salvar(Postagem postagem) {
		TransactionInterceptor.session.save(postagem);
	}

	@SuppressWarnings("unchecked")
	public List<Postagem> buscaTodas() {
		return TransactionInterceptor.session.createCriteria(Postagem.class)
				.list();
	}

}
