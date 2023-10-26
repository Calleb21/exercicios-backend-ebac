package br.com.calleb.dao;

import br.com.calleb.domain.Produto;

public interface IProdutoDao {

	Produto cadastrar(Produto produtoTest);

	Produto consultarProdutoId(Long idConsulta);

	Produto atualizar(Produto produtoCadastrado);

	void excluirProduto(Long idParaExclusao);

}
