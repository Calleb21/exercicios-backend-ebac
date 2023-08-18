package br.com.calleb;


import br.com.calleb.dao.ContratoDAO;
import br.com.calleb.dao.IContratoDAO;
import br.com.calleb.dao.mocks.ContratoDAOMock;
import br.com.calleb.service.ContratoService;
import br.com.calleb.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author calle
 */
public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroNoSalvarComBancoDeDados() {
        IContratoDAO dao = new ContratoDAO();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void BuscarTest() {
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.bucar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroNoBuscarComBancoDeDados() {
        IContratoDAO dao = new ContratoDAO();
        IContratoService service = new ContratoService(dao);
        String retorno = service.bucar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void ExcluirTest() {
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroNoExcluirComBancoDeDados() {
        IContratoDAO dao = new ContratoDAO();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void atualizarTest() {
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperandoErroNoAtualizarComBancoDeDados() {
        IContratoDAO dao = new ContratoDAO();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Sucesso", retorno);
    }
}
