package br.com.calleb.service;

import java.util.List;

import br.com.calleb.domain.Cliente;
import br.com.calleb.exceptions.DAOException;
import br.com.calleb.service.controller.IGenericService;


/**
 * Description of IClienteService
 * Created by calle on 01/02/2024.
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

    Cliente buscarPorCPF(Long cpf) throws DAOException;

    List<Cliente> filtrarClientes(String query);
}
