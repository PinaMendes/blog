package main.java.br.com.gabriel.blog;

/**
 * Classe baseada no exemplo da Caelum site: http://vraptor.caelum.com.br/documentacao/componentes-utilitarios-opcionais/.
 * @author  Gabriel Rubens
 * 
 */

import br.com.caelum.vraptor.ComponentRegistry;
import br.com.caelum.vraptor.ioc.spring.SpringProvider;

public class CustomProvider extends SpringProvider {

    /**
     * Registra componentes opcionais
     *
     * @param  registry - objeto que registra os componentes
     */
	@Override
	protected void registerCustomComponents(ComponentRegistry registry) {

		// registry.register(SessionCreator.class, SessionCreator.class);
		// registry.register(SessionFactoryCreator.class,
		// SessionFactoryCreator.class);
		// registry.register(HibernateCustomProvider.class,
		// HibernateCustomProvider.class);
	}

}
