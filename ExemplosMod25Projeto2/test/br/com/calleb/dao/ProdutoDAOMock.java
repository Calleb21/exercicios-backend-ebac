package br.com.calleb.dao;

import br.com.calleb.domain.Produto;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

/**
 * Description of ProdutoDAOMock
 * Created by calle on 03/08/2023.
 */
public class ProdutoDAOMock implements IProdutoDAO{

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(String valor) {

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Produto consultar(String valor) {
        return null;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return null;
    }
}
