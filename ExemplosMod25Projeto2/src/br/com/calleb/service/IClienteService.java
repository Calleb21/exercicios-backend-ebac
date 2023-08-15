package br.com.calleb.service;

import br.com.calleb.domain.Cliente;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;

/**
 * Description of IClienteService
 * Created by calle on 01/08/2023.
 */
public interface IClienteService {

    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf);

    void salvar(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
