package br.com.calleb.dao;

import br.com.calleb.domain.Loja;
import br.com.calleb.domain.Marca;

/**
 * @author calle
 * 
 */
public interface ILojaDao {

	Loja cadastrar(Loja loja);

	Loja buscarCodigoMarca(String identificador);

	Loja buscarPorCurso(Marca marca);
}
