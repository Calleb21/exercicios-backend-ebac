package br.com.calleb.dao;

import br.com.calleb.dao.generics.GenericDAO;
import br.com.calleb.domain.Venda;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;

/**
 * Description of VendaDAO
 * Created by calle on 02/08/2023.
 */
public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {

    @Override
    public Class<Venda> getTipoClasse() {
        return Venda.class;
    }

    @Override
    public void atualiarDados(Venda entity, Venda entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setStatus(entity.getStatus());
    }

    @Override
    public void excluir(String valor) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException {
        venda.setStatus(Venda.Status.CONCLUIDA);
        super.alterar(venda);
    }
}
