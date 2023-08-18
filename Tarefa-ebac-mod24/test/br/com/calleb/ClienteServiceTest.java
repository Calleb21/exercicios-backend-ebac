package br.com.calleb;

import br.com.calleb.dao.ClienteDAO;
import br.com.calleb.dao.ClienteDAOMock;
import br.com.calleb.dao.IClienteDAO;
import br.com.calleb.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author calle
 */
public class ClienteServiceTest {

    @Test
    public void salvarTest() {
        IClienteDAO mockDao = new ClienteDAOMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IClienteDAO mockDao = new ClienteDAO();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
}
