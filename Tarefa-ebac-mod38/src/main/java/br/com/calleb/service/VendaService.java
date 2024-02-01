package br.com.calleb.service;

import br.com.calleb.domain.Venda;
import br.com.calleb.exceptions.DAOException;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;
import br.com.calleb.service.controller.GenericService;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Description of VendaService
 * Created by calle on 01/02/2024.
 */
@Stateless
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

    IVendaDAO dao;

    @Inject
    public VendaService(IVendaDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Venda.Status.CONCLUIDA);
        dao.finalizarVenda(venda);
    }

    @Override
    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
        venda.setStatus(Venda.Status.CANCELADA);
        dao.cancelarVenda(venda);
    }

    @Override
    public Venda consultarComCollection(Long id) {
        return dao.consultarComCollection(id);
    }

    @Override
    public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
        entity.setStatus(Venda.Status.INICIADA);
        return super.cadastrar(entity);
    }
}
