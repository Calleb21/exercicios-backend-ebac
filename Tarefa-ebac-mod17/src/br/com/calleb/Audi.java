package br.com.calleb;

public class Audi extends Carro{

    public Audi() {
        super("Audi");
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando Audi.");
    }
}
