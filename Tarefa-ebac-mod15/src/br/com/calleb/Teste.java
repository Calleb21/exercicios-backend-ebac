package br.com.calleb;

public class Teste {

    public static void main(String[] args) {

        FabricaCarro fabricaCarro = new FabricaFerrari();
        System.out.println("Fabricar Ferrari: ");
        Carro ferrari = fabricaCarro.criarCarro();
        ferrari.montar();

        System.out.println();

        FabricaCarro fabricaCarro1 = new FabricaFiatUno();
        System.out.println("Fabricar Fiat: ");
        Carro fiatUno = fabricaCarro1.criarCarro();
        fiatUno.montar();
    }
}
