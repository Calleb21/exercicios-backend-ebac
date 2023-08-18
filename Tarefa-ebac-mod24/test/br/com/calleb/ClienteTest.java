package br.com.calleb;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

    @Test
    public void testeClasseClienteNome() {
        Cliente cli = new Cliente();
        cli.adicionarNome("Calleb");

        Assert.assertEquals("Calleb", cli.getNome());
    }

    @Test
    public void testeClasseClienteIdade() {
        Cliente cli = new Cliente();
        cli.adicionarIdade(19);

        Assert.assertEquals(19, cli.getIdade());
    }
}
