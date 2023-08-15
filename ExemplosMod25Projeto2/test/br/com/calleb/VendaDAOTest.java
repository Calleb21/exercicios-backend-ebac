package br.com.calleb;

import br.com.calleb.dao.*;
import br.com.calleb.domain.Cliente;
import br.com.calleb.domain.Produto;
import br.com.calleb.domain.Venda;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.Assert.*;

/**
 * Description of VendaDAOTest
 * Created by calle on 03/08/2023.
 */

public class VendaDAOTest {

    private IVendaDAO vendaDao;

    private IClienteDAO clienteDao;

    private IProdutoDAO produtoDao;

    private Cliente cliente;

    private Produto produto;

    public VendaDAOTest() {
        vendaDao = new VendaDAO();
        clienteDao = new ClienteDAO();
        produtoDao = new ProdutoDAO();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        this.cliente = cadastrarCliente();
        this.produto = cadastrarProduto("A1", BigDecimal.TEN);
    }


    @Test
    public void pesquisar() throws TipoChaveNaoEncontradaException {
        Venda venda = criarVenda("A1");
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        Venda vendaConsultada = vendaDao.consultar(venda.getCodigo());
        assertNotNull(vendaConsultada);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException {
        Venda venda = criarVenda("A2");
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
        assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
    }


    @Test
    public void cancelarVenda() throws TipoChaveNaoEncontradaException {
        String codigoVenda = "A3";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        venda.setStatus(Venda.Status.CANCELADA);
        vendaDao.alterar(venda);

        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        assertEquals(codigoVenda, vendaConsultada.getCodigo());
        assertEquals(Venda.Status.CANCELADA, vendaConsultada.getStatus());
    }

    @Test
    public void adicionarMaisProdutosDoMesmo() throws TipoChaveNaoEncontradaException {
        String codigoVenda = "A4";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        vendaConsultada.adicionarProduto(produto, 1);

        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(30)));
        assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
    }

    @Test
    public void adicionarMaisProdutosDiferentes() throws TipoChaveNaoEncontradaException {
        String codigoVenda = "A5";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        vendaConsultada.adicionarProduto(prod, 1);

        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));
        assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
    }

    @Test
    public void salvarProdutoExistente() throws TipoChaveNaoEncontradaException {
        Venda venda = criarVenda("A6");
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);

        Boolean retorno1 = vendaDao.cadastrar(venda);
        assertFalse(retorno1);
        assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
    }

    @Test
    public void removerProduto() throws TipoChaveNaoEncontradaException {
        String codigoVenda = "A7";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        vendaConsultada.adicionarProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));


        vendaConsultada.removerProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 2);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
        assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
    }

    @Test
    public void removerApenasUmProduto() throws TipoChaveNaoEncontradaException {
        String codigoVenda = "A8";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        vendaConsultada.adicionarProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));


        vendaConsultada.removerProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 2);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
        assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
    }

    @Test
    public void removerTodosProdutos() throws TipoChaveNaoEncontradaException {
        String codigoVenda = "A9";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        vendaConsultada.adicionarProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));


        vendaConsultada.removerTodosProdutos();
        assertTrue(venda.getQuantidadeTotalProdutos() == 0);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(0)));
        assertTrue(venda.getStatus().equals(Venda.Status.INICIADA));
    }

    @Test
    public void finalizarVenda() throws TipoChaveNaoEncontradaException {
        String codigoVenda = "A10";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        vendaDao.finalizarVenda(venda);

        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
        assertEquals(venda.getStatus(), vendaConsultada.getStatus());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tentarAdicionarProdutosVendaFinalizada() throws TipoChaveNaoEncontradaException {
        String codigoVenda = "A11";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        vendaDao.finalizarVenda(venda);
        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
        assertEquals(venda.getStatus(), vendaConsultada.getStatus());

        vendaConsultada.adicionarProduto(this.produto, 1);

    }

    private Produto cadastrarProduto(String codigo, BigDecimal valor) throws TipoChaveNaoEncontradaException {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(valor);
        produtoDao.cadastrar(produto);
        return produto;
    }

    private Cliente cadastrarCliente() throws TipoChaveNaoEncontradaException {
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Calleb Camargo");
        cliente.setCidade("Caldas Novas");
        cliente.setEstado("GO");
        cliente.setEnd("Rua 14, Número 60, Lt12");
        cliente.setCpf(12312345645L);
        cliente.setTel(64993331088L);
        clienteDao.cadastrar(cliente);
        return cliente;
    }

    private Venda criarVenda(String codigo) {
        Venda venda = new Venda();
        venda.setCodigo(codigo);
        venda.setDataVenda(Instant.now());
        venda.setCliente(this.cliente);
        venda.setStatus(Venda.Status.INICIADA);
        venda.adicionarProduto(this.produto, 2);
        return venda;
    }
}
