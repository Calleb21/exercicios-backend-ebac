package br.com.calleb;

abstract class Carro {

    protected String marca;

    public Carro(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public abstract void acelerar();
}
