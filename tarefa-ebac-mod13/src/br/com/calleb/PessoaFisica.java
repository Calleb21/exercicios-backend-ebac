package br.com.calleb;

public class PessoaFisica extends Pessoa{

    private String cpf;

    public PessoaFisica(String nome, String email, String endereco, String cpf) {
        super(nome, email, endereco);
        this.cpf = cpf;
    }

    @Override
    public void imprimirDados() {
        System.out.println("Pessoa Física:");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Endereco: " + getEndereco());
        System.out.println("CPF: " + cpf);
    }
}
