package br.com.calleb.dao;

import br.com.calleb.domain.Matricula;

public interface IMatriculaDao {

	Matricula cadastrar(Matricula mat);

	Matricula consultarPorId(Long id);

	Matricula atualizar(Matricula matriculaCadastrada);

	void excluirMatricula(Long idParaExcluir);
}
