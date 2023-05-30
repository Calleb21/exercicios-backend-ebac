package br.com.calleb;

public class PessoaTeste {

    public static void main(String[] args) {

        PessoaFisica pessoaFisica = new PessoaFisica("Jorge André", "jorgeandre@email.com","Rua: A, 123", "123.456.789.10");
        pessoaFisica.imprimirDados();

        System.out.println();

        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa WYZ", "wyzempresa@email.com","Avenida S, 321", "109.876.543.21");
        pessoaJuridica.imprimirDados();
    }
}
