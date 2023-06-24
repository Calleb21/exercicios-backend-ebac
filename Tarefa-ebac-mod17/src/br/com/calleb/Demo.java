package br.com.calleb;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Carro> listaCarros = new ArrayList<>();

        Audi audi = new Audi();
        Ferrari ferrari = new Ferrari();
        Fiat fiat = new Fiat();
        Honda honda = new Honda();

        listaCarros.add(audi);
        listaCarros.add(ferrari);
        listaCarros.add(fiat);
        listaCarros.add(honda);

        for (Carro carro : listaCarros) {
            System.out.println("\nMarca: " + carro.getMarca());
            carro.acelerar();
        }
    }
}
