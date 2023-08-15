package br.com.calleb.service;

import br.com.calleb.dao.IClienteDAO;
import br.com.calleb.domain.Cliente;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;
import br.com.calleb.service.generics.GenericService;

/**
 * Description of ClienteService
 * Created by calle on 01/08/2023.
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    //private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        //this.clienteDAO = clienteDAO;
    }

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }
    @Override
    public void salvar(Long cpf) {
        Cliente cliente = new Cliente(); // Criar uma nova instância de Cliente ou buscar o cliente existente com base no CPF, dependendo da lógica do sistema.
        cliente.setCpf(cpf);
        // Aqui você pode adicionar lógica para preencher outras informações do cliente (por exemplo, nome, endereço, etc.) antes de salvar.
        try {
            cadastrar(cliente);
        } catch (TipoChaveNaoEncontradaException e) {
            // Lide com a exceção, se necessário.
        }
    }

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}
}
