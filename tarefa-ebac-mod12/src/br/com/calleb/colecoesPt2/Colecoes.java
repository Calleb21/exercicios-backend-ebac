package br.com.calleb.colecoesPt2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Colecoes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();

        System.out.println("Digite o nome e o sexo (M ou F) separados por vírgula (exemplo: João,M, Maria,F...):");
        String input = scanner.nextLine();

        String[] pessoas = input.split(",");

        for (int i = 0; i < pessoas.length; i += 2) {
            String nome = pessoas[i].trim();
            String sexo = pessoas[i + 1].trim();

            if (sexo.equalsIgnoreCase("M")) {
                masculino.add(nome);
            } else if (sexo.equalsIgnoreCase("F")) {
                feminino.add(nome);
            }
        }

        System.out.println("\nGrupo Masculino:");
        for (String nome : masculino) {
            System.out.println(nome);
        }

        System.out.println("\nGrupo Feminino:");
        for (String nome : feminino) {
            System.out.println(nome);
        }

        scanner.close();
    }
}





