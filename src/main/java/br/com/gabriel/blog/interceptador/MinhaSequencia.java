package main.java.br.com.gabriel.blog.interceptador;

import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.interceptor.InterceptorSequence;

public class MinhaSequencia implements InterceptorSequence {

	@SuppressWarnings("unchecked")
	public Class<? extends Interceptor>[] getSequence() {
		return new Class[] { LoginInterceptor.class, TransactionInterceptor.class };
	}

}
