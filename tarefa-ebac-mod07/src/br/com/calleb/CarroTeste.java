package br.com.calleb;

public class CarroTeste {

    public static void main(String[] args) {

        // Criação de objetos Carro
        Carro carro1 = new Carro("BMW", "BMW M1", "Azul Caneta", 350);
        Carro carro2 = new Carro("Ferrari", "LaFerrari", "Vermelho", 399);

        // Impressão dos detalhes dos carros
        carro1.imprimirDetalhes();
        System.out.println();
        carro2.imprimirDetalhes();
    }
}
