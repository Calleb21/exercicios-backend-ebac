package br.com.calleb;

public class NotasMain {

    public static void main(String[] args) {

        double nota1 = 6.0;
        double nota2 = 8.6;
        double nota3 = 10.0;
        double nota4 = 4.9;

        double media = calcMedia(nota1, nota2, nota3, nota4);
        System.out.printf("Média final: %.2f", media);
    }

    private static double calcMedia(double nota1, double nota2, double nota3, double nota4) {
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        return media;
    }
}
