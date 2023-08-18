package br.com.calleb.service;

import br.com.calleb.dao.IContratoDAO;

/**
 * @author calle
 */
public class ContratoService implements IContratoService{

    private IContratoDAO contratoDao;

    public ContratoService(IContratoDAO dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String bucar() {
        contratoDao.buscar();
        return "Sucesso";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Sucesso";
    }

    @Override
    public String atualizar() {
        contratoDao.atualizar();
        return "Sucesso";
    }
}
