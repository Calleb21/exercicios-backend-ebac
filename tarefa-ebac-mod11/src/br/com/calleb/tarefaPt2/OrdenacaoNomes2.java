package br.com.calleb.tarefaPt2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrdenacaoNomes2 {

    public static void main(String[] args) {
        String nomes = "João Fernando(M), Maria Bianca(F), Pedro Gomes(M), Ana Julia(F), Carlos Eduardo(M), Laura Grazi(F)";

        String[] nomeArray = nomes.split(", ");

        Map<String, String[]> nomesPorSexo = new HashMap<>();
        nomesPorSexo.put("M", new String[]{});
        nomesPorSexo.put("F", new String[]{});

        for (String nomeSexo : nomeArray) {
            String nome = nomeSexo.split("\\(")[0];
            String sexo = nomeSexo.split("\\(")[1].replace(")", "");

            String[] nomesDoSexo = nomesPorSexo.get(sexo);
            nomesDoSexo = Arrays.copyOf(nomesDoSexo, nomesDoSexo.length + 1);
            nomesDoSexo[nomesDoSexo.length - 1] = nome;
            nomesPorSexo.put(sexo, nomesDoSexo);
        }

        for (String sexo : nomesPorSexo.keySet()) {
            String[] nomesDoSexo = nomesPorSexo.get(sexo);
            Arrays.sort(nomesDoSexo);
            nomesPorSexo.put(sexo, nomesDoSexo);
        }

        for (String sexo : nomesPorSexo.keySet()) {
            System.out.println("Nomes " + (sexo.equals("M") ? "masculinos:" : "femininos:"));
            String[] nomesDoSexo = nomesPorSexo.get(sexo);
            for (String nome : nomesDoSexo) {
                System.out.println(nome);
            }
            System.out.println();
        }
    }
}

