package main.java.br.com.gabriel.blog.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Usado para garantir que um determinado recurso interceptado seja executada em
 * um escopo de transa��o.
 * 
 * @author Tomaz Lavieri
 * @since 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.TYPE })
public @interface Transactional {

}
