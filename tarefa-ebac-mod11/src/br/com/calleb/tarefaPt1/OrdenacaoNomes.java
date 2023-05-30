package br.com.calleb.tarefaPt1;

import java.util.Arrays;

public class OrdenacaoNomes {

    public static void main(String[] args) {
        String nomes = "Cirilo Joaquino, Luis Amilton , Lionel Messias, Kevin Bruyneiro";

        String[] nomeArray = nomes.split(", ");
        System.out.println("Nome não ordenados: ");
        for (String nome : nomeArray) {
            System.out.println(nome);
        }

        Arrays.sort(nomeArray);
        System.out.println("\nNomes ordenados em ordem alfabética: ");
        for (String nome : nomeArray) {
            System.out.println(nome);
        }
    }
}
