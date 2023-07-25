package br.com.calleb;

import java.util.ArrayList;
import java.util.List;

/**
 * @author calle
 */
public class Main {

    public static void main(String[] args) {
        List<Pessoas> pessoas = new ArrayList<>();
        pessoas.add(new Pessoas("Calleb", Pessoas.Sexo.Masculino));
        pessoas.add(new Pessoas("Rayane", Pessoas.Sexo.Femenino));
        pessoas.add(new Pessoas("Guilherme", Pessoas.Sexo.Masculino));
        pessoas.add(new Pessoas("Rafaela", Pessoas.Sexo.Femenino));
        pessoas.add(new Pessoas("Bruno", Pessoas.Sexo.Masculino));
        pessoas.add(new Pessoas("Joana", Pessoas.Sexo.Femenino));

        List<Pessoas> mulheres = filtrarMulheres(pessoas);
        mulheres.forEach(pessoas1 -> System.out.println(pessoas1.getNome()));
    }

    private static List<Pessoas> filtrarMulheres(List<Pessoas> pessoas) {
        return pessoas.stream()
                .filter(pessoas1 -> pessoas1.getSexo() == Pessoas.Sexo.Femenino)
                .toList();
    }
}
