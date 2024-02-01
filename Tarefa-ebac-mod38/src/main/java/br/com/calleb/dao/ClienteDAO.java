package br.com.calleb.dao;

import br.com.calleb.domain.Cliente;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Description of ClienteDAO
 * Created by calle on 01/02/2024.
 */
public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> filtrarClientes(String query) {
        TypedQuery<Cliente> tpQuery =
                this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
        tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
    }
}
