package br.com.calleb;

import org.junit.Assert;
import org.junit.Test;

public class TesteClienteTest {

    @Test
    public void testeClasseCliente() {
        TesteCliente cli = new TesteCliente();
        cli.adicionarNome("Calleb");
        cli.adicionarNome1("Calleb");

        Assert.assertEquals("Calleb", cli.getNome());
    }
}
