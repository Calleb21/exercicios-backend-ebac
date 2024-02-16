package br.com.calleb.vendas.online.usercase;

import br.com.calleb.vendas.online.domain.Produto;
import br.com.calleb.vendas.online.exception.EntityNotFoundException;
import br.com.calleb.vendas.online.repository.IProdutoRepository;
import jakarta.transaction.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Description of BuscaProduto
 * Created by calle on 16/02/2024.
 */
@Service
public class BuscaProduto {

    private IProdutoRepository produtoRepository;

    @Autowired
    public BuscaProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> buscar(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Page<Produto> buscar(Pageable pageable, Status status) {
        return produtoRepository.findAllByStatus(pageable, status);
    }

    public Produto buscarPorCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException(Produto.class, "codigo", codigo));
    }
}
