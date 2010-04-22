package test.java.br.com.gabriel.blog.controle;

import static org.junit.Assert.*;

import java.util.List;

import main.java.br.com.gabriel.blog.controle.IndexController;
import main.java.br.com.gabriel.blog.controle.LoginController;
import main.java.br.com.gabriel.blog.dao.PostagemDao;
import main.java.br.com.gabriel.blog.dao.UsuarioDao;
import main.java.br.com.gabriel.blog.modelo.Postagem;
import main.java.br.com.gabriel.blog.modelo.Usuario;
import main.java.br.com.gabriel.blog.modelo.UsuarioLogado;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.view.Results;

public class LoginControllerTest {

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testSair() {
		fail("Not yet implemented");
	}

	@Test
	public void testAutentica() {
		MockResult result = new MockResult();
		MockValidator validation = new MockValidator();
		
		LoginController lc = new LoginController(new UsuarioDao(),
				new UsuarioLogado(), result, validation,
				null);
		Usuario usuario = new Usuario();
		usuario.setNome("gabriel");
		usuario.setSenha("123");
		
		lc.autentica(usuario);

		List<Postagem> postagens = result.included("postagemList");
		assertNotNull(postagens);
		
	}

}
