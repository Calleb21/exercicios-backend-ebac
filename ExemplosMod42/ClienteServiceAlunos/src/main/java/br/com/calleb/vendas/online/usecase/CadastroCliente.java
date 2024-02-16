package br.com.calleb.vendas.online.usecase;

import br.com.calleb.vendas.online.domain.Cliente;
import br.com.calleb.vendas.online.repository.IClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description of CadastroCliente
 * Created by calle on 09/02/2024.
 */
@Service
public class CadastroCliente {

    private IClienteRepository clienteRepository;

    @Autowired
    public CadastroCliente(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(@Valid Cliente cliente) {
        return this.clienteRepository.insert(cliente);
    }

    public Cliente atualizar(@Valid Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public void remover(String id) {
        this.clienteRepository.deleteById(id);
    }
}
