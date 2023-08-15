package br.com.calleb.dao;

import br.com.calleb.domain.Cliente;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

/**
 * Description of ClienteDAOMock
 * Created by calle on 01/08/2023.
 */
public class ClienteDAOMock implements IClienteDAO {


    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }
}
