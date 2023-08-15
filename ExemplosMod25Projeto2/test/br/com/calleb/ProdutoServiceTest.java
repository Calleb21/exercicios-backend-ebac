package br.com.calleb;

import br.com.calleb.dao.IProdutoDAO;
import br.com.calleb.dao.ProdutoDAOMock;
import br.com.calleb.domain.Produto;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;
import br.com.calleb.service.IProdutoService;
import br.com.calleb.service.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Description of ProdutoServiceTest
 * Created by calle on 03/08/2023.
 */
public class ProdutoServiceTest {

    private IProdutoService produtoService;
    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDAOMock();
        produtoService = new ProdutoService(dao);
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo("P1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto1 Teste");
        produto.setValor(BigDecimal.TEN);
    }

    @Test
    public void pesquisar() {
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produto);
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno.booleanValue());
    }

    @Test
    public void excluir() {
        produtoService.excluir(produto.getCodigo());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        produto.setNome("Calleb C. Camargo");
        produtoService.alterar(produto);

        Assert.assertEquals("Calleb C. Camargo", produto.getNome());
    }
}
