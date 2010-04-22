package main.java.br.com.gabriel.blog.controle;

import java.util.Calendar;

import main.java.br.com.gabriel.blog.dao.Dao;
import main.java.br.com.gabriel.blog.modelo.Postagem;
import main.java.br.com.gabriel.blog.util.Login;
import main.java.br.com.gabriel.blog.util.Transactional;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
@Path("/postagem")
public class PostagemController {
	private Result result;
	private Dao<Postagem> postagemDao;

	public PostagemController(Dao<Postagem> postagemDao, Result result) {
		this.postagemDao = postagemDao;
		this.result = result;
	}

	// public List<Postagem> index() {
	@Get
	@Path("/index")
	public void index() {

	}

	@Login
	@Get
	@Path("")
	public void novaPostagem() {
		Calendar calendario = Calendar.getInstance();
		calendario.setTimeInMillis(System.currentTimeMillis());
		result.include("data", calendario);
	}

	@Get
	@Path("/{postagem.id}")
	public Postagem postagem(Postagem postagem) {
		return postagemDao.buscarPorId(postagem.getId());
	}

	@Login
	@Transactional
	@Post
	@Path("/postagem")
	public void salvar(Postagem postagem) {
		postagemDao.salvar(postagem);
		result.use(Results.logic()).redirectTo(IndexController.class).index();
	}

	@Login
	@Get
	@Path("/editar/{postagem.id}")
	public Postagem editar(Postagem postagem) {
		return postagemDao.buscarPorId(postagem.getId());
	}

	@Login
	@Transactional
	@Put
	@Path("/{postagem.id}")
	public void atualizar(Postagem postagem) {
		postagemDao.atualizar(postagem);
		result.use(Results.logic()).redirectTo(IndexController.class).index();
	}

	@Login
	@Transactional
	@Delete
	@Path("/{postagem.id}")
	public void exluir(Postagem postagem) {
		postagemDao.deletar(postagemDao.buscarPorId(postagem.getId()));
		result.use(Results.logic()).redirectTo(IndexController.class).index();
	}
}
