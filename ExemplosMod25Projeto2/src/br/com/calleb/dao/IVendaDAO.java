package br.com.calleb.dao;

import br.com.calleb.dao.generics.IGenericDAO;
import br.com.calleb.domain.Venda;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;

/**
 * Description of IVenda
 * Created by calle on 02/08/2023.
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
