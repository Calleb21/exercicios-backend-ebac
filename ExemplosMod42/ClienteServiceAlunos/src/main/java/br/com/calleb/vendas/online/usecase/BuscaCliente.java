package br.com.calleb.vendas.online.usecase;

import br.com.calleb.vendas.online.domain.Cliente;
import br.com.calleb.vendas.online.exception.EntityNotFoundException;
import br.com.calleb.vendas.online.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Description of BuscaCliente
 * Created by calle on 09/02/2024.
 */
@Service
public class BuscaCliente {

    private IClienteRepository clienteRepository;

    @Autowired
    public BuscaCliente(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Page<Cliente> buscar(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente buscarPorId(String id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Cliente.class, "id", id));
    }

    public Boolean isCadastrado(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.isPresent() ? true : false;
    }

    public Cliente buscarPorCpf(Long cpf) {
        return clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException(Cliente.class, "cpf", String.valueOf(cpf)));
    }
}
