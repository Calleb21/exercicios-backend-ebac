package br.com.calleb.service;

import br.com.calleb.dao.IClienteDAO;
import br.com.calleb.dao.ClienteDAOMock;
import br.com.calleb.dao.IContratoDAO;


/**
 * @author calle
 */
public class ClienteService {

    public IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        //clienteDao = new ClienteDao();
        //clienteDao = new ClienteDaoMock();
        this.clienteDAO = clienteDAO;
    }

    public String salvar() {
        clienteDAO.salvar();
        return "Sucesso";
    }
}
