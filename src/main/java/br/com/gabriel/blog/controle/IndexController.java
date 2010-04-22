package main.java.br.com.gabriel.blog.controle;

import java.util.List;

import main.java.br.com.gabriel.blog.dao.Dao;
import main.java.br.com.gabriel.blog.modelo.Postagem;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class IndexController {
	// private Result result;
	private Dao<Postagem> postagemDao;

	public IndexController(Dao<Postagem> postagemDao) {
		// this.result = result;
		this.postagemDao = postagemDao;
	}

	@Get
	@Path("/")
	public List<Postagem> index() {
		// return null;
		return postagemDao.buscaTodas();
	}
}
