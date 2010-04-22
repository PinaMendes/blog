package main.java.br.com.gabriel.blog.interceptador;

import main.java.br.com.gabriel.blog.util.HibernateUtil;
import main.java.br.com.gabriel.blog.util.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
public class TransactionInterceptor implements Interceptor {

	public static final Session session = new HibernateUtil().getSession();

	// public TransactionInterceptor(Session session) {
	// this.session = session;
	// public TransactionInterceptor() {
	// this.session = new HibernateUtil().getSession();
	// }

	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object instance) throws InterceptionException {
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			stack.next(method, instance);
			session.flush();
			transaction.commit();

		} catch (Exception e) {
			System.out.println("Erro no TransactionInterceptor\n");
			e.printStackTrace();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}

	}

	public boolean accepts(ResourceMethod method) {

		return method.getMethod() // metodo anotado
				.isAnnotationPresent(Transactional.class)
				|| method.getResource() // ou recurso anotado
						.getType().isAnnotationPresent(Transactional.class);
	}

}
