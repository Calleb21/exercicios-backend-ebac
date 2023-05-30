package br.com.calleb;

public class Carro {

    private String marca;
    private  String modelo;
    private String cor;
    private int velocidadeMaxia;

    // Construtor da classe Carro
    public Carro(String marca, String modelo, String cor, int velocidadeMaxia) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocidadeMaxia = velocidadeMaxia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getVelocidadeMaxia() {
        return velocidadeMaxia;
    }

    public void setVelocidadeMaxia(int velocidadeMaxia) {
        this.velocidadeMaxia = velocidadeMaxia;
    }

    // Métdo para impimir os detalhes do caroo
    public void imprimirDetalhes(){
        System.out.println("Nome: " + marca);
        System.out.println("Cor: " + cor);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidade máxima: " + velocidadeMaxia);
    }
}
