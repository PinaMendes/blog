package main.java.br.com.gabriel.blog.controle;

/**
 * Classe com o controle de login do sistema
 * @author  Gabriel Rubens
 */

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

	/**
	* Construtor do controle
	* Recebe todos os parametros po injeçao 
	*
	* @param  usuarioDao - dao que será utilizado para as ações com o banco
	* @param usuarioLogado - objeto que contem o usuario logado no sistema
	* @param result - objeto do VRpator que redireciona
	* @param  validator - objeto de validação do VRaptor
	* @param httpSession - esse contrutor recebe um HttpSession para poder controlar a sessao
	*/
	public LoginController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado,
			Result result, Validator validator, HttpSession httpSession) {
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
		this.httpSession = httpSession;
	}

	/**
	* Vai para a pagina de login 
	*/
	@Get
	@Path("")
	public void login() {
	}

	/**
	* Tira o usuario da sessao, cria uma nova e redireciona para o index 
	*/
	@Get
	@Path("/sair")
	public void sair() {
		httpSession.invalidate();
		result.use(Results.logic()).redirectTo(IndexController.class).index();
		/*
		 * Esse Ã© o modo e tirar o UsuÃ¡rio da sessÃ£o, mas com o
		 * httpSession.invalidate Ã© possivel criar uma nova sessÃ£o para quem
		 * estÃ¡ logando
		 * usuarioLogado.efetuarLogin(null);
		 */

	}

	/**
	 * Validacao de usuario
	 * @param usuario esse usuario e recebido pelos campos da JSP Login
	 */
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
