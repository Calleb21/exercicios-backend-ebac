package br.com.calleb;

public class Cliente {

    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void adicionarNome(String nome) {
        setNome(nome);
    }

    public void adicionarIdade(int idade) {
        setIdade(idade);
    }
}
