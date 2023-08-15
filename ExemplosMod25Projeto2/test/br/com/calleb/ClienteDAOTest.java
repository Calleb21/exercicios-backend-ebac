package br.com.calleb;

import br.com.calleb.dao.ClienteDAOMock;
import br.com.calleb.dao.IClienteDAO;
import br.com.calleb.domain.Cliente;
import br.com.calleb.exceptions.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Description of ClienteDaoTest
 * Created by calle on 02/08/2023.
 */

public class ClienteDAOTest {

    private IClienteDAO clienteDAO;
    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDAO = new ClienteDAOMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Calleb Camargo");
        cliente.setCidade("Caldas Novas");
        cliente.setEstado("GO");
        cliente.setEnd("Rua 14, Número 60, Lt12");
        cliente.setCpf(12312345645L);
        cliente.setTel(64993331088L);
        cliente.setNumero(19);
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void excluirCliente() {
        clienteDAO.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Calleb C. Camargo");
        clienteDAO.alterar(cliente);
        Assert.assertEquals("Calleb C. Camargo", cliente.getNome());
    }
}



