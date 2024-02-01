package br.com.calleb.service;

import java.util.List;

import br.com.calleb.domain.Produto;
import br.com.calleb.service.controller.IGenericService;

/**
 * Description of IProdutoService
 * Created by calle on 01/02/2024.
 */
public interface IProdutoService extends IGenericService<Produto, String> {

    List<Produto> filtrarProdutos(String query);
}
