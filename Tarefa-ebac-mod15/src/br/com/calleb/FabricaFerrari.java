package br.com.calleb;

public class FabricaFerrari implements FabricaCarro {

    @Override
    public Carro criarCarro() {
        return new Ferrari();
    }
}
