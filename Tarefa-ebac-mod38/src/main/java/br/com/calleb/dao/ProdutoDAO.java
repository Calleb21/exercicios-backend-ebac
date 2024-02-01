package br.com.calleb.dao;

import br.com.calleb.domain.Produto;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Description of ProdutoDAO
 * Created by calle on 01/02/2024.
 */
public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class);
    }

    @Override
    public List<Produto> filtrarProdutos(String query) {
        TypedQuery<Produto> tpQuery =
                this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
        tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
    }
}
