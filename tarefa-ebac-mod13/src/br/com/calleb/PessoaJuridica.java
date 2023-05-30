package br.com.calleb;

public class PessoaJuridica extends Pessoa{

    private String cnpj;

    public PessoaJuridica(String nome, String email, String endereco, String cnpj) {
        super(nome, email, endereco);
        this.cnpj = cnpj;
    }

    @Override
    public void imprimirDados() {
        System.out.println("Pessoa Jurídica: ");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Endereco: " + getEndereco());
        System.out.println("CNPJ: " + cnpj);
    }
}
