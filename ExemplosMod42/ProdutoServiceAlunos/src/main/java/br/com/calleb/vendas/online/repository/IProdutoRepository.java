package br.com.calleb.vendas.online.repository;

import br.com.calleb.vendas.online.domain.Produto;
import ch.qos.logback.core.status.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

/**
 * Description of IProdutoRepository
 * Created by calle on 16/02/2024.
 */
@Repository
public interface IProdutoRepository extends MongoRepository<Produto, String> {

    Optional<Produto> findByCodigo(String codigo);

    Page<Produto> findAllByStatus(Pageable pageable, Status status);
}
