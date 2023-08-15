package br.com.calleb.dao;

import br.com.calleb.dao.IProdutoDAO;
import br.com.calleb.dao.generics.GenericDAO;
import br.com.calleb.domain.Produto;

/**
 * Description of ProdutoDAO
 * Created by calle on 02/08/2023.
 */
public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    public ProdutoDAO() {
        super();
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());
    }
}
