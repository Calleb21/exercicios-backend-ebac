package br.com.calleb.vendas.online.repository;

import br.com.calleb.vendas.online.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Description of IClienteRepository
 * Created by calle on 09/02/2024.
 */
@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String> {

    Optional<Cliente> findByCpf(Long cpf);
}
