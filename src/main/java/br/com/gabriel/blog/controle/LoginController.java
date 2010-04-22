package main.java.br.com.gabriel.blog.controle;

import javax.servlet.http.HttpSession;

import main.java.br.com.gabriel.blog.dao.UsuarioDao;
import main.java.br.com.gabriel.blog.modelo.Usuario;
import main.java.br.com.gabriel.blog.modelo.UsuarioLogado;

import org.springframework.stereotype.Controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

@Controller
@Resource
@Path("/login")
public class LoginController {

	private UsuarioDao usuarioDao;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private Validator validator;
	private final HttpSession httpSession;

	public LoginController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado,
			Result result, Validator validator, HttpSession httpSession) {
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
		this.httpSession = httpSession;
	}

	@Get
	@Path("")
	public void login() {
	}

	@Get
	@Path("/sair")
	public void sair() {
		httpSession.invalidate();
		result.use(Results.logic()).redirectTo(IndexController.class).index();
		/*
		 * Esse é o modo e tirar o Usuário da sessão, mas com o
		 * httpSession.invalidate é possivel criar uma nova sessão para quem
		 * está logando
		 * usuarioLogado.efetuarLogin(null);
		 */

	}

	@Post
	@Path("")
	public void autentica(final Usuario usuario) {
		
		validator.checking(new Validations() {
			{
				that(!"".equals(usuario.getLogin()), "erro", "nomeNulo");
				//TODO Estudar um modo melhor de voltar com o nome
				result.include("login", usuario.getLogin());
				
				that(!"".equals(usuario.getSenha()), "erro", "senhaNula");
				//that(autenticado != null, "erro", "usuarioInvalido");
			}
		});
		validator.onErrorUse(Results.page()).of(LoginController.class).login();
		
		final Usuario autenticado = usuarioDao
				.buscaUsuarioPorLoginESenha(usuario);
		if (autenticado != null) {
			usuarioLogado.efetuarLogin(autenticado);
			result.use(Results.logic()).redirectTo(IndexController.class)
					.index();

			return;
		}

		validator.checking(new Validations() {
			{
				that(autenticado != null, "erro", "usuarioInvalido");
				result.include("login", usuario.getLogin());
			}
		});
		validator.onErrorUse(Results.page()).of(LoginController.class).login();
		
	}
}
