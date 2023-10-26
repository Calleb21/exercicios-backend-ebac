package br.com.calleb.dao;

import br.com.calleb.domain.Curso;

public interface ICursoDao {

	public Curso cadastrar(Curso curso);
	
	public Curso consultarPorId(Long id);

	public Curso atualizar(Curso cursoCadastrado);

	public void excluirCurso(Long idParaExclusao);


}
