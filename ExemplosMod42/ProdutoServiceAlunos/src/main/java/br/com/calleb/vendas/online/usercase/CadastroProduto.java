package br.com.calleb.vendas.online.usercase;

import br.com.calleb.vendas.online.domain.Produto;
import br.com.calleb.vendas.online.domain.Produto.Status;
import br.com.calleb.vendas.online.exception.EntityNotFoundException;
import br.com.calleb.vendas.online.repository.IProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description of CadastroProduto
 * Created by calle on 16/02/2024.
 */
@Service
public class CadastroProduto {

    private IProdutoRepository produtoRepository;

    @Autowired
    public CadastroProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(@Valid Produto produto) {
        produto.setStatus(Status.ATIVO);
        return this.produtoRepository.insert(produto);
    }

    public Produto atualizar(@Valid Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public void remover(String id) {
        Produto prod = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Produto.class, "id", id));
        prod.setStatus(Status.INATIVO);
        this.produtoRepository.save(prod);
        //this.produtoRepository.deleteById(id);
    }
}
