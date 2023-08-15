package br.com.calleb;

import br.com.calleb.dao.ClienteDAOMock;
import br.com.calleb.dao.IClienteDAO;
import br.com.calleb.domain.Cliente;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;
import br.com.calleb.service.ClienteService;
import br.com.calleb.service.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Description of ClienteTest
 * Created by calle on 01/08/2023.
 */
public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Calleb Camargo");
        cliente.setCidade("Caldas Novas");
        cliente.setEstado("GO");
        cliente.setEnd("Rua 14, Número 60, Lt12");
        cliente.setTel(64993331088L);
        cliente.setNumero(19);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Calleb C. Camargo");
        clienteService.alterar(cliente);
        Assert.assertEquals("Calleb C. Camargo", cliente.getNome());
    }

    @Test
    public void salvarClientePorCpf() throws TipoChaveNaoEncontradaException {
        Long cpf = 12345678900L;
        clienteService.salvar(cpf);
        Cliente clienteSalvo = clienteService.buscarPorCPF(cpf);
        Assert.assertNotNull(clienteSalvo);
        // Aqui você pode adicionar mais asserções para verificar se o cliente foi criado corretamente com o CPF informado.
        Assert.assertEquals(cpf, clienteSalvo.getCpf());
    }
}
