package main.java.br.com.gabriel.blog.interceptador;

import main.java.br.com.gabriel.blog.controle.LoginController;
import main.java.br.com.gabriel.blog.modelo.UsuarioLogado;
import main.java.br.com.gabriel.blog.util.Login;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.view.Results;

@Intercepts
public class LoginInterceptor implements Interceptor {
	private UsuarioLogado usuarioLogado;
	private Result result;

	public LoginInterceptor(UsuarioLogado usuarioLogado, Result result) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object instance) throws InterceptionException {
		if (usuarioLogado.getUsuarioLogado() != null) {
			stack.next(method, instance);
		} else {
			result.use(Results.logic()).redirectTo(LoginController.class)
					.login();
		}
	}

	public boolean accepts(ResourceMethod method) {			
		return method.getMethod() // metodo anotado
		.isAnnotationPresent(Login.class)
		|| method.getResource() // ou recurso anotado
				.getType().isAnnotationPresent(Login.class);
	}

}
