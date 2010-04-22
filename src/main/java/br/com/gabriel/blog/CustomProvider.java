package main.java.br.com.gabriel.blog;

import br.com.caelum.vraptor.ComponentRegistry;
import br.com.caelum.vraptor.ioc.spring.SpringProvider;

public class CustomProvider extends SpringProvider {

	@Override
	protected void registerCustomComponents(ComponentRegistry registry) {

		// registry.register(SessionCreator.class, SessionCreator.class);
		// registry.register(SessionFactoryCreator.class,
		// SessionFactoryCreator.class);
		// registry.register(HibernateCustomProvider.class,
		// HibernateCustomProvider.class);
	}

}
