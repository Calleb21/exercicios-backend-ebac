package br.com.calleb;

public class FabricaFiatUno implements FabricaCarro {

    @Override
    public Carro criarCarro() {
        return new FiatUno();
    }
}
