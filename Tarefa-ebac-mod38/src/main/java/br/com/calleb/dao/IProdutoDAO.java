package br.com.calleb.dao;

import br.com.calleb.domain.Produto;

import java.util.List;

/**
 * Description of IProdutoDAO
 * Created by calle on 01/02/2024.
 */
public interface IProdutoDAO extends IGenericDAO<Produto, String> {

    List<Produto> filtrarProdutos(String query);

}
