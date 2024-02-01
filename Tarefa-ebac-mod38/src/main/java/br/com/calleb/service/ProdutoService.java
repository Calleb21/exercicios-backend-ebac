package br.com.calleb.service;

import java.util.List;

import br.com.calleb.domain.Produto;
import br.com.calleb.service.controller.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Description of ProdutoService
 * Created by calle on 01/02/2024.
 */
@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    private IProdutoDAO produtoDao;

    @Inject
    public ProdutoService(IProdutoDAO produtoDao) {
        super(produtoDao);
        this.produtoDao = produtoDao;
    }

    @Override
    public List<Produto> filtrarProdutos(String query) {
        return produtoDao.filtrarProdutos(query);
    }
}
