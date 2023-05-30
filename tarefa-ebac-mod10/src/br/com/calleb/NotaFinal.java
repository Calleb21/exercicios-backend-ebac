package br.com.calleb;

import java.util.Scanner;

public class NotaFinal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Olá, será que você foi aprovado? Vamos descobrir!");
        System.out.print("Digite a primeira nota: ");
        double primeiraNota = s.nextDouble();
        System.out.print("Digite a segunda nota: ");
        double segundaNota = s.nextDouble();
        System.out.print("Digite a terceira nota: ");
        double terceiraNota = s.nextDouble();
        System.out.print("Digite a quarta nota: ");
        double quartaNota = s.nextDouble();

        double notaFinal = calcNotaFinal(primeiraNota, segundaNota, terceiraNota, quartaNota);
        System.out.println("Sua nota final é: " + notaFinal);

        if (notaFinal >= 7 && notaFinal <= 10) {
            System.out.println("Aprovado! Parabéns.");
        } else if (notaFinal >= 5 && notaFinal < 7) {
            System.out.println("Recuperação! Estude mais.");
        } else if (notaFinal >= 0 && notaFinal < 5) {
            System.out.println("Reprovado! Não foi dessa vez.");
        } else {
            System.out.println("Nota inválida!");
        }
    }

    private static double calcNotaFinal(double primeiraNota, double segundaNota, double terceiraNota, double quartaNota) {
        double notaFinal = (primeiraNota + segundaNota + terceiraNota + quartaNota) / 4;
        return notaFinal;
    }
}
