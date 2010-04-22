package main.java.br.com.gabriel.blog.util;

import main.java.br.com.gabriel.blog.modelo.Postagem;
import main.java.br.com.gabriel.blog.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {
	private static SessionFactory factory;

	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Postagem.class);
		cfg.addAnnotatedClass(Usuario.class);
		factory = cfg.buildSessionFactory();
	}

	public Session getSession() {
		return factory.openSession();
	}
}
