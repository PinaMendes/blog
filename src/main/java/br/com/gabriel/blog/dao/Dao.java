package main.java.br.com.gabriel.blog.dao;

import java.util.List;

public interface Dao<T> {
	void salvar(T t);

	T buscarPorId(Long id);

	List<T> buscaTodas();

	void atualizar(T t);

	void deletar(T t);
}
