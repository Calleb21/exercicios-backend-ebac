package br.com.calleb.dao;

import br.com.calleb.domain.Cliente;

import java.util.List;

/**
 * Description of IClienteDAO
 * Created by calle on 01/02/2024.
 */
public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

    List<Cliente> filtrarClientes(String query);
}
