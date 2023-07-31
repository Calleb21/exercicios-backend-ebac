package br.com.calleb;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class MainTest {

    @Test
    public void testFiltrarMulheres() {
        List<Pessoa> pessoas = List.of(
                new Pessoa("Calleb", Pessoa.Sexo.Masculino),
                new Pessoa("Rayane", Pessoa.Sexo.Femenino),
                new Pessoa("Guilherme", Pessoa.Sexo.Masculino),
                new Pessoa("Rafaela", Pessoa.Sexo.Femenino),
                new Pessoa("Bruno", Pessoa.Sexo.Masculino),
                new Pessoa("Joana", Pessoa.Sexo.Femenino)
        );

        List<Pessoa> mulheres = Main.filtrarMulheres(pessoas);

        assertEquals(3, mulheres.size());

        for (Pessoa pessoa : mulheres) {
            assertEquals(Pessoa.Sexo.Femenino, pessoa.getSexo());
        }
    }
}

