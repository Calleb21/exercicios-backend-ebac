package br.com.calleb.service;

import br.com.calleb.dao.IClienteDAO;
import br.com.calleb.dao.IProdutoDAO;
import br.com.calleb.domain.Cliente;
import br.com.calleb.domain.Produto;
import br.com.calleb.service.generics.GenericService;

/**
 * Description of ProdutoService
 * Created by calle on 02/08/2023.
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }
}
