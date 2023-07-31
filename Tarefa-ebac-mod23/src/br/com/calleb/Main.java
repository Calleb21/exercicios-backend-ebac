package br.com.calleb;

import java.util.ArrayList;
import java.util.List;

/**
 * @author calle
 */
public class Main {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Calleb", Pessoa.Sexo.Masculino));
        pessoas.add(new Pessoa("Rayane", Pessoa.Sexo.Femenino));
        pessoas.add(new Pessoa("Guilherme", Pessoa.Sexo.Masculino));
        pessoas.add(new Pessoa("Rafaela", Pessoa.Sexo.Femenino));
        pessoas.add(new Pessoa("Bruno", Pessoa.Sexo.Masculino));
        pessoas.add(new Pessoa("Joana", Pessoa.Sexo.Femenino));

        List<Pessoa> mulheres = filtrarMulheres(pessoas);
        mulheres.forEach(pessoa -> System.out.println(pessoa.getNome()));
    }

    static List<Pessoa> filtrarMulheres(List<Pessoa> pessoas) {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getSexo() == Pessoa.Sexo.Femenino)
                .toList();
    }
}
